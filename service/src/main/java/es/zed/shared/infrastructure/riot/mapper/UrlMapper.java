package es.zed.shared.infrastructure.riot.mapper;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UrlMapper {

  public static String mapUrl(Map<String, String> replacements, String path) {
    for (Map.Entry<String, String> entry : replacements.entrySet()) {
      path = path.replace(entry.getKey(), entry.getValue());
    }

    return path;
  }

  public static String buildQueryParams(Map<String, Object> queryParams) {
    return queryParams.entrySet().stream()
        .filter(entry -> Objects.nonNull(entry.getValue()))
        .map(entry -> entry.getKey() + "=" + entry.getValue())
        .collect(Collectors.joining("&"));
  }
}