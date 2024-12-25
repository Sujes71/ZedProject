package es.zed.api.account.domain.core;

import es.zed.api.account.domain.model.AccountEvent;
import es.zed.api.shared.domain.model.EventBus;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import reactor.core.publisher.Mono;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AsyncBusEventListener {

  @EventListener
  public Mono<String> handleBusEvent(EventBus event) {
    if (event instanceof AccountEvent accountEvent) {
      return handleAccountEvent(accountEvent);
    } else {
      return Mono.just("Unknown event type: " + event.getAddress());
    }
  }

  private Mono<String> handleAccountEvent(AccountEvent event) {
    return Mono.defer(() -> {
      System.out.println("Handling AccountEvent for accountId: " + event.getAccountId());
      return Mono.just("Processed AccountEvent for accountId: " + event.getAccountId());
    });
  }
}


