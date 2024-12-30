package es.zed.api.match.domain.core;

import es.zed.api.match.domain.model.MatchFilter;
import es.zed.api.match.domain.ports.inbound.GetMatchesByAccountIdUseCase;
import es.zed.api.match.domain.ports.outbound.MatchRiotApiPort;
import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetMatchesByAccountIdUseCaseImpl implements GetMatchesByAccountIdUseCase {

  private final MatchRiotApiPort matchRiotApiPort;

  public GetMatchesByAccountIdUseCaseImpl(MatchRiotApiPort matchRiotApiPort) {
    this.matchRiotApiPort = matchRiotApiPort;
  }

  @Override
  public Mono<List<String>> execute(MatchFilter filter) {
    return matchRiotApiPort.getMatchesByAccountId(filter);
  }
}
