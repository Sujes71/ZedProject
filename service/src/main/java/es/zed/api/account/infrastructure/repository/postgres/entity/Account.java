package es.zed.api.account.infrastructure.repository.postgres.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import java.util.Objects;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Account")
public class Account implements Persistable<UUID> {

	@Id
	@JsonIgnore
	private UUID id;

	@Column("puuid")
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
		if (Objects.isNull(this.id)) {
			this.id = UUID.randomUUID();
			return true;
		}
		return false;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
		return "Account{" +
			"id=" + id +
			", puuid='" + puuid + '\'' +
			", gameName='" + gameName + '\'' +
			", tagLine='" + tagLine + '\'' +
			'}';
	}

	public static Account dtoToAccount(AccountDto accountDto) {
		return new Account(accountDto.getPuuid(), accountDto.getGameName().toLowerCase(), accountDto.getTagLine().toLowerCase());
	}
}