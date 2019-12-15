package com.neu.his.cloud.api.pc.dto.dms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class DmsMedicineItemRecordResult  implements Serializable {

    private Long id;

    private Long drugId;

    private Integer status;

    private Long prescriptionId;

    private Integer medicineUsage;

    private Integer frequency;

    private Long days;

    private Long num;

    private String medicalAdvice;

    private Long refundNum;

    private Long usageNum;

    private Integer usageMeans;

    private Integer usageNumUnit;

    private BigDecimal price;

    private String drugName;

    private Long currentNum;


}
