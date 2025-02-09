package es.zed.api.match.domain.ports.inbound;

import es.zed.api.match.domain.model.MatchFilter;
import es.zed.api.match.infrastructure.riot.dto.MatchDto;
import es.zed.shared.domain.ports.inbound.UseCase;
import java.util.List;
import reactor.core.publisher.Mono;

public interface GetMatchesByAccountIdUseCase extends UseCase<MatchFilter, Mono<List<MatchDto>>> {
}
