package es.zed.api.shared.rest.handlers;

@FunctionalInterface
public interface Handler<I, R> {
  R handle(I input);
}