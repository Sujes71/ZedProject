package es.zed.api.shared.domain.ports.outbound;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface EventListener<B, R> {
  Mono<R> handleEvent(B body);
}