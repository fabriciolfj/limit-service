package com.github.fabriciolfj.entrypoint.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LimitResponse {

    private int withdrawal;
    private BigDecimal rate;
    private BigDecimal value;
    private BigDecimal overdraft;

}
