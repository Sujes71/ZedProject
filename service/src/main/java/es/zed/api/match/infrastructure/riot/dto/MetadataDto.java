package es.zed.api.match.infrastructure.riot.dto;

import es.zed.api.shared.infrastructure.riot.dto.Dto;
import java.util.List;

public class MetadataDto extends Dto {

  private String dataVersion;
  private String matchId;
  private List<String> participants;

  public MetadataDto() {
  }

  public String getDataVersion() {
    return dataVersion;
  }

  public void setDataVersion(String dataVersion) {
    this.dataVersion = dataVersion;
  }

  public String getMatchId() {
    return matchId;
  }

  public void setMatchId(String matchId) {
    this.matchId = matchId;
  }

  public List<String> getParticipants() {
    return participants;
  }

  public void setParticipants(List<String> participants) {
    this.participants = participants;
  }
}
