package es.zed.api.match.domain.core;

import es.zed.api.match.domain.model.MatchFilter;
import es.zed.api.match.domain.ports.inbound.GetMatchesByPuuIdUseCase;
import es.zed.api.match.domain.ports.outbound.MatchRiotApiPort;
import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetMatchesByPuuIdUseCaseImpl implements GetMatchesByPuuIdUseCase {

  private final MatchRiotApiPort matchRiotApiPort;

  public GetMatchesByPuuIdUseCaseImpl(MatchRiotApiPort matchRiotApiPort) {
    this.matchRiotApiPort = matchRiotApiPort;
  }

  @Override
  public Mono<List<String>> execute(MatchFilter filter) {
    return matchRiotApiPort.getMatchByPuuId(filter);
  }
}
