package es.zed.api.account.domain.ports.outbound;

import es.zed.api.account.domain.model.AccountFilter;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.shared.domain.model.Message;
import es.zed.api.shared.domain.ports.outbound.OutboundPort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RiotApiAccountPort {

  public static final String GET_ACCOUNT_BY_PUUID_ADDRESS = "getAccountByPuuIdAddress";
  public static final String GET_ACCOUNT_BY_RIOT_ID_ADDRESS = "getAccountByRiotIdAddress";
  public static final String GET_ACCOUNT_ME_ADDRESS = "getAccountMeAddress";

  private final OutboundPort outboundPort;

  public RiotApiAccountPort(OutboundPort outboundPort) {
    this.outboundPort = outboundPort;
  }

    public Mono<AccountDto> getAccountByPuuId(String puuid) {
      return outboundPort.requestEvent(
          Message.<String>builder()
              .address(GET_ACCOUNT_BY_PUUID_ADDRESS)
              .body(puuid)
              .build()
      );
  }

  public Mono<AccountDto> getAccountByRiotId(AccountFilter filter) {
    return outboundPort.requestEvent(
        Message.<AccountFilter>builder()
            .address(GET_ACCOUNT_BY_RIOT_ID_ADDRESS)
            .body(filter)
            .build()
    );
  }

  public Mono<AccountDto> getAccountMe() {
    return outboundPort.requestEvent(
        Message.<Void>builder()
            .address(GET_ACCOUNT_ME_ADDRESS)
            .body(null)
            .build()
    );
  }
}
