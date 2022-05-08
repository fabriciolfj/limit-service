package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.ProviderSaveLimit;
import com.github.fabriciolfj.entity.LimitEntity;
import com.github.fabriciolfj.exceptions.DomainException;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class FindLimit {

    private final LimitPremium limitPremium;
    private final ProviderSaveLimit saveLimit;

    public Uni<LimitEntity> execute(final LimitEntity entity) {
        return limitPremium.execute(entity)
                .flatMap(e -> saveLimit.save(e))
                .onFailure().transform(f -> new DomainException(f.getMessage()));
    }
}
