package com.neu.his.cloud.service.dms.service;

import com.neu.his.cloud.service.dms.dto.dms.DmsNonDrugModelParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsNonDrugModelResult;


import java.util.List;

/**
 * 非药品模板
 */
public interface DmsNonDrugModelService {

    /**
     * 描述：创建模版
     */
    public int createModel(DmsNonDrugModelParam dmsNonDrugModelParam);

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
    int updateModel(Long modelId, DmsNonDrugModelParam dmsNonDrugModelParam);


    /**
     * 描述：查询模板
     */
    List<DmsNonDrugModelResult> selectModel(Integer type, DmsNonDrugModelParam queryParam, Integer pageSize, Integer pageNum);


}
