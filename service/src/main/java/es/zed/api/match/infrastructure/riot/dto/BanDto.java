package es.zed.api.match.infrastructure.riot.dto;

public class BanDto {

  private Integer championId;
  private Integer pickTurn;

  public BanDto() {
  }

  public Integer getChampionId() {
    return championId;
  }

  public void setChampionId(Integer championId) {
    this.championId = championId;
  }

  public Integer getPickTurn() {
    return pickTurn;
  }

  public void setPickTurn(Integer pickTurn) {
    this.pickTurn = pickTurn;
  }
}
