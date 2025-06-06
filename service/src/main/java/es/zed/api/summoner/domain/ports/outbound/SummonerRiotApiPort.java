package es.zed.api.summoner.domain.ports.outbound;

import static es.zed.shared.domain.ports.outbound.OutboundPort.requestEvent;

import es.zed.api.summoner.infrastructure.riot.dto.SummonerDto;
import es.zed.shared.domain.model.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class SummonerRiotApiPort {

	public static final String GET_SUMMONERS_BY_ACCOUNT_ID_ADDRESS = "getSummonersByAccountIdAddress";

	public SummonerRiotApiPort() {
	}

	public Mono<SummonerDto> getSummonersByAccountId(String id) {
		return requestEvent(new Message<>(GET_SUMMONERS_BY_ACCOUNT_ID_ADDRESS, id));
	}
}
