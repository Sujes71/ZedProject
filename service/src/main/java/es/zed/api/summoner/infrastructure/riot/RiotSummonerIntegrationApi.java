package es.zed.api.summoner.infrastructure.riot;

import static es.zed.api.shared.domain.ports.outbound.OutboundPort.register;
import static es.zed.api.summoner.domain.ports.outbound.SummonerRiotApiPort.GET_SUMMONERS_BY_ACCOUNT_ID_ADDRESS;

import es.zed.api.shared.infrastructure.riot.RestHandler;
import es.zed.api.summoner.infrastructure.riot.dto.SummonerDto;
import es.zed.api.summoner.infrastructure.riot.mapper.RiotSummonerUrlMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.core.publisher.Mono;

@Component
public class RiotSummonerIntegrationApi extends RestHandler {

	private final RiotSummonerUrlMapper riotSummonerUrlMapper;

	protected RiotSummonerIntegrationApi(Builder webClientBuilder, RiotSummonerUrlMapper riotSummonerUrlMapper) {
		super(webClientBuilder);
		this.riotSummonerUrlMapper = riotSummonerUrlMapper;
	}

	@PostConstruct
	public void start() {
		register(GET_SUMMONERS_BY_ACCOUNT_ID_ADDRESS, this::getAccountByGameTag);
	}

	public Mono<SummonerDto> getAccountByGameTag(String accountId) {
		return doCall(
			riotSummonerUrlMapper.mapUrlGetSummonersByAccountId(accountId),
			HttpMethod.GET,
			null,
			SummonerDto.class);
	}
}
