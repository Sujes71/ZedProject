package es.zed.api.account.infrastructure.riot.mapper;

import static es.zed.api.shared.infrastructure.riot.mapper.UrlMapper.mapUrl;

import es.zed.api.account.domain.model.AccountFilter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RiotAccountUrlMapper {

  @Value("${riot.base.path}")
  private String basePath;
	@Value("${riot.account.by-puuid.path}")
	private String accountByPuuIdPath;
  @Value("${riot.account.by-riot-id.path}")
  private String accountByRiotIdPath;
  @Value("${riot.account.me.path}")
  private String accountMePath;

	public String mapUrlGetAccountByPuuId(String puuid) {
		Map<String, String> params = new HashMap<>();
		params.put("{puuid}", puuid);
		return mapUrl(params, basePath.concat(accountByPuuIdPath));
	}

  public String mapUrlGetAccountByRiotId(AccountFilter filter) {
    Map<String, String> params = new HashMap<>();
    params.put("{gameName}", filter.getGameName());
    params.put("{tagLine}", filter.getTagLine());
    return mapUrl(params, basePath.concat(accountByRiotIdPath));
  }

  public String mapUrlAccountMe() {
    return basePath.concat(accountMePath);
  }
}
