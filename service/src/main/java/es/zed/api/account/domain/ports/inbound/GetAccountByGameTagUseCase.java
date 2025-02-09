package es.zed.api.account.domain.ports.inbound;

import es.zed.api.account.domain.model.AccountFilter;
import es.zed.api.account.infrastructure.riot.dto.AccountDto;
import es.zed.shared.domain.ports.inbound.UseCase;
import reactor.core.publisher.Mono;

public interface GetAccountByGameTagUseCase extends UseCase<AccountFilter, Mono<AccountDto>> {
}
