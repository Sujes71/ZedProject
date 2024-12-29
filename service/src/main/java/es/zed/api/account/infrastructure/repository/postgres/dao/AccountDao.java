package es.zed.api.account.infrastructure.repository.postgres.dao;

import es.zed.api.account.infrastructure.repository.postgres.entity.Account;
import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountDao extends ReactiveCrudRepository<Account, UUID> {
	Mono<Account> findByGameNameAndTagLine(String gameName, String tagLine);
}
