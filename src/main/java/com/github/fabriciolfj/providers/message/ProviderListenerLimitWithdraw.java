package com.github.fabriciolfj.providers.message;

import com.github.fabriciolfj.business.usecase.FindLimit;
import com.github.fabriciolfj.providers.message.converters.LimitConverter;
import com.github.fabriciolfj.providers.message.dto.AccountLimitWithdrawMessage;
import com.github.fabriciolfj.providers.message.dto.OverdraftMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.Duration;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class ProviderListenerLimitWithdraw {

    @Inject
    private FindLimit findLimit;

    @Transactional
    @Incoming("limit-withdraw")
    @Outgoing("overdraft")
    public OverdraftMessage consumer(final AccountLimitWithdrawMessage message) {
        log.info("Message received: {}", message.toString());
        return findLimit.execute(LimitConverter.toEntity(message))
                .map(e -> {
                    log.info("Limit created: {}", e);
                    return LimitConverter.toOverdraft(e);
                }).await().atMost(Duration.ofMinutes(1));
    }
}
