package es.zed.api.shared.domain.ports.outbound.handler;

import reactor.core.publisher.Mono;

public interface EventListener<B, C> {
  Mono<C> handleEvent(B body);
}

