package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.LimitEntity;
import io.smallrye.mutiny.Uni;

public interface ProviderQueryLimit {

    Uni<LimitEntity> get(final String account);
}
