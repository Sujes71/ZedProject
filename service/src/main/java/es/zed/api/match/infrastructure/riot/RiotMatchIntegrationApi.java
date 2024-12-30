package es.zed.api.match.infrastructure.riot;

import static es.zed.api.match.domain.ports.outbound.MatchRiotApiPort.GET_MATCHES_BY_ACCOUNT_ID_ADDRESS;
import static es.zed.api.shared.domain.ports.outbound.OutboundPort.register;

import es.zed.api.match.domain.model.MatchFilter;
import es.zed.api.match.infrastructure.riot.mapper.RiotMatchUrlMapper;
import es.zed.api.shared.infrastructure.riot.RestHandler;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.core.publisher.Mono;

@Component
public class RiotMatchIntegrationApi extends RestHandler {

  private final RiotMatchUrlMapper riotMatchUrlMapper;

  protected RiotMatchIntegrationApi(Builder webClientBuilder, RiotMatchUrlMapper riotMatchUrlMapper) {
    super(webClientBuilder);
    this.riotMatchUrlMapper = riotMatchUrlMapper;
  }

  @PostConstruct
  public void start() {
    register(GET_MATCHES_BY_ACCOUNT_ID_ADDRESS, this::getMatchesByAccountId);
  }

  private Mono<List<String>> getMatchesByAccountId(MatchFilter matchFilter) {
    return doCall(
        riotMatchUrlMapper.mapUrlGetMatchesByAccountId(matchFilter),
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<>() {
        }
    );
  }
}