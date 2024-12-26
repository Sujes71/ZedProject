package es.zed.api.account.domain.core;

import es.zed.api.account.domain.model.AccountFilter;
import es.zed.api.account.domain.ports.inbound.GetAccountByRiotIdUseCase;
import es.zed.api.account.domain.ports.outbound.RiotApiAccountPort;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetAccountByRiotIdUseCaseImpl implements GetAccountByRiotIdUseCase {

  private final RiotApiAccountPort riotApiAccountPort;

  public GetAccountByRiotIdUseCaseImpl(RiotApiAccountPort riotApiAccountPort) {
    this.riotApiAccountPort = riotApiAccountPort;
  }

  @Override
  public Mono<AccountDto> execute(AccountFilter filter) {
    return riotApiAccountPort.getAccountByRiotId(filter);
  }
}
