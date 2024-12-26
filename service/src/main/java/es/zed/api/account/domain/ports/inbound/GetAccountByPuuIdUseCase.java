package es.zed.api.account.domain.ports.inbound;

import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.shared.domain.ports.inbound.UseCase;
import reactor.core.publisher.Mono;

public interface GetAccountByPuuIdUseCase extends UseCase<String, Mono<AccountDto>> {

}
