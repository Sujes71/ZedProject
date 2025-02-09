package es.zed.api.match.infrastructure.riot.dto;

import es.zed.shared.infrastructure.riot.dto.Dto;
import java.util.List;

public class PerksDto extends Dto {

  private PerkStatsDto statPerks;
  private List<PerkStyleDto> styles;

  public PerksDto() {
  }

  public PerkStatsDto getStatPerks() {
    return statPerks;
  }

  public void setStatPerks(PerkStatsDto statPerks) {
    this.statPerks = statPerks;
  }

  public List<PerkStyleDto> getStyles() {
    return styles;
  }

  public void setStyles(List<PerkStyleDto> styles) {
    this.styles = styles;
  }
}
