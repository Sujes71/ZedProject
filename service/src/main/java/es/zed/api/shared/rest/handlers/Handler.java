package es.zed.api.shared.rest.handlers;

@FunctionalInterface
public interface Handler<E, R> {
  R handle(E event);
}
