package es.zed.api.account.rest.adapter;

import es.zed.api.account.domain.model.AccountFilter;

public class AccountAdapter {

  public static AccountFilter adapt(String puuid) {
    return AccountFilter.builder().puuid(puuid).build();
  }

}
