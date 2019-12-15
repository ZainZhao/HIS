package com.neu.his.dms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 搜索中的商品信息
 * Created by wang on 2019/6/19.
 */
@Setter
@Getter
@ToString
@Document(indexName = "drug", type = "allDrug",shards = 1,replicas = 0)
public class EsDrug implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    private Long id;
    @Field(type = FieldType.Keyword)
    private String code;//药品编码
    @Field(type = FieldType.Keyword)
    private String name;//药品名
    private String format;//药品规格
    private BigDecimal price;//药品单价
    private String unit;//包装单位
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String manufacturer;//生产厂家
    private Long dosageId;//药品剂型
    private Long typeId;//药品类型
    private String mnemonicCode;//拼音助记码
    private Date createDate;//创建时间
    private Long stock;//库存
    @Field(type = FieldType.Keyword)
    private String genericName;//通用名
    private Integer status;//状态
}
