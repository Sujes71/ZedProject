package es.zed.api.match.infrastructure.riot.dto;

import es.zed.api.shared.infrastructure.riot.dto.Dto;
import java.util.List;

public class PerkStyleDto extends Dto {

  private String description;
  private List<PerkStyleSelectionDto> selections;
  private int style;
}
