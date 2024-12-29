package es.zed.api.account.infrastructure.riot.dto;

import es.zed.api.shared.infrastructure.riot.dto.Dto;


public class  AccountDto extends Dto {

  private String puuid;

  private String gameName;

  private String tagLine;

  public AccountDto() {
  }

  public AccountDto(String puuid, String gameName, String tagLine) {
    this.puuid = puuid;
    this.gameName = gameName;
    this.tagLine = tagLine;
  }

  public String getPuuid() {
    return puuid;
  }

  public void setPuuid(String puuid) {
    this.puuid = puuid;
  }

  public String getGameName() {
    return gameName;
  }

  public void setGameName(String gameName) {
    this.gameName = gameName;
  }

  public String getTagLine() {
    return tagLine;
  }

  public void setTagLine(String tagLine) {
    this.tagLine = tagLine;
  }
}
