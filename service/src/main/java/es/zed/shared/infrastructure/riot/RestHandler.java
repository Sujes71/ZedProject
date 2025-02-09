package es.zed.shared.infrastructure.riot;

import java.net.URI;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Component
public abstract class RestHandler {

  private static final Logger log = LogManager.getLogger(RestHandler.class);

  @Value("${riot.api.key}")
  private String apiKey;

  private final WebClient webClient;

  protected RestHandler(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.build();
  }

  public <T> Mono<T> doCall(final String url, final HttpMethod httpMethod, final Object body, final Class<T> responseClass) {
    return doCallInternal(url, httpMethod, body, responseClass, null);
  }

  public <T> Mono<T> doCall(final String url, final HttpMethod httpMethod, final Object body, final ParameterizedTypeReference<T> responseType) {
    return doCallInternal(url, httpMethod, body, null, responseType);
  }

  private <T> Mono<T> doCallInternal(
      final String url,
      final HttpMethod httpMethod,
      final Object body,
      final Class<T> responseClass,
      final ParameterizedTypeReference<T> responseType
  ) {
    log.info("Do call {}, method {}", url, httpMethod);

    RequestBodySpec request = webClient.method(httpMethod)
        .uri(URI.create(url))
        .headers(headers -> headers.add("X-Riot-Token", apiKey));

    if (Objects.nonNull(body)) {
      request.bodyValue(body);
    }

    ResponseSpec responseSpec = request.retrieve();

    Mono<T> response;
    if (Objects.nonNull(responseClass)) {
      response = responseSpec.bodyToMono(responseClass);
    } else if (Objects.nonNull(responseType)) {
      response = responseSpec.bodyToMono(responseType);
    } else {
      throw new IllegalArgumentException("Either responseClass or responseType must be provided");
    }

    return response
        .doOnError(WebClientResponseException.class, ex ->
            log.error("HTTP error occurred: {}", ex.getMessage(), ex))
        .onErrorResume(WebClientResponseException.class, ex ->
            Mono.error(new RuntimeException("Error occurred during HTTP call", ex)));
  }
}