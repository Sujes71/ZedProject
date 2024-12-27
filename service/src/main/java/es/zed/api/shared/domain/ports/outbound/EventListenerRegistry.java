package es.zed.api.shared.domain.ports.outbound;

import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class EventListenerRegistry {

  private final Map<String, EventListener<?, ?>> listeners;

	public EventListenerRegistry(Map<String, EventListener<?, ?>> listeners) {
		this.listeners = listeners;
	}

	public <B, R> void register(String address, EventListener<B, R> listener) {
    listeners.put(address, listener);
  }

  @SuppressWarnings("unchecked")
  public <B, R> EventListener<B, R> resolve(String address) {
    return (EventListener<B, R>) listeners.get(address);
  }
}
