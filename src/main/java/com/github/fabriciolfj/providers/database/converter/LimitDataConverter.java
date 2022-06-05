package com.github.fabriciolfj.providers.database.converter;

import com.github.fabriciolfj.entity.LimitEntity;
import com.github.fabriciolfj.providers.database.data.LimitData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LimitDataConverter {

    private LimitDataConverter() {

    }

    public static final LimitData toData(final LimitEntity limitEntity) {
        return LimitData.builder()
                .account(limitEntity.getAccount())
                .overdraft(limitEntity.getOverdraft())
                .rate(limitEntity.getRate())
                .value(limitEntity.getValue())
                .withdrawal(limitEntity.getWithdrawal())
                .build();
    }

    public static final LimitEntity toEntity(final LimitData data) {
        log.info("Data return base: {}", data);
        return LimitEntity
                .builder()
                .account(data.getAccount())
                .overdraft(data.getOverdraft())
                .rate(data.getRate())
                .value(data.getValue())
                .withdrawal(data.getWithdrawal())
                .build();
    }
}
