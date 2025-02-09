package es.zed.api.summoner.infrastructure.riot.mapper;

import static es.zed.shared.infrastructure.riot.mapper.UrlMapper.mapUrl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RiotSummonerUrlMapper {

	@Value("${riot.base.euw1.path}")
	private String basePath;
	@Value("${riot.summoner.by-puuid.path}")
	private String summonerByAccountIdPath;

	public String mapUrlGetSummonersByAccountId(String accountId) {
		Map<String, String> params = new HashMap<>();
		params.put("{encryptedPUUID}", accountId);
		return mapUrl(params, basePath.concat(summonerByAccountIdPath));
	}
}
