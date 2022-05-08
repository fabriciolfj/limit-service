package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.config.LimitProperties;
import com.github.fabriciolfj.entity.LimitEntity;
import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;

@Slf4j
@ApplicationScoped
public class LimitPremium {

    @ConfigProperties
    private LimitProperties properties;
    @Inject
    private LimitIntermediary intermediary;

    public Uni<LimitEntity> execute(final LimitEntity entity) {
        return Uni.createFrom().item(entity)
                .flatMap(e -> {
                    if(entity.getValue().compareTo(properties.premium) >= 0) {
                        log.info("Limit premium to account {}", entity.getAccount());
                        return Uni.createFrom().item(e.addLimits(properties.withdrawPremium, properties.ratePremium, getMultiply(e)));
                    }

                    return intermediary.execute(entity, properties);
                });
    }

    private BigDecimal getMultiply(LimitEntity entity) {
        return entity.getValue().multiply(BigDecimal.valueOf(2L));
    }

}
