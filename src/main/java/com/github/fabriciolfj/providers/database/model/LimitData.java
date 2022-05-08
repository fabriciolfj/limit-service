package com.github.fabriciolfj.providers.database.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Builder
@Table(name = "limits")
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class LimitData extends PanacheEntity {

    @Column(name = "account")
    private String account;
    @Column(name = "rate")
    private BigDecimal rate;
    @Column(name = "withdrawalAmount")
    private int withdrawal;
}
