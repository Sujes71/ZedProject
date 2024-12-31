package es.zed.api.match.infrastructure.riot.dto;

import es.zed.api.shared.infrastructure.riot.dto.Dto;
import java.util.List;

public class TeamDto extends Dto {

  private List<BanDto> bans;
  private ObjectivesDto objectives;
  private int teamId;
  private boolean win;

  public TeamDto() {
  }

  public List<BanDto> getBans() {
    return bans;
  }

  public void setBans(List<BanDto> bans) {
    this.bans = bans;
  }

  public ObjectivesDto getObjectives() {
    return objectives;
  }

  public void setObjectives(ObjectivesDto objectives) {
    this.objectives = objectives;
  }

  public int getTeamId() {
    return teamId;
  }

  public void setTeamId(int teamId) {
    this.teamId = teamId;
  }

  public boolean isWin() {
    return win;
  }

  public void setWin(boolean win) {
    this.win = win;
  }
}
