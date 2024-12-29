package es.zed.api.account.infrastructure.repository;

import static es.zed.api.account.domain.ports.outbound.AccountPersistencePort.GET_ACCOUNT_BY_RIOT_ID_DB_ADDRESS;
import static es.zed.api.account.domain.ports.outbound.AccountPersistencePort.SAVE_ACCOUNT_DB_ADDRESS;
import static es.zed.api.account.infrastructure.repository.postgres.entity.Account.dtoToAccount;
import static es.zed.api.shared.domain.ports.outbound.OutboundPort.register;

import es.zed.api.account.domain.model.AccountFilter;
import es.zed.api.account.infrastructure.repository.postgres.dao.AccountDao;
import es.zed.api.account.infrastructure.repository.postgres.entity.Account;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class AccountRepository {

	private static final Logger log = LogManager.getLogger(AccountRepository.class);

	private final AccountDao accountDao;

	public AccountRepository(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@PostConstruct
	public void start() {
		register(GET_ACCOUNT_BY_RIOT_ID_DB_ADDRESS, this::findByRiotId);
		register(SAVE_ACCOUNT_DB_ADDRESS, this::saveAccount);
	}

	public Mono<Account> findByRiotId(AccountFilter filter) {
		return accountDao.findByGameNameAndTagLine(filter.getGameName(), filter.getTagLine())
			.doOnSuccess(acc -> {
				if (acc != null) {
					log.info("Account found {}", acc);
				} else {
					log.info("Account not found with gameName {} and tagLine {}",
						filter.getGameName(), filter.getTagLine());
				}
			})
			.doOnError(error -> log.error("Error finding account: {}", error.getMessage()));
	}

	public Mono<Account> saveAccount(AccountDto accountDto) {
		return accountDao.save(dtoToAccount(accountDto))
			.doOnSuccess(savedAccount -> log.info("Account saved {}", savedAccount))
			.doOnError(error -> log.error("Error saving account: {}", error.getMessage()));
	}
}