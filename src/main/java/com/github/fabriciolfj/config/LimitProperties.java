package com.github.fabriciolfj.config;

import org.eclipse.microprofile.config.inject.ConfigProperties;

import java.math.BigDecimal;

@ConfigProperties(prefix = "limit")
public class LimitProperties {

    public BigDecimal basic;
    public BigDecimal intermediary;
    public BigDecimal premium;

    public BigDecimal rateBasic;
    public BigDecimal rateIntermediary;
    public BigDecimal ratePremium;

    public int withdrawBasic;
    public int withdrawIntermediary;
    public int withdrawPremium;
}
