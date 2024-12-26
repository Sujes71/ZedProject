package es.zed.api.account.rest.handlers;

import es.zed.api.account.domain.ports.inbound.GetAccountByPuuIdUseCase;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.shared.rest.handlers.Handler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GetAccountByPuuIdHandler implements Handler<String, Mono<AccountDto>> {

 private final GetAccountByPuuIdUseCase getAccountByPuuIdUseCase;

  public GetAccountByPuuIdHandler(GetAccountByPuuIdUseCase getAccountByPuuIdUseCase) {
    this.getAccountByPuuIdUseCase = getAccountByPuuIdUseCase;
  }

  @Override
  public Mono<AccountDto> handle(String puuid) {
    return getAccountByPuuIdUseCase.execute(puuid);
  }
}
