package com.github.fabriciolfj.providers.database.repository;

import com.github.fabriciolfj.business.ProviderSaveLimit;
import com.github.fabriciolfj.entity.LimitEntity;
import com.github.fabriciolfj.providers.database.converters.LimitDataConverter;
import com.github.fabriciolfj.providers.database.model.LimitData;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
public class LimitRepository implements ProviderSaveLimit {

    @Override
    public Uni<LimitEntity> save(final LimitEntity entity) {
        return Uni.createFrom()
                .item(entity)
                .onItem()
                .transform(e -> LimitDataConverter.toData(e))
                .flatMap(d -> Panache.withTransaction(d::persist))
                .onItem()
                .transform(v -> {
                    log.info("Limit save, id database: {}", ((LimitData) v).id);
                    return entity;
                });
    }
}
