package com.github.fabriciolfj.providers.message;

import com.github.fabriciolfj.providers.message.dto.AccountLimitWithdrawMessage;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Slf4j
@ApplicationScoped
public class ProviderListenerLimitWithdraw {

    @Transactional
    @Incoming("limit-withdraw")
    public void consumer(final AccountLimitWithdrawMessage message) {
        log.info(message.toString());
    }
}
