package es.zed.api.match.domain.ports.outbound;

import static es.zed.api.shared.domain.ports.outbound.OutboundPort.requestEvent;

import es.zed.api.match.domain.model.MatchFilter;
import es.zed.api.shared.domain.model.Message;
import java.util.List;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MatchRiotApiPort {

  public static final String GET_MATCHES_BY_ACCOUNT_ID_ADDRESS = "getMatchesByAccountIdAddress";

  private MatchRiotApiPort() {
  }

  public Mono<List<String>> getMatchesByAccountId(MatchFilter filter) {
    return requestEvent(new Message<>(GET_MATCHES_BY_ACCOUNT_ID_ADDRESS, filter));
  }
}
