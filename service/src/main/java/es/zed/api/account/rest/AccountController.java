package es.zed.api.account.rest;

import static es.zed.api.shared.rest.Routing.GET_ACCOUNT_BY_PUUID_PATH;
import static es.zed.api.shared.rest.Routing.RIOT_PATH;

import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.account.rest.handlers.GetAccountByPuuIdHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(RIOT_PATH)
public class AccountController {

  private final GetAccountByPuuIdHandler getAccountByPuuIdHandler;

  public AccountController(GetAccountByPuuIdHandler getAccountByPuuIdHandler) {
    this.getAccountByPuuIdHandler = getAccountByPuuIdHandler;
  }


  @GetMapping(path = GET_ACCOUNT_BY_PUUID_PATH, produces = "application/json")
  public Mono<AccountDto> getAccountByPuuId(@PathVariable String puuid) {
    return getAccountByPuuIdHandler.handle(puuid);
  }
}