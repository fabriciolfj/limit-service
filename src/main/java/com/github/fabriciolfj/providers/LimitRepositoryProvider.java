package com.github.fabriciolfj.providers;

import com.github.fabriciolfj.business.ProviderQueryLimit;
import com.github.fabriciolfj.entity.LimitEntity;
import com.github.fabriciolfj.providers.database.converter.LimitDataConverter;
import com.github.fabriciolfj.providers.database.data.LimitData;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Slf4j
@RequiredArgsConstructor
public class LimitRepositoryProvider implements ProviderQueryLimit {

    public Uni<LimitEntity> save(final LimitEntity limitEntity) {
        return Uni.createFrom().item(limitEntity)
                .onItem()
                .transform(LimitDataConverter::toData)
                .flatMap(l -> l.persist())
                .flatMap(result -> {
                    log.info("Save limit {}", result.toString());
                    return Uni.createFrom().item(limitEntity);
                });
    }

    @Override
    public Uni<LimitEntity> get(final String account) {
        return LimitData.find("account", account)
                .firstResultOptional()
                .map(data -> LimitDataConverter.toEntity((LimitData) data.get()));
    }
}
