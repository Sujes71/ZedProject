package es.zed.api.account.infrastructure.riot;

import static es.zed.api.account.domain.ports.outbound.AccountRiotApiPort.GET_ACCOUNT_BY_RIOT_ID_ADDRESS;
import static es.zed.api.shared.domain.ports.outbound.OutboundPort.register;

import es.zed.api.account.domain.model.AccountFilter;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.account.infrastructure.riot.mapper.RiotAccountUrlMapper;
import es.zed.api.shared.infrastructure.riot.RestHandler;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.core.publisher.Mono;

@Component
public class RiotAccountIntegrationApi extends RestHandler {

  private final RiotAccountUrlMapper riotAccountUrlMapper;

  public RiotAccountIntegrationApi(Builder webClientBuilder, RiotAccountUrlMapper riotAccountUrlMapper) {
	  super(webClientBuilder);
	  this.riotAccountUrlMapper = riotAccountUrlMapper;
  }

  @PostConstruct
  public void start() {
    register(GET_ACCOUNT_BY_RIOT_ID_ADDRESS, this::getAccountByRiotId);
  }

  public Mono<AccountDto> getAccountByRiotId(AccountFilter filter) {
    return doCall(riotAccountUrlMapper.mapUrlGetAccountByRiotId(filter), HttpMethod.GET, null, AccountDto.class);
  }

}