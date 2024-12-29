package es.zed.api.shared.infrastructure.riot;

import java.net.URI;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;


@Component
public abstract class RestHandler {

  @Value("${riot.api.key}")
  private String apiKey;

  private final WebClient webClient;

  private static final Logger log = LogManager.getLogger(RestHandler.class);


  protected RestHandler(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.build();
  }

  public <T> Mono<T> doCall(final String url, final HttpMethod httpMethod, final Object body, final Class<T> responseClass) {
    log.info("Do call {}, method {}", url, httpMethod);

    WebClient.RequestBodySpec request = webClient.method(httpMethod)
        .uri(URI.create(url))
        .headers(headers -> headers.add("X-Riot-Token", apiKey));

    if (Objects.nonNull(body)) {
      request.bodyValue(body);
    }

    return request.retrieve()
        .bodyToMono(responseClass)
        .doOnError(WebClientResponseException.class, ex ->
            log.error("HTTP error occurred: {}", ex.getMessage(), ex))
        .onErrorResume(WebClientResponseException.class, ex ->
            Mono.error(new RuntimeException("Error occurred during HTTP call", ex)));
  }
}
