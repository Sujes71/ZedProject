package es.zed.api.account.rest.handlers;

import es.zed.api.account.domain.ports.inbound.GetAccountMeUseCase;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.shared.rest.handlers.NoInputHandler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GetAccountMeHandler implements NoInputHandler<Mono<AccountDto>> {

  private final GetAccountMeUseCase getAccountMeUseCase;

  public GetAccountMeHandler(GetAccountMeUseCase getAccountMeUseCase) {
    this.getAccountMeUseCase = getAccountMeUseCase;
  }

  @Override
  public Mono<AccountDto> handle() {
    return getAccountMeUseCase.execute();
  }
}
