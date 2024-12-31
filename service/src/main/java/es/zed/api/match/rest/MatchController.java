package es.zed.api.match.rest;

import static es.zed.api.match.rest.adapter.MatchFilterAdapter.adapt;
import static es.zed.api.shared.rest.Routing.GET_MATCHES_BY_ACCOUNT_ID_PATH;
import static es.zed.api.shared.rest.Routing.MATCH_PATH;

import es.zed.api.match.domain.ports.inbound.GetMatchesByAccountIdUseCase;
import es.zed.api.match.infrastructure.riot.dto.MatchDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(MATCH_PATH)
public class MatchController {

  private final GetMatchesByAccountIdUseCase getMatchesByAccountIdUseCase;

  public MatchController(GetMatchesByAccountIdUseCase getMatchesByAccountIdUseCase) {
    this.getMatchesByAccountIdUseCase = getMatchesByAccountIdUseCase;
  }

  @GetMapping(path = GET_MATCHES_BY_ACCOUNT_ID_PATH, produces = "application/json")
  public Mono<List<MatchDto>> getMatchesByAccountId(
      @PathVariable String accountId,
      @RequestParam(required = false) Long startTime,
      @RequestParam(required = false) Long endTime,
      @RequestParam(required = false) Integer queue,
      @RequestParam(required = false) String type,
      @RequestParam(defaultValue = "0") Integer start,
      @RequestParam(defaultValue = "20") Integer count) {
    return getMatchesByAccountIdUseCase.execute(adapt(accountId, startTime, endTime, queue, type, start, count));
  }

}
