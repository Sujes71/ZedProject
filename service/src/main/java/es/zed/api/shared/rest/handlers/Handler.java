package es.zed.api.shared.rest.handlers;

@FunctionalInterface
public interface Handler<E, T> {
  T handle(E event);
}
