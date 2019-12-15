package com.neu.his.cloud.service.dms.service;

import com.neu.his.cloud.service.dms.dto.dms.DmsMechanicItemRecordResult;

import java.util.List;

/**
 * 医技
 */
public interface DmsMechanicItemRecordService {

    /**
     * 描述：根据科室id刷新患者列表
     */
    List<DmsMechanicItemRecordResult> listByDept(Long deptId);

    /**
     * 描述：医技登记
     */
    int log(Long itemRecordId, Long logStaffId);

    /**
     * 描述：上传结果
     */
    int uploadResult(Long id, Long excuteStaffId, String checkResult, String resultImgUrlList);

}
