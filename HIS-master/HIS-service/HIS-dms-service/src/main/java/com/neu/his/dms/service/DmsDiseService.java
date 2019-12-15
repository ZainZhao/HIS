package com.neu.his.dms.service;

import com.neu.his.common.dto.dms.DmsDiseParam;
import com.neu.his.common.dto.dms.DmsDiseResult;

import java.util.List;

/**
 * 诊断
 */
public interface DmsDiseService {
    /**
     * 描述：新增一个诊断
     */
    int create(DmsDiseParam dmsDiseParam);
    /**
     * 描述：根据ids删除诊断
     */
    int delete(List<Long> ids);
    /**
     * 描述：根据id更新诊断
     */
    int update(Long id, DmsDiseParam dmsDiseParam);
    /**
     * 描述：查询诊断
     */
    List<DmsDiseResult> select(DmsDiseParam dmsDiseParam, Integer pageSize, Integer pageNum);
    /**
     * 描述：查询所有诊断
     */
    List<DmsDiseResult> selectAll();
    /**
     * 描述：根据id串获取诊断简单对象list
     */
    List<DmsDiseResult> parseList( String idsStr);
}
