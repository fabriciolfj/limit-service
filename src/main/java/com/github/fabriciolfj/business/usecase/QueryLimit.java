package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.ProviderQueryLimit;
import com.github.fabriciolfj.entity.LimitEntity;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class QueryLimit {

    private final ProviderQueryLimit providerQueryLimit;

    public LimitEntity execute(final String account) {
        return providerQueryLimit.get(account);
    }
}
