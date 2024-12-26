package es.zed.api.shared.domain.model;

import lombok.Builder;

@Builder
public record Message<B, C, L>(String address, B body, Class<C> clazz, L listener) {

}

