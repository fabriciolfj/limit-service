package com.github.fabriciolfj.providers.database.converters;

import com.github.fabriciolfj.entity.LimitEntity;
import com.github.fabriciolfj.providers.database.model.LimitData;

public class LimitDataConverter {

    private LimitDataConverter() { }

    public static LimitData toData(final LimitEntity entity) {
        return LimitData
                .builder()
                .account(entity.getAccount())
                .rate(entity.getRate())
                .withdrawal(entity.getWithdrawal())
                .build();
    }
}
