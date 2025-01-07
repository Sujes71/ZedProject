package es.zed.api.summoner.infrastructure.riot.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import es.zed.api.shared.infrastructure.riot.dto.Dto;

public class SummonerDto extends Dto {

  private String id;
  @JsonAlias("accountId")
	private String summonerAccountId;
  private long summonerLevel;
	private int profileIconId;
	private long revisionDate;

	public SummonerDto() {
	}

  public long getSummonerLevel() {
    return summonerLevel;
  }

  public void setSummonerLevel(long summonerLevel) {
    this.summonerLevel = summonerLevel;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public long getRevisionDate() {
    return revisionDate;
  }

  public void setRevisionDate(long revisionDate) {
    this.revisionDate = revisionDate;
  }

  public int getProfileIconId() {
    return profileIconId;
  }

  public void setProfileIconId(int profileIconId) {
    this.profileIconId = profileIconId;
  }

  public String getSummonerAccountId() {
    return summonerAccountId;
  }

  public void setSummonerAccountId(String summonerAccountId) {
    this.summonerAccountId = summonerAccountId;
  }
}
