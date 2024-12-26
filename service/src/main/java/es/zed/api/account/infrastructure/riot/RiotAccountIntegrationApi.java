package es.zed.api.account.infrastructure.riot;

import static es.zed.api.account.domain.ports.outbound.RiotApiAccountPort.GET_ACCOUNT_BY_PUUID_ADDRESS;

import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.shared.domain.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class RiotAccountIntegrationApi {

  @EventListener
  public Mono<AccountDto> handleBusEvent(Message<?, ?, ?> message) {
    if (GET_ACCOUNT_BY_PUUID_ADDRESS.equals(message.address())) {
      return Mono.just(getAccountByPuuId(message));
    }
    return Mono.error(new IllegalArgumentException("Address no reconocido"));
  }

  private <B, C, L> AccountDto getAccountByPuuId(Message<B, C, L> message) {
    return AccountDto.builder().puuid(message.body().toString()).build();
  }
}

