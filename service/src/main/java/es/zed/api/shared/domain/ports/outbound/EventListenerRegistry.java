package es.zed.api.shared.domain.ports.outbound;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class EventListenerRegistry {

  private final Map<String, EventListener<?, ?>> listeners = new ConcurrentHashMap<>();

  public <B, R> void register(String address, EventListener<B, R> listener) {
    listeners.put(address, listener);
  }

  @SuppressWarnings("unchecked")
  public <B, R> EventListener<B, R> resolve(String address) {
    return (EventListener<B, R>) listeners.get(address);
  }
}
