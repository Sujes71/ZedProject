package es.zed.api.account.rest.adapter;

import es.zed.api.account.domain.model.AccountFilter;

public class AccountFilterAdapter {

  public static AccountFilter adapt(String gameName, String tagLine) {
    return new AccountFilter(gameName, tagLine);
  }
}