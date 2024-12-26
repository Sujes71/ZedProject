package es.zed.api.account.infrastructure.riot.dto;

import es.zed.api.shared.infrastructure.riot.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto extends Dto {

  private String puuid;

  private String gameName;

  private String tagLine;
}
