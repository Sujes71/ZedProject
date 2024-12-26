package es.zed.api.account.rest.adapter;

import es.zed.api.account.domain.model.AccountFilter;

public class AccountAdapter {

  public static AccountFilter adapt(String gameName, String tagLine) {
    return AccountFilter.builder().gameName(gameName).tagLine(tagLine).build();
  }

}
