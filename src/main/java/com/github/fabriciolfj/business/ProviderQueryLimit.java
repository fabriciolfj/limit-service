package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.LimitEntity;

public interface ProviderQueryLimit {

    LimitEntity get(final String account);
}
