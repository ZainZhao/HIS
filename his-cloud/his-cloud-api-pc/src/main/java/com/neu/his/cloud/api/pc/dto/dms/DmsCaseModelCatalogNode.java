package com.neu.his.cloud.api.pc.dto.dms;

import com.neu.his.cloud.api.pc.model.DmsCaseModelCatalog;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


public class DmsCaseModelCatalogNode extends DmsCaseModelCatalog implements Serializable {

    @Setter
    @Getter
    List<DmsCaseModelCatalogNode> children;

}
