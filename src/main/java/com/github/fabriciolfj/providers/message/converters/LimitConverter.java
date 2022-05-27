package com.github.fabriciolfj.providers.message.converters;

import com.github.fabriciolfj.entity.LimitEntity;
import com.github.fabriciolfj.providers.message.dto.AccountLimitWithdrawMessage;
import com.github.fabriciolfj.providers.message.dto.OverdraftMessage;

public class LimitConverter {

    private LimitConverter() { }

    public static LimitEntity toEntity(final AccountLimitWithdrawMessage message) {
        return new LimitEntity(message.getAccount(), message.getBalance());
    }
    public static OverdraftMessage toOverdraft(final LimitEntity entity) {
        return OverdraftMessage
                .builder()
                .account(entity.getAccount())
                .value(entity.getOverdraft())
                .build();
    }
}
