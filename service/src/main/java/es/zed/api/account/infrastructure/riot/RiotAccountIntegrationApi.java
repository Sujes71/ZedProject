package es.zed.api.account.infrastructure.riot;

import static es.zed.api.account.domain.ports.outbound.RiotApiAccountPort.GET_ACCOUNT_BY_PUUID_ADDRESS;
import static es.zed.api.account.domain.ports.outbound.RiotApiAccountPort.GET_ACCOUNT_BY_RIOT_ID_ADDRESS;
import static es.zed.api.account.domain.ports.outbound.RiotApiAccountPort.GET_ACCOUNT_ME_ADDRESS;

import es.zed.api.account.domain.model.AccountFilter;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.account.infrastructure.riot.mapper.RiotAccountUrlMapper;
import es.zed.api.shared.domain.ports.outbound.EventListenerRegistry;
import es.zed.api.shared.rest.handlers.RestHandler;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class RiotAccountIntegrationApi extends RestHandler {

  private final EventListenerRegistry registry;
  private final RiotAccountUrlMapper riotAccountUrlMapper;

  public RiotAccountIntegrationApi(EventListenerRegistry registry, RestTemplate restTemplate,
	  RiotAccountUrlMapper riotAccountUrlMapper) {
	  super(restTemplate);
	  this.registry = registry;
	  this.riotAccountUrlMapper = riotAccountUrlMapper;
  }

  @PostConstruct
  public void register() {
    registry.register(GET_ACCOUNT_BY_PUUID_ADDRESS, this::getAccountByPuuId);
    registry.register(GET_ACCOUNT_BY_RIOT_ID_ADDRESS, this::getAccountByRiotId);
    registry.register(GET_ACCOUNT_ME_ADDRESS, v -> getAccountMe());
  }

  public Mono<AccountDto> getAccountByPuuId(String puuid) {
    return doCall(riotAccountUrlMapper.mapUrlGetAccountByPuuId(puuid), HttpMethod.GET, null, AccountDto.class);
  }

  public Mono<AccountDto> getAccountByRiotId(AccountFilter filter) {
    return doCall(riotAccountUrlMapper.mapUrlGetAccountByRiotId(filter), HttpMethod.GET, null, AccountDto.class);
  }

  public Mono<AccountDto> getAccountMe() {
    return doCall(riotAccountUrlMapper.mapUrlAccountMe(), HttpMethod.GET, null, AccountDto.class);
  }
}