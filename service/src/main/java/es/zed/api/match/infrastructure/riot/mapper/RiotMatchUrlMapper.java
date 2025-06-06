package es.zed.api.match.infrastructure.riot.mapper;

import static es.zed.shared.infrastructure.riot.mapper.UrlMapper.buildQueryParams;
import static es.zed.shared.infrastructure.riot.mapper.UrlMapper.mapUrl;

import es.zed.api.match.domain.model.MatchFilter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RiotMatchUrlMapper {

  @Value("${riot.base.path}")
  private String basePath;
  @Value("${riot.match.by-puuid.path}")
  private String matchesIdByAccountIdPath;
  @Value("${riot.match.by-match-id.path}")
  private String matchesByMatchIdPath;

  public String mapUrlGetMatchesByAccountId(MatchFilter filter) {
    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("{puuid}", filter.getPuuid());
    String url = mapUrl(pathParams, basePath.concat(matchesIdByAccountIdPath));

    Map<String, Object> queryParams = new HashMap<>();
    queryParams.put("startTime", filter.getStartTime());
    queryParams.put("endTime", filter.getEndTime());
    queryParams.put("queue", filter.getQueue());
    queryParams.put("type", filter.getType());
    queryParams.put("start", filter.getStart());
    queryParams.put("count", filter.getCount());

    String queryString = buildQueryParams(queryParams);
    if (!queryString.isEmpty()) {
      url = url.concat("?").concat(queryString);
    }

    return url;
  }

  public String mapUrlGetMatchesByMatchId(String matchId) {
    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("{matchId}",matchId);
    return mapUrl(pathParams, basePath.concat(matchesByMatchIdPath));
  }
}