package com.neu.his.cloud.zuul.dto.dms;


import com.neu.his.cloud.zuul.model.DmsHerbalModelItem;
import com.neu.his.cloud.zuul.model.DmsMedicineModelItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class DmsDrugModelResult implements Serializable {
    @ApiModelProperty(value = "成药模版项")
    List<DmsMedicineModelItem> dmsMedicineModelItemList;
    @ApiModelProperty(value = "草药模版项")
    List<DmsHerbalModelItem> dmsHerbalModelItemList;
    @ApiModelProperty(value = "药品模版id")
    private Long id;
    @ApiModelProperty(value = "药品模版状态")
    private Integer status;
    @ApiModelProperty(value = "药品模版名字")
    private String name;
    @ApiModelProperty(value = "药品模版范围类型 scope 0个人 1科室  2全院")
    private Integer scope;
    @ApiModelProperty(value = "药品模版所属ID")
    private String ownId;
    @ApiModelProperty(value = "药品模版目的")
    private String aim;
    @ApiModelProperty(value = "药品模版创建时间")
    private Date createTime;
    @ApiModelProperty(value = "药品模版编码")
    private String code;
    @ApiModelProperty(value = "药品类型")
    private Integer type;
    @ApiModelProperty(value="草药：付数")
    private Long pairNum;
    @ApiModelProperty(value="草药：频次")
    private Integer frequency;
    @ApiModelProperty(value="草药：治法")
    private String therapy;
    @ApiModelProperty(value="草药：治法细节")
    private String therapyDetails;
    @ApiModelProperty(value="草药：医嘱")
    private String medicalAdvice;

}
