package es.zed.api.shared.domain.ports.outbound;

import es.zed.api.shared.domain.model.Message;
import es.zed.api.shared.domain.ports.outbound.handler.EventListener;
import es.zed.api.shared.domain.ports.outbound.handler.EventListenerRegistry;
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

  public <B, C> Mono<C> requestEvent(Message<B, C> event) {
    EventListener<B, C> listener = registry.resolve(event.address());
    if (listener == null) {
      return Mono.error(new IllegalArgumentException("No handler found for address: " + event.address()));
    }
    return listener.handleEvent(event.body());
  }

  public <B, C> void publishEvent(Message<B, C> event) {
    eventPublisher.publishEvent(event);
  }
}