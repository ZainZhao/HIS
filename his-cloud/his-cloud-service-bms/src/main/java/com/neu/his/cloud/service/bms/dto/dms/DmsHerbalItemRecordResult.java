package com.neu.his.cloud.service.bms.dto.dms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class DmsHerbalItemRecordResult implements Serializable {

    private Long id;

    private Integer status;

    private Long prescriptionId;

    private String medicalAdvice;

    private String footnote;

    private Long drugId;

    private Long usageNum;

    private Integer usageNumUnit;

    private Long totalNum;

    private BigDecimal price;

    private String drugName;


}
