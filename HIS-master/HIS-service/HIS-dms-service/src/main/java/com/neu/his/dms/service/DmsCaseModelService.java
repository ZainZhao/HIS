package com.neu.his.dms.service;

import com.neu.his.common.dto.dms.DmsCaseModelCatalogNode;
import com.neu.his.common.dto.dms.DmsCaseModelListResult;
import com.neu.his.common.dto.dms.DmsCaseModelOrCatalogParam;
import com.neu.his.mbg.model.DmsCaseModel;
import com.neu.his.mbg.model.DmsCaseModelCatalog;

import java.util.List;

/**
 * 病例模版
 */
public interface DmsCaseModelService {

    /**
     * 描述：列出病历模板目录树
     */
    List<DmsCaseModelCatalogNode> listModelCatTree(Long ownId, Integer scope);
    /**
     * 描述：新增目录或模板
     */
    int createCatOrModel(DmsCaseModelOrCatalogParam dmsCaseModelOrCatalogParam);
    /**
     * 描述：删除目录或模板（id即可）
     */
    int deleteModelOrCat(Long id);

    /**
     * 描述：根据模板id更新模板（只更新模板表（除name））
     */
    int updateModel(Long modelId, DmsCaseModel newDmsCaseModel);

    /**
     * 描述：根据模板id更新模板和目录的名字
     */
    int updateName(Long id, String name);

    /**
     * 描述：根据模板id获取模板详细信息
     */
    DmsCaseModel getModelDetail(Long id);

    /**
     * 描述:根据staffId获取所有病历模板
     * <p>author: ma
     */
    DmsCaseModelListResult getAllStaffModel(Long staffId);
}
