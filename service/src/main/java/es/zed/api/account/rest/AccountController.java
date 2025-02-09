package es.zed.api.account.rest;

import static es.zed.api.account.rest.adapter.AccountFilterAdapter.adapt;
import static es.zed.shared.rest.Routing.ACCOUNT_PATH;
import static es.zed.shared.rest.Routing.GET_ACCOUNT_BY_GAME_TAG_PATH;

import es.zed.api.account.domain.ports.inbound.GetAccountByGameTagUseCase;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ACCOUNT_PATH)
public class AccountController {

  private final GetAccountByGameTagUseCase getAccountByGameTagUseCase;

  public AccountController(GetAccountByGameTagUseCase getAccountByGameTagUseCase) {
    this.getAccountByGameTagUseCase = getAccountByGameTagUseCase;
  }

  @GetMapping(path = GET_ACCOUNT_BY_GAME_TAG_PATH, produces = "application/json")
  public Mono<AccountDto> getAccountByGameTag(@PathVariable String gameName, @PathVariable String tagLine) {
    return getAccountByGameTagUseCase.execute(adapt(gameName, tagLine));
  }
}