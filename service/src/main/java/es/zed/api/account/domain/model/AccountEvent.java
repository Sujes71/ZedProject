package es.zed.api.account.domain.model;

import es.zed.api.shared.domain.model.EventBus;

public class AccountEvent extends EventBus {

  private final String accountId;


  public AccountEvent(String address, String accountId) {
    super(address);
    this.accountId = accountId;
  }

  public String getAccountId() {
    return accountId;
  }
}
