package es.zed.api.shared.infrastructure.riot.mapper;

import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class UrlMapper {

  public static String mapUrl(Map<String, String> replacements, String path) {
    for (Map.Entry<String, String> entry : replacements.entrySet()) {
      path = path.replace(entry.getKey(), entry.getValue());
    }

    return path;
  }
}
