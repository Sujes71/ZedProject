package es.zed.api.summoner.domain.ports.inbound;

import es.zed.api.summoner.infrastructure.riot.dto.SummonerDto;
import es.zed.shared.domain.ports.inbound.UseCase;
import reactor.core.publisher.Mono;

public interface GetSummonersByAccountIdUseCase extends UseCase<String, Mono<SummonerDto>> {
}
