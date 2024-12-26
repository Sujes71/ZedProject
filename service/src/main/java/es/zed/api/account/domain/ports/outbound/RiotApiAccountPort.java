package es.zed.api.account.domain.ports.outbound;

import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.shared.domain.model.Message;
import es.zed.api.shared.domain.ports.outbound.OutboundPort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RiotApiAccountPort {

  public static final String GET_ACCOUNT_BY_PUUID_ADDRESS = "getAccountByPuuIdAddress";

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


}
