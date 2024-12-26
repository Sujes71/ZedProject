package es.zed.api.shared.domain.model;

import lombok.Builder;

@Builder
public record Message<B>(String address, B body) { }
