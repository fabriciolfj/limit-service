package com.github.fabriciolfj.entrypoint.converters;

import com.github.fabriciolfj.entity.LimitEntity;
import com.github.fabriciolfj.entrypoint.dto.LimitResponse;

public class LimitResponseConverter {

    private LimitResponseConverter() { }

    public static LimitResponse toResponse(final LimitEntity entity) {
        return LimitResponse.builder()
                .overdraft(entity.getOverdraft())
                .rate(entity.getRate())
                .value(entity.getValue())
                .withdrawal(entity.getWithdrawal())
                .build();
    }
}
