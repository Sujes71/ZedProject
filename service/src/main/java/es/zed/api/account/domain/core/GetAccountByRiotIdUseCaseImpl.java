package es.zed.api.account.domain.core;

import static es.zed.api.account.infrastructure.riot.dto.AccountDto.dtoToAccount;

import es.zed.api.account.domain.model.AccountFilter;
import es.zed.api.account.domain.ports.inbound.GetAccountByRiotIdUseCase;
import es.zed.api.account.domain.ports.outbound.AccountPersistencePort;
import es.zed.api.account.domain.ports.outbound.AccountRiotApiPort;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetAccountByRiotIdUseCaseImpl implements GetAccountByRiotIdUseCase {

  private static final Logger log = LogManager.getLogger(GetAccountByRiotIdUseCaseImpl.class);

  private final AccountRiotApiPort accountRiotApiPort;
  private final AccountPersistencePort accountPersistencePort;

	public GetAccountByRiotIdUseCaseImpl(AccountRiotApiPort accountRiotApiPort,
		AccountPersistencePort accountPersistencePort) {
		this.accountRiotApiPort = accountRiotApiPort;
		this.accountPersistencePort = accountPersistencePort;
	}

  @Override
  public Mono<AccountDto> execute(AccountFilter filter) {
    return accountPersistencePort.getAccountByRiotIdDb(filter)
        .flatMap(account -> Mono.just(dtoToAccount(account)))
        .switchIfEmpty(
            Mono.defer(() -> {
              log.info("No record found in the database, calling the API...");
              return accountRiotApiPort.getAccountByRiotId(filter)
                  .flatMap(accountDto -> accountPersistencePort.saveAccountDb(accountDto)
                      .thenReturn(accountDto));
            })
        );
  }
}
