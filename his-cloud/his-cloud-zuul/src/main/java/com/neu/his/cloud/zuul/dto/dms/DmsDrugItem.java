package com.neu.his.cloud.zuul.dto.dms;


import com.neu.his.cloud.zuul.model.DmsDosage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@ToString
public class DmsDrugItem implements Serializable {

    private Long id;

    private String code;

    private String name;

    private String format;

    private BigDecimal price;

    private String unit;

    private String manufacturer;

    private DmsDosage dosage;

    private Long typeId;

    private String mnemonicCode;

    private Date createDate;

    private Long stock;

    private String genericName;

    private Integer status;

    private Long num;

    private Long drugId;
}
