package com.neu.his.common.dto.dms;

import com.neu.his.mbg.model.DmsCaseModelCatalog;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class DmsCaseModelCatalogNode extends DmsCaseModelCatalog  implements Serializable {

    @Setter
    @Getter
    List<DmsCaseModelCatalogNode> children;

}
