package com.neu.his.cloud.zuul.dto.dms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@ToString
public class DmsNonDrugItem implements Serializable {

    private Long id;

    private String code;

    private String name;

    private String format;

    private BigDecimal price;

    private Long expClassId;

    private String mnemonicCode;

    private Integer recordType;

    private Date createDate;

    private Integer status;

    private Long deptId;



    private String deptName;

    private BigDecimal amount;

    private Long excuteDeptId;

    private Long noDrugId;

}
