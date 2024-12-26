package es.zed.api.shared.domain.ports.outbound;

import es.zed.api.account.infrastructure.riot.RiotAccountIntegrationApi;
import es.zed.api.shared.domain.model.Message;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class OutboundPort {

  private final ApplicationEventPublisher eventPublisher;

  public OutboundPort(ApplicationEventPublisher eventPublisher) {
    this.eventPublisher = eventPublisher;
  }

  public <B, C, L> Mono<C> requestEvent(Message<B, C, L> event) {
    if (event.listener() instanceof RiotAccountIntegrationApi) {
      return Mono.defer(() ->
          ((RiotAccountIntegrationApi) event.listener()).handleBusEvent(event)
              .flatMap(result -> Mono.justOrEmpty(event.clazz().cast(result)))
      );
    }
    return Mono.error(new IllegalArgumentException("Handler no compatible con RiotAccountIntegrationApi"));
  }

  public <B, C, L> void publishEvent(Message<B, C, L> event) {
    eventPublisher.publishEvent(event);
  }
}