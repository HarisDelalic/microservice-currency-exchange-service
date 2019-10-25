package com.dela.microservicecurrencyexchangeservice.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

@Entity
@Table(name="exchange_values")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExchangeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private Long id;
    @Column(name = "valueFrom")
    @Getter @Setter private String from;
    @Column(name = "valueTo")
    @Getter @Setter private String to;
    @Getter @Setter private BigDecimal conversionMultiple;

    public ExchangeValue(String from, String to, BigDecimal conversionMultiple) {
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}
