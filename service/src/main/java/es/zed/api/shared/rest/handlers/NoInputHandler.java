package es.zed.api.shared.rest.handlers;

@FunctionalInterface
public interface NoInputHandler<R> {
  R handle();
}
