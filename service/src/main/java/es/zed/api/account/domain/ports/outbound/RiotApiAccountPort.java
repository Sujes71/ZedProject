package es.zed.api.account.domain.ports.outbound;

import static es.zed.api.shared.domain.ports.outbound.OutboundPort.requestEvent;

import es.zed.api.account.domain.model.AccountFilter;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.shared.domain.model.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RiotApiAccountPort {

  public static final String GET_ACCOUNT_BY_PUUID_ADDRESS = "getAccountByPuuIdAddress";
  public static final String GET_ACCOUNT_BY_RIOT_ID_ADDRESS = "getAccountByRiotIdAddress";
  public static final String GET_ACCOUNT_ME_ADDRESS = "getAccountMeAddress";


  private RiotApiAccountPort() {
  }

    public Mono<AccountDto> getAccountByPuuId(String puuid) {
      return requestEvent(
          Message.<String>builder()
              .address(GET_ACCOUNT_BY_PUUID_ADDRESS)
              .body(puuid)
              .build()
      );
  }

  public Mono<AccountDto> getAccountByRiotId(AccountFilter filter) {
    return requestEvent(
        Message.<AccountFilter>builder()
            .address(GET_ACCOUNT_BY_RIOT_ID_ADDRESS)
            .body(filter)
            .build()
    );
  }

  public Mono<AccountDto> getAccountMe() {
    return requestEvent(
        Message.<Void>builder()
            .address(GET_ACCOUNT_ME_ADDRESS)
            .body(null)
            .build()
    );
  }
}
