package es.zed.api.match.infrastructure.riot.dto;

import es.zed.api.shared.infrastructure.riot.dto.Dto;
import java.util.List;

public class TeamDto extends Dto {

  private List<BanDto> bans;
  private ObjectivesDto objectives;
  private int teamId;
  private boolean win;
}
