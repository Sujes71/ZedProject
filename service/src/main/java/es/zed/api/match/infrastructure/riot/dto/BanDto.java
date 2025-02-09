package es.zed.api.match.infrastructure.riot.dto;

import es.zed.shared.infrastructure.riot.dto.Dto;

public class BanDto extends Dto {

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
