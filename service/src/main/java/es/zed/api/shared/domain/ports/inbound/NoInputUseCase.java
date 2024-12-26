package es.zed.api.shared.domain.ports.inbound;

@FunctionalInterface
public interface NoInputUseCase<R> {
  R execute();
}
