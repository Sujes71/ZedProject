package es.zed.api.match.infrastructure.riot.dto;

import es.zed.api.shared.infrastructure.riot.dto.Dto;

public class MatchDto extends Dto {

  private MetadataDto metadata;
  private InfoDto info;

  public MatchDto() {
  }

  public MetadataDto getMetadata() {
    return metadata;
  }

  public void setMetadata(MetadataDto metadata) {
    this.metadata = metadata;
  }

  public InfoDto getInfo() {
    return info;
  }

  public void setInfo(InfoDto info) {
    this.info = info;
  }
}
