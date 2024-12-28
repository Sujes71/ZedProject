package es.zed.api.account.rest;

import static es.zed.api.account.rest.adapter.AccountFilterAdapter.adapt;
import static es.zed.api.shared.rest.Routing.ACCOUNT_PATH;
import static es.zed.api.shared.rest.Routing.GET_ACCOUNT_BY_RIOT_ID_PATH;

import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.account.rest.handlers.GetAccountByRiotIdHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ACCOUNT_PATH)
public class AccountController {

  private final GetAccountByRiotIdHandler getAccountByRiotIdHandler;

  public AccountController(GetAccountByRiotIdHandler getAccountByRiotIdHandler) {
    this.getAccountByRiotIdHandler = getAccountByRiotIdHandler;
  }

  @GetMapping(path = GET_ACCOUNT_BY_RIOT_ID_PATH, produces = "application/json")
  public Mono<AccountDto> getAccountByRiotId(@PathVariable String gameName, @PathVariable String tagLine) {
    return getAccountByRiotIdHandler.handle(adapt(gameName, tagLine));
  }
}