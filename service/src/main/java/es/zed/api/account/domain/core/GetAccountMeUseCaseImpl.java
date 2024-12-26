package es.zed.api.account.domain.core;

import es.zed.api.account.domain.ports.inbound.GetAccountMeUseCase;
import es.zed.api.account.domain.ports.outbound.RiotApiAccountPort;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetAccountMeUseCaseImpl implements GetAccountMeUseCase {

  private final RiotApiAccountPort riotApiAccountPort;

  public GetAccountMeUseCaseImpl(RiotApiAccountPort riotApiAccountPort) {
    this.riotApiAccountPort = riotApiAccountPort;
  }

  @Override
  public Mono<AccountDto> execute() {
    return riotApiAccountPort.getAccountMe();
  }
}
