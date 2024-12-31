package es.zed.api.match.domain.core;

import es.zed.api.match.domain.model.MatchFilter;
import es.zed.api.match.domain.ports.inbound.GetMatchesByAccountIdUseCase;
import es.zed.api.match.domain.ports.outbound.MatchRiotApiPort;
import es.zed.api.match.infrastructure.riot.dto.MatchDto;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GetMatchesByAccountIdUseCaseImpl implements GetMatchesByAccountIdUseCase {

  private final MatchRiotApiPort matchRiotApiPort;

  public GetMatchesByAccountIdUseCaseImpl(MatchRiotApiPort matchRiotApiPort) {
    this.matchRiotApiPort = matchRiotApiPort;
  }

  @Override
  public Mono<List<MatchDto>> execute(MatchFilter filter) {
    return matchRiotApiPort.getMatchesIdByAccountId(filter)
        .flatMapMany(matchIds -> Flux.fromIterable(matchIds)
            .flatMap(matchRiotApiPort::getMatchByMatchId))
        .collectList()
        .map(matches -> {
          matches.sort(Comparator.comparingLong((MatchDto match) -> match.getInfo().getGameCreation()).reversed());
          return matches;
        });
  }

}
