package es.zed.api.match.infrastructure.riot.dto;

import es.zed.shared.infrastructure.riot.dto.Dto;

public class PerkStatsDto extends Dto {

  private int defense;
  private int flex;
  private int offense;

  public PerkStatsDto() {
  }

  public int getDefense() {
    return defense;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }

  public int getFlex() {
    return flex;
  }

  public void setFlex(int flex) {
    this.flex = flex;
  }

  public int getOffense() {
    return offense;
  }

  public void setOffense(int offense) {
    this.offense = offense;
  }
}
