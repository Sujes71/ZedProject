package es.zed.api.account.domain.ports.outbound;

import static es.zed.api.shared.domain.ports.outbound.OutboundPort.requestEvent;

import es.zed.api.account.domain.model.AccountFilter;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.shared.domain.model.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AccountRiotApiPort {

  public static final String GET_ACCOUNT_BY_RIOT_ID_ADDRESS = "getAccountByRiotIdAddress";

  private AccountRiotApiPort() {
  }

  public Mono<AccountDto> getAccountByRiotId(AccountFilter filter) {
    return requestEvent(new Message<>(GET_ACCOUNT_BY_RIOT_ID_ADDRESS, filter));
  }
}