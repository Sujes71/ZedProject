package es.zed.api.account.domain.core;

import es.zed.api.account.domain.model.AccountFilter;
import es.zed.api.account.domain.ports.inbound.GetAccountByRiotIdUseCase;
import es.zed.api.account.domain.ports.outbound.AccountPersistencePort;
import es.zed.api.account.domain.ports.outbound.AccountRiotApiPort;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetAccountByRiotIdUseCaseImpl implements GetAccountByRiotIdUseCase {

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
			.switchIfEmpty(
				accountRiotApiPort.getAccountByRiotId(filter)
					.flatMap(account -> accountPersistencePort.saveAccountDb(account)
						.thenReturn(account))
			);
	}




}
