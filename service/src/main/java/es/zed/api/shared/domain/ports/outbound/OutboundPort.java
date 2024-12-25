package es.zed.api.shared.domain.ports.outbound;

import es.zed.api.account.domain.core.AsyncBusEventListener;
import es.zed.api.shared.domain.model.EventBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class OutboundPort {

  private final ApplicationEventPublisher eventPublisher;
  private final AsyncBusEventListener eventListener;

  public OutboundPort(ApplicationEventPublisher eventPublisher, AsyncBusEventListener eventListener) {
    this.eventPublisher = eventPublisher;
    this.eventListener = eventListener;
  }

  public Mono<String> publishEvent(EventBus event) {
    return eventListener.handleBusEvent(event);
  }
}


