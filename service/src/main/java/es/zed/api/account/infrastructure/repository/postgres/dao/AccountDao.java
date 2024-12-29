package es.zed.api.account.infrastructure.repository.postgres.dao;

import es.zed.api.account.infrastructure.repository.postgres.entity.Account;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountDao extends ReactiveCrudRepository<Account, String> {

  @Query("SELECT * FROM account WHERE LOWER(game_name) = LOWER(:gameName) AND LOWER(tag_line) = LOWER(:tagLine)")
  Mono<Account> findByGameNameAndTagLine(String gameName, String tagLine);

  @Query("INSERT INTO account(puuid, game_name, tag_line) VALUES(:puuid, :gameName, :tagLine)")
  Mono<Void> insert(String puuid, String gameName, String tagLine);

}
