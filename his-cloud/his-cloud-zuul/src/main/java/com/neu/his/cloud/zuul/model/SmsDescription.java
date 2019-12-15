package com.neu.his.cloud.zuul.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class SmsDescription implements Serializable {
    private Long id;

    private String description;

    private Integer type;

    private Integer status;

    private String url;

    private Long theId;

    private BigDecimal star;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getTheId() {
        return theId;
    }

    public void setTheId(Long theId) {
        this.theId = theId;
    }

    public BigDecimal getStar() {
        return star;
    }

    public void setStar(BigDecimal star) {
        this.star = star;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", description=").append(description);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", url=").append(url);
        sb.append(", theId=").append(theId);
        sb.append(", star=").append(star);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}