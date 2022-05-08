package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.config.LimitProperties;
import com.github.fabriciolfj.entity.LimitEntity;
import com.github.fabriciolfj.exceptions.DomainException;
import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Slf4j
public class LimitBasic {

    public Uni<LimitEntity> execute(final LimitEntity entity, LimitProperties properties) {
        return Uni.createFrom().item(entity)
                .onItem()
                .transform(e -> {
                    if(e.getValue().compareTo(properties.basic) >= 0) {
                        log.info("Limit basic to account {}", e.getAccount());
                        return e.addLimits(properties.withdrawBasic, properties.rateBasic);
                    }

                    throw new DomainException("Limit not found to account " + e.getAccount());
                });
    }
}
