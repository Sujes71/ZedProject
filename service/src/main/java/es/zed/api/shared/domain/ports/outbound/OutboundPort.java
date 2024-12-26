package es.zed.api.shared.domain.ports.outbound;

import es.zed.api.shared.domain.model.Message;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class OutboundPort {

  private final EventListenerRegistry registry;
  private final ApplicationEventPublisher eventPublisher;

  public OutboundPort(EventListenerRegistry registry, ApplicationEventPublisher eventPublisher) {
    this.registry = registry;
    this.eventPublisher = eventPublisher;
  }

  public <B, R> Mono<R> requestEvent(Message<B> event) {
    EventListener<B, R> listener = registry.resolve(event.address());
    if (listener == null) {
      return Mono.error(new IllegalArgumentException("No handler found for address: " + event.address()));
    }
    return listener.handleEvent(event.body());
  }

  public <B> void publishEvent(Message<B> event) {
    eventPublisher.publishEvent(event);
  }
}