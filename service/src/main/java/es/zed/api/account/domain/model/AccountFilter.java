package es.zed.api.account.domain.model;

import es.zed.api.shared.domain.model.Filter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountFilter extends Filter {

  private String puuid;

  private String gameName;

  private String tagLine;
}
