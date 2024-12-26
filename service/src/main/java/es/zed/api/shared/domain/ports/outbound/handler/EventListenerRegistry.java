package es.zed.api.shared.domain.ports.outbound.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class EventListenerRegistry {

  private final Map<String, EventListener<?, ?>> listeners = new ConcurrentHashMap<>();

  public <B, C> void register(String address, EventListener<B, C> listener) {
    listeners.put(address, listener);
  }

  @SuppressWarnings("unchecked")
  public <B, C> EventListener<B, C> resolve(String address) {
    return (EventListener<B, C>) listeners.get(address);
  }
}
