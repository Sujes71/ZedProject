package es.zed.api.account.domain.ports.outbound;

import static es.zed.shared.domain.ports.outbound.OutboundPort.requestEvent;

import es.zed.api.account.domain.model.AccountFilter;
import es.zed.api.account.infrastructure.repository.postgres.entity.Account;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.shared.domain.model.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AccountPersistencePort {

	public static final String GET_ACCOUNT_BY_GAME_TAG_DB_ADDRESS = "getAccountByGameTagDbAddress";
	public static final String SAVE_ACCOUNT_DB_ADDRESS = "saveAccountDbAddress";

	private AccountPersistencePort(){
	}

	public Mono<Account> getAccountByGameTagDb(AccountFilter filter) {
		return requestEvent(new Message<>(GET_ACCOUNT_BY_GAME_TAG_DB_ADDRESS, filter));
	}

	public Mono<Void> saveAccount(AccountDto accountDto) {
		return requestEvent(new Message<>(SAVE_ACCOUNT_DB_ADDRESS, accountDto));
	}
}
