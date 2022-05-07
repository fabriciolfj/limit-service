package com.github.fabriciolfj.providers.message.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountLimitWithdrawMessage {

    private String account;
    private BigDecimal balance;
}
