package es.zed.api.account.domain.model;

import es.zed.api.shared.domain.model.Filter;
import lombok.Builder;

@Builder
public class AccountFilter extends Filter {

  private String puuid;
}
