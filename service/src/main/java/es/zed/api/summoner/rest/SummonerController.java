package es.zed.api.summoner.rest;

import static es.zed.api.shared.rest.Routing.GET_SUMMONERS_BY_ACCOUNT_ID_PATH;
import static es.zed.api.shared.rest.Routing.SUMMONER_PATH;

import es.zed.api.summoner.domain.ports.inbound.GetSummonersByAccountIdUseCase;
import es.zed.api.summoner.infrastructure.riot.dto.SummonerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(SUMMONER_PATH)
public class SummonerController {

	private final GetSummonersByAccountIdUseCase getSummonersByAccountIdUseCase;

	public SummonerController(GetSummonersByAccountIdUseCase getSummonersByAccountIdUseCase) {
		this.getSummonersByAccountIdUseCase = getSummonersByAccountIdUseCase;
	}

	@GetMapping(path = GET_SUMMONERS_BY_ACCOUNT_ID_PATH, produces = "application/json")
	public Mono<SummonerDto> getAccountByGameTag(@PathVariable String accountId) {
		return getSummonersByAccountIdUseCase.execute(accountId);
	}
}
