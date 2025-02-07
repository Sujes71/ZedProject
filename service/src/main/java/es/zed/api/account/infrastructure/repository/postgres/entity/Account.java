package es.zed.api.account.infrastructure.repository.postgres.entity;

import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Account")
public class Account {

	@Id
	private String id;

	@Column("game_name")
	private String gameName;

	@Column("tag_line")
	private String tagLine;

	public Account(String id, String gameName, String tagLine) {
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

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Account account = (Account) o;
		return Objects.equals(id, account.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Account { " +
			"id='" + id + '\'' +
			", gameName='" + gameName + '\'' +
			", tagLine='" + tagLine + '\'' + " }";
	}

	public AccountDto accountDto() {
		return new AccountDto(this.id, this.gameName, this.tagLine);
	}
}