package es.zed.api.match.domain.core;

import es.zed.api.match.domain.model.MatchFilter;
import es.zed.api.match.domain.ports.inbound.GetMatchesByPuuIdUseCase;
import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetMatchesByPuuIdUseCaseImpl implements GetMatchesByPuuIdUseCase {

  @Override
  public Mono<List<String>> execute(MatchFilter input) {
    return Mono.just(List.of());
  }
}
