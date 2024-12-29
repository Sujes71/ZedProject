package es.zed.api.match.domain.model;

import es.zed.api.shared.domain.model.Filter;
import java.util.Objects;

public class MatchFilter extends Filter {

  private String puuid;

  private Long startTime;

  private Long endTime;

  private Integer queue;

  private String type;

  private Integer start;

  private Integer count;

  public MatchFilter(String puuid, Long startTime, Long endTime, Integer queue, String type, Integer start, Integer count) {
    this.puuid = puuid;
    this.startTime = startTime;
    this.endTime = endTime;
    this.queue = queue;
    this.type = type;
    this.start = start;
    this.count = count;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Integer getStart() {
    return start;
  }

  public void setStart(Integer start) {
    this.start = start;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getQueue() {
    return queue;
  }

  public void setQueue(Integer queue) {
    this.queue = queue;
  }

  public Long getStartTime() {
    return startTime;
  }

  public void setStartTime(Long startTime) {
    this.startTime = startTime;
  }

  public String getPuuid() {
    return puuid;
  }

  public void setPuuid(String puuid) {
    this.puuid = puuid;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MatchFilter that = (MatchFilter) o;
    return Objects.equals(puuid, that.puuid) && Objects.equals(startTime, that.startTime) && Objects.equals(queue,
        that.queue) && Objects.equals(type, that.type) && Objects.equals(start, that.start) && Objects.equals(count,
        that.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(puuid, startTime, queue, type, start, count);
  }
}
