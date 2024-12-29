package es.zed.api.account.infrastructure.repository.postgres.dao;

import es.zed.api.account.infrastructure.repository.postgres.entity.Account;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountDao extends ReactiveCrudRepository<Account, UUID> {

  @Query("SELECT * FROM account WHERE LOWER(game_name) = LOWER(:gameName) AND LOWER(tag_line) = LOWER(:tagLine)")
  Mono<Account> findByGameNameAndTagLine(String gameName, String tagLine);
}
