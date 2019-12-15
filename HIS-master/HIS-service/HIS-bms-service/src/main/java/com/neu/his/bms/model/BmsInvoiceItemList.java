package com.neu.his.bms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class BmsInvoiceItemList {
    Long id;

    Integer type;

    BigDecimal amount;

    public BmsInvoiceItemList(Long id, Integer type) {
        this.id = id;
        this.type = type;
    }

    public BmsInvoiceItemList(Long id, Integer type, BigDecimal amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }
}
