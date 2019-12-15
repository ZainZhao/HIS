package com.neu.his.cloud.service.dms.dto.dms;

import com.neu.his.cloud.service.dms.model.DmsCaseModelCatalog;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 病历模板目录
 */
public class DmsCaseModelCatalogNode extends DmsCaseModelCatalog implements Serializable {
    @Setter
    @Getter
    List<DmsCaseModelCatalogNode> children;
}
