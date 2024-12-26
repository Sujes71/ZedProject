package es.zed.api.shared.rest.handlers;

import java.net.URI;
import java.net.URISyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public abstract class RestHandler {
  @Value("${riot.api.key}")
  private String apiKey;

  private final RestTemplate restTemplate;

  protected RestHandler(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public <T> Mono<T> doCall(final String url, final HttpMethod httpMethod, final Object body, final Class<T> responseClass) {
  return Mono.defer(() -> {
    log.info("Do call {}, method {}", url, httpMethod);

    try {
      RequestEntity<Object> request = new RequestEntity<>(body, addDefaultHeaders(), httpMethod, createUri(url));

      ResponseEntity<T> response = restTemplate.exchange(request, responseClass);

      return Mono.just(extractResponseData(response));
    } catch (ResourceAccessException ex) {
      log.error("Connection error occurred: {}", ex.getMessage(), ex);
      return Mono.error(new Exception("Connection error occurred", ex));
    } catch (Exception ex) {
      log.error("Unexpected error occurred: {}", ex.getMessage(), ex);
      return Mono.error(new RuntimeException("Unexpected error occurred", ex));
    }
  });
}

  private HttpHeaders addDefaultHeaders() {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("X-Riot-Token", apiKey);
    return httpHeaders;
  }

  private URI createUri(final String uriPath) throws Exception {
    try {
      return new URI(uriPath);
    } catch (URISyntaxException ex) {
      throw new Exception("Uri generator error occurred", ex);
    }
  }

  private <T> T extractResponseData(final ResponseEntity<T> responseEntity) {
    return responseEntity.getBody();
  }

}