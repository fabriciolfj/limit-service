package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.config.LimitProperties;
import com.github.fabriciolfj.entity.LimitEntity;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
@Slf4j
@RequiredArgsConstructor
public class LimitIntermediary {
    private final LimitBasic limitBasic;

    public Uni<LimitEntity> execute(final LimitEntity entity, LimitProperties properties) {
        return Uni.createFrom().item(entity)
                .flatMap(e -> {
                    if(e.getValue().compareTo(properties.premium) >= 0) {
                        log.info("Limit intermediary to account {}", e.getAccount());
                        return Uni.createFrom().item(e.addLimits(properties.withdrawIntermediary, properties.rateIntermediary, getMultiply(e)));
                    }

                    return limitBasic.execute(e, properties);
                });
    }

    private BigDecimal getMultiply(LimitEntity entity) {
        return entity.getValue().multiply(BigDecimal.valueOf(1.2));
    }
}
