package es.zed.api.account.infrastructure.riot;

import static es.zed.api.account.domain.ports.outbound.RiotApiAccountPort.GET_ACCOUNT_BY_PUUID_ADDRESS;
import static es.zed.api.shared.infrastructure.riot.mapper.UrlMapper.mapUrl;

import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.account.infrastructure.riot.mapper.UrlAccountMapper;
import es.zed.api.shared.domain.ports.outbound.EventListenerRegistry;
import es.zed.api.shared.rest.handlers.RestHandler;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class RiotAccountIntegrationApi extends RestHandler {

  @Value("${riot.base.path}${riot.account.by-puuid.path}")
  private String accountByPuuIdPath;

  private final EventListenerRegistry registry;

  public RiotAccountIntegrationApi(EventListenerRegistry registry) {
    this.registry = registry;
  }

  @PostConstruct
  public void register() {
    registry.register(GET_ACCOUNT_BY_PUUID_ADDRESS, this::getAccountByPuuId);
  }

  public Mono<AccountDto> getAccountByPuuId(String puuid) {
    Map<String, String> params = new HashMap<>();
    params.put("{puuid}", puuid);
    return doCall(mapUrl(params, accountByPuuIdPath), HttpMethod.GET, addDefaultHeaders(), null, AccountDto.class);
  }
}