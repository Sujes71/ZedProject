package es.zed.api.account.infrastructure.riot.mapper;

import static es.zed.api.shared.infrastructure.riot.mapper.UrlMapper.mapUrl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RiotAccountUrlMapper {

	@Value("${riot.base.path}${riot.account.by-puuid.path}")
	private String accountByPuuIdPath;

	public String mapUrlGetAccountByPuuId(String puuid) {
		Map<String, String> params = new HashMap<>();
		params.put("{puuid}", puuid);
		return mapUrl(params, accountByPuuIdPath);
	}
}
