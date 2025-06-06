package es.zed.api.account.domain.model;

import java.util.Objects;

public class AccountFilter {

  private String gameName;

  private String tagLine;

  public AccountFilter(String gameName, String tagLine) {
    this.gameName = gameName;
    this.tagLine = tagLine;
  }

  public String getTagLine() {
    return tagLine;
  }

  public void setTagLine(String tagLine) {
    this.tagLine = tagLine;
  }

  public String getGameName() {
    return gameName;
  }

  public void setGameName(String gameName) {
    this.gameName = gameName;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountFilter that = (AccountFilter) o;
    return Objects.equals(gameName, that.gameName)
        && Objects.equals(tagLine, that.tagLine);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gameName, tagLine);
  }
}
