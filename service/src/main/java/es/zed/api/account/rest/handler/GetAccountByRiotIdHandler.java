package es.zed.api.account.rest.handler;

import es.zed.api.account.domain.model.AccountFilter;
import es.zed.api.account.domain.ports.inbound.GetAccountByRiotIdUseCase;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.shared.rest.handlers.Handler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GetAccountByRiotIdHandler implements Handler<AccountFilter, Mono<AccountDto>> {

  private final GetAccountByRiotIdUseCase getAccountByRiotIdUseCase;

  public GetAccountByRiotIdHandler(GetAccountByRiotIdUseCase getAccountByRiotIdUseCase) {
    this.getAccountByRiotIdUseCase = getAccountByRiotIdUseCase;
  }

  @Override
  public Mono<AccountDto> handle(AccountFilter filter) {
    return getAccountByRiotIdUseCase.execute(filter);
  }
}
