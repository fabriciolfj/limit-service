package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.LimitEntity;
import io.smallrye.mutiny.Uni;

public interface ProviderSaveLimit {

    Uni<LimitEntity> save(final LimitEntity entity);
}
