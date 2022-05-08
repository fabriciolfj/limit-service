package com.github.fabriciolfj.entity;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class LimitEntity {

    private String account;
    private int withdrawal;
    private BigDecimal rate;
    private BigDecimal value;
    private BigDecimal overdraft;

    public LimitEntity(final String account, final BigDecimal value) {
        this.account = account;
        this.value = value;
    }

    public LimitEntity addLimits(final int withdrawal, final BigDecimal rate, final BigDecimal overdraft) {
        this.withdrawal = withdrawal;
        this.rate = rate;
        this.overdraft = overdraft;

        return this;
    }

    public LimitEntity addLimits(final int withdrawal, final BigDecimal rate) {
        this.withdrawal = withdrawal;
        this.rate = rate;
        this.overdraft = this.value;

        return this;
    }
}
