package com.neu.his.dms.service;

import com.neu.his.common.dto.dms.DmsDrugModelParam;
import com.neu.his.common.dto.dms.DmsDrugModelResult;
import com.neu.his.common.dto.dms.DmsNonDrugModelParam;
import com.neu.his.common.dto.dms.DmsNonDrugModelResult;

import java.util.List;

/**
 * 药品模版服务
 */
public interface DmsDrugModelService {
    /**
     * 描述：创建模版
     */
    int createModel(DmsDrugModelParam dmsDrugModelParam);

    /**
     * 描述：删除模版
     */
    int deleteModel(List<Long> ids);


    /**
     * 描述：删除模版项
     */
    int deleteModelItem(Long modelId, List<Long> itemIds);


    /**
     * 描述：根据modelId更新model信息（删了重新创建）
     */
    int updateModel(Long modelId, DmsDrugModelParam dmsDrugModelParam);


    /**
     * 描述：查询模版
     */
    List<DmsDrugModelResult> selectModel(Integer isAdmin, DmsDrugModelParam queryParam, Integer pageSize, Integer pageNum);


}
