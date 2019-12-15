package com.neu.his.dms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
@Setter
@Getter
@ToString
@Document(indexName = "dise", type = "allDise",shards = 1,replicas = 0)
public class EsDise implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    private Long id;
    private Long catId;
    private String code;
    @Field(type = FieldType.Keyword)
    private String name;
    private String icd;
    private Integer status;
}
