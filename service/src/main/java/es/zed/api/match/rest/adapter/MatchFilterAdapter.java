package es.zed.api.match.rest.adapter;

import es.zed.api.match.domain.model.MatchFilter;

public class MatchFilterAdapter {

  public static MatchFilter adapt(String puuid, Long startTime, Long endTime, Integer queue, String type, Integer start, Integer count) {
    return new MatchFilter(puuid, startTime, endTime, queue, type, start, count);
  }
}
