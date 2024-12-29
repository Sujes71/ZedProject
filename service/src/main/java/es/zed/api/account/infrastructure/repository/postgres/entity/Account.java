package es.zed.api.account.infrastructure.repository.postgres.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Account")
public class Account implements Persistable<String> {

	@Id
	private String puuid;

	@Column("game_name")
	private String gameName;

	@Column("tag_line")
	private String tagLine;

	public Account(String puuid, String gameName, String tagLine) {
		this.puuid = puuid;
		this.gameName = gameName;
		this.tagLine = tagLine;
	}

	@Override
	@JsonIgnore
	public boolean isNew() {
		return true;
	}

	public String getId() {
		return puuid;
	}

	public void setId(String puuid) {
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

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Account account = (Account) o;
		return Objects.equals(puuid, account.puuid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(puuid);
	}

	@Override
	public String toString() {
		return "Account{" +
			", puuid='" + puuid + '\'' +
			", gameName='" + gameName + '\'' +
			", tagLine='" + tagLine + '\'' +
			'}';
	}

	public static Account dtoToAccount(AccountDto accountDto) {
		return new Account(accountDto.getPuuid(), accountDto.getGameName(), accountDto.getTagLine());
	}
}