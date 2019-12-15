package com.neu.his.cloud.service.dms.service;

import com.neu.his.cloud.service.dms.dto.dms.DmsDosageResult;
import com.neu.his.cloud.service.dms.dto.dms.DmsDrugParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsDrugResult;

import java.util.List;

/**
 * 药品
 */
public interface DmsDrugService {

    /**
     * 描述：创建药品
     */
    int createDrug(DmsDrugParam dmsDrugParam);

    /**
     * 描述：删除药品
     */
    int deleteDrug(List<Long> ids);

    /**
     * 描述：更新药品
     */
    int updateDrug(Long id, DmsDrugParam dmsDrugParam);

    /**
     * 描述：查询药品
     */
    List<DmsDrugResult> selectDrug(DmsDrugParam dmsDrugParam, Integer pageSize, Integer pageNum);

    /**
     * 描述：查询所有药品
     */
    List<DmsDrugResult> selectAllDrug();

    /**
     * 描述：查询所有剂型
     */
    List<DmsDosageResult> selectAllDosage();

    /**
     * 描述：根据id查询药品
     */
    DmsDrugResult selectById(Long id);
}
