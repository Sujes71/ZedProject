package es.zed.api.match.domain.ports.outbound;

import static es.zed.api.shared.domain.ports.outbound.OutboundPort.requestEvent;

import es.zed.api.match.domain.model.MatchFilter;
import es.zed.api.match.infrastructure.riot.dto.MatchDto;
import es.zed.api.shared.domain.model.Message;
import java.util.List;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MatchRiotApiPort {

  public static final String GET_MATCHES_BY_ACCOUNT_ID_ADDRESS = "getMatchesByAccountIdAddress";
  public static final String GET_MATCHES_BY_MATCH_ID_ADDRESS = "getMatchByMatchIdAddress";

  private MatchRiotApiPort() {
  }

  public Mono<List<String>> getMatchesIdByAccountId(MatchFilter filter) {
    return requestEvent(new Message<>(GET_MATCHES_BY_ACCOUNT_ID_ADDRESS, filter));
  }

  public Mono<MatchDto> getMatchByMatchId(String matchId) {
    return requestEvent(new Message<>(GET_MATCHES_BY_MATCH_ID_ADDRESS, matchId));
  }
}