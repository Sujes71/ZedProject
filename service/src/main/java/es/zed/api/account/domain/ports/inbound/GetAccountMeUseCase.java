package es.zed.api.account.domain.ports.inbound;

import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.api.shared.domain.ports.inbound.NoInputUseCase;
import reactor.core.publisher.Mono;

public interface GetAccountMeUseCase extends NoInputUseCase<Mono<AccountDto>> {
}
