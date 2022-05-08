package com.github.fabriciolfj.providers.message.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OverdraftMessage {

    private String account;
    private BigDecimal value;
}
