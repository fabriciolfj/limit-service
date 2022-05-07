package com.github.fabriciolfj.utils;

import com.github.fabriciolfj.providers.message.dto.AccountLimitWithdrawMessage;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class LimitWithdrawDeserializer extends JsonbDeserializer<AccountLimitWithdrawMessage> {

    public LimitWithdrawDeserializer() {
        super(AccountLimitWithdrawMessage.class);
    }
}
