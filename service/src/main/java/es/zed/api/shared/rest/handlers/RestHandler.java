package es.zed.api.shared.rest.handlers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Component
public abstract class RestHandler {

  @Value("${riot.api.key}")
  private String apiKey;

  private static final RestTemplate restTemplate = new RestTemplate();

  public static <T> Mono<T> doCall(final String url, final HttpMethod httpMethod, final HttpHeaders httpHeaders, final Object body, final Class<T> responseClass) {
    return Mono.defer(() -> {
      log.info("Do call {}, method {}", url, httpMethod);

      try {
        RequestEntity<Object> request = new RequestEntity<>(body, httpHeaders, httpMethod, createUri(url));

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

  public HttpHeaders addDefaultHeaders() {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("X-Riot-Token", apiKey);
    return httpHeaders;
  }

  private static URI createUri(final String uriPath) throws Exception {
    try {
      return new URI(uriPath);
    } catch (URISyntaxException ex) {
      throw new Exception("Uri generator error occurred", ex);
    }
  }

  private static <T> T extractResponseData(final ResponseEntity<T> responseEntity) {
    return responseEntity.getBody();
  }

}