package es.zed.api.account.domain.core;

import es.zed.api.account.domain.ports.inbound.GetAccountByPuuIdUseCase;
import es.zed.api.account.domain.ports.outbound.RiotApiAccountPort;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetAccountByPuuIdUseCaseImpl implements GetAccountByPuuIdUseCase {

  private final RiotApiAccountPort riotApiAccountPort;

  public GetAccountByPuuIdUseCaseImpl(RiotApiAccountPort riotApiAccountPort) {
    this.riotApiAccountPort = riotApiAccountPort;
  }

  @Override
  public Mono<AccountDto> execute(String puuid) {
    return riotApiAccountPort.getAccountByPuuId(puuid);
  }
}
