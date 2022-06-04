package com.github.fabriciolfj.providers.message;

import com.github.fabriciolfj.business.usecase.FindLimit;
import com.github.fabriciolfj.providers.message.converters.LimitConverter;
import com.github.fabriciolfj.providers.message.dto.AccountLimitWithdrawMessage;
import com.github.fabriciolfj.providers.message.dto.OverdraftMessage;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
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

    @Channel("overdraft")
    private Emitter<OverdraftMessage> emitter;

    @Transactional
    @Incoming("limit-withdraw")
    //@Outgoing("overdraft")
    public void consumer(final AccountLimitWithdrawMessage message) {
        log.info("Message received: {}", message.toString());
        findLimit.execute(LimitConverter.toEntity(message))
                .map(e -> {
                    log.info("Limit created: {}", e);
                    return LimitConverter.toOverdraft(e);
                }).map(overdraft -> emitter.send(overdraft));
    }
}
