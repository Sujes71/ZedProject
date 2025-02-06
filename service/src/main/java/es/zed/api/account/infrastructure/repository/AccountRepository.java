package es.zed.api.account.infrastructure.repository;

import static es.zed.api.account.domain.ports.outbound.AccountPersistencePort.GET_ACCOUNT_BY_GAME_TAG_DB_ADDRESS;
import static es.zed.api.account.domain.ports.outbound.AccountPersistencePort.SAVE_ACCOUNT_DB_ADDRESS;
import static es.zed.api.shared.domain.ports.outbound.OutboundPort.register;

import es.zed.api.account.domain.model.AccountFilter;
import es.zed.api.account.infrastructure.repository.postgres.dao.AccountDao;
import es.zed.api.account.infrastructure.repository.postgres.entity.Account;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import jakarta.annotation.PostConstruct;
import java.util.Objects;
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
    	register(GET_ACCOUNT_BY_GAME_TAG_DB_ADDRESS, this::findByGameTag);
		register(SAVE_ACCOUNT_DB_ADDRESS, this::saveAccount);
	}

	public Mono<Account> findByGameTag(AccountFilter filter) {
		return accountDao.findByGameNameAndTagLine(filter.getGameName(), filter.getTagLine())
			.doOnSuccess(account -> {
				if (Objects.nonNull(account)) {
					log.info("Found {}", account);
				}
			})
			.doOnError(error -> log.error("Error finding account: {}", error.getMessage()));
	}

	public Mono<Void> saveAccount(AccountDto accountDto) {
		return accountDao.insert(accountDto.getId(), accountDto.getGameName(), accountDto.getTagLine())
			.doOnSuccess(_ -> log.info("Account saved"))
			.doOnError(error -> log.error("Error saving account: {}", error.getMessage()));
	}
}