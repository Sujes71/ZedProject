package es.zed.api.shared.domain.ports.inbound;

public interface UseCase<I, R> {

  R execute(I input);
}
