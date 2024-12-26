package es.zed.api.account.infrastructure.riot;

import static es.zed.api.account.domain.ports.outbound.RiotApiAccountPort.GET_ACCOUNT_BY_PUUID_ADDRESS;

import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.shared.domain.ports.outbound.handler.EventListenerRegistry;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class RiotAccountIntegrationApi {

  private final EventListenerRegistry registry;

  public RiotAccountIntegrationApi(EventListenerRegistry registry) {
    this.registry = registry;
  }

  @PostConstruct
  public void register() {
    registry.register(GET_ACCOUNT_BY_PUUID_ADDRESS, this::getAccountByPuuId);
  }

  public Mono<AccountDto> getAccountByPuuId(String body) {
    return Mono.just(AccountDto.builder().puuid(body).build());
  }
}