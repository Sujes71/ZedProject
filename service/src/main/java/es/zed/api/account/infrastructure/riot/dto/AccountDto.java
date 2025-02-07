package es.zed.api.account.infrastructure.riot.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import es.zed.api.shared.infrastructure.riot.dto.Dto;


public class  AccountDto extends Dto {

  @JsonAlias("puuid")
  private String id;
  private String gameName;
  private String tagLine;

  public AccountDto() {
  }

  public AccountDto(String id, String gameName, String tagLine) {
    this.id = id;
    this.gameName = gameName;
    this.tagLine = tagLine;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
