package es.zed.api.match.rest;

import static es.zed.api.match.rest.adapter.MatchFilterAdapter.adapt;
import static es.zed.api.shared.rest.Routing.GET_MATCHES_BY_PUUID;
import static es.zed.api.shared.rest.Routing.MATCH_PATH;

import es.zed.api.match.domain.ports.inbound.GetMatchesByPuuIdUseCase;
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

  private final GetMatchesByPuuIdUseCase getMatchesByPuuIdUseCase;

  public MatchController(GetMatchesByPuuIdUseCase getMatchesByPuuIdUseCase) {
    this.getMatchesByPuuIdUseCase = getMatchesByPuuIdUseCase;
  }

  @GetMapping(path = GET_MATCHES_BY_PUUID, produces = "application/json")
  public Mono<List<String>> getAccountByRiotId(
      @PathVariable String puuid,
      @RequestParam(required = false) Long startTime,
      @RequestParam(required = false) Long endTime,
      @RequestParam(required = false) Integer queue,
      @RequestParam(required = false) String type,
      @RequestParam(defaultValue = "0") Integer start,
      @RequestParam(defaultValue = "20") Integer count) {
    return getMatchesByPuuIdUseCase.execute(adapt(puuid, startTime, endTime, queue, type, start, count));
  }

}
