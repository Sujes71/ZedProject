package es.zed.api.match.infrastructure.riot.dto;

public class ObjectiveDto {

  private boolean first;
  private int kills;

  public ObjectiveDto() {
  }

  public boolean isFirst() {
    return first;
  }

  public void setFirst(boolean first) {
    this.first = first;
  }

  public int getKills() {
    return kills;
  }

  public void setKills(int kills) {
    this.kills = kills;
  }
}
