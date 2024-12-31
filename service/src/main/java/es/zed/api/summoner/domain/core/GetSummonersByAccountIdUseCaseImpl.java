package es.zed.api.summoner.domain.core;

import es.zed.api.summoner.domain.ports.inbound.GetSummonersByAccountIdUseCase;
import es.zed.api.summoner.domain.ports.outbound.SummonerRiotApiPort;
import es.zed.api.summoner.infrastructure.riot.dto.SummonerDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetSummonersByAccountIdUseCaseImpl implements GetSummonersByAccountIdUseCase {

	private final SummonerRiotApiPort summonerRiotApiPort;

	public GetSummonersByAccountIdUseCaseImpl(SummonerRiotApiPort summonerRiotApiPort) {
		this.summonerRiotApiPort = summonerRiotApiPort;
	}

	@Override
	public Mono<SummonerDto> execute(String id) {
		return summonerRiotApiPort.getSummonersByAccountId(id);
	}
}
