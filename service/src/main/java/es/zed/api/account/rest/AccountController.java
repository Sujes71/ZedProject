package es.zed.api.account.rest;

import static es.zed.api.account.rest.adapter.AccountAdapter.adapt;
import static es.zed.api.shared.rest.Routing.ACCOUNT_PATH;
import static es.zed.api.shared.rest.Routing.GET_ACCOUNT_BY_PUUID_PATH;
import static es.zed.api.shared.rest.Routing.GET_ACCOUNT_BY_RIOT_ID_PATH;
import static es.zed.api.shared.rest.Routing.GET_ACCOUNT_ME_PATH;

import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.account.rest.handlers.GetAccountByPuuIdHandler;
import es.zed.api.account.rest.handlers.GetAccountByRiotIdHandler;
import es.zed.api.account.rest.handlers.GetAccountMeHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ACCOUNT_PATH)
public class AccountController {

  private final GetAccountByPuuIdHandler getAccountByPuuIdHandler;
  private final GetAccountByRiotIdHandler getAccountByRiotIdHandler;
  private final GetAccountMeHandler getAccountMeHandler;

  public AccountController(GetAccountByPuuIdHandler getAccountByPuuIdHandler, GetAccountByRiotIdHandler getAccountByRiotIdHandler,
      GetAccountMeHandler getAccountMeHandler) {
    this.getAccountByPuuIdHandler = getAccountByPuuIdHandler;
    this.getAccountByRiotIdHandler = getAccountByRiotIdHandler;
    this.getAccountMeHandler = getAccountMeHandler;
  }


  @GetMapping(path = GET_ACCOUNT_BY_PUUID_PATH, produces = "application/json")
  public Mono<AccountDto> getAccountByPuuId(@PathVariable String puuid) {
    return getAccountByPuuIdHandler.handle(puuid);
  }

  @GetMapping(path = GET_ACCOUNT_BY_RIOT_ID_PATH, produces = "application/json")
  public Mono<AccountDto> getAccountByRiotId(@PathVariable String gameName, @PathVariable String tagLine) {
    return getAccountByRiotIdHandler.handle(adapt(gameName, tagLine));
  }

  @GetMapping(path = GET_ACCOUNT_ME_PATH, produces = "application/json")
  public Mono<AccountDto> getAccountMe() {
    return getAccountMeHandler.handle();
  }
}