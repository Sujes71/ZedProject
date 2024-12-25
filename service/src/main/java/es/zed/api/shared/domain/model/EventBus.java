package es.zed.api.shared.domain.model;

public abstract class EventBus {

  private final String address;

  protected EventBus(String address) {
    this.address = address;
  }

  public String getAddress() {
    return address;
  }
}
