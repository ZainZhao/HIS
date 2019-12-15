package com.neu.his.cloud.service.dms.service;

import com.neu.his.cloud.service.dms.dto.dms.DmsDiseCatalogParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsDiseCatalogResult;


import java.util.List;

/**
 * 诊断类型目录
 */
public interface DmsDiseCatalogService {
    /**
     * 描述：新增一个诊断目录
     */
    int create(DmsDiseCatalogParam DmsDiseCatalogParam);
    /**
     * 描述：根据ids删除诊断目录
     */
    int delete(List<Long> ids);
    /**
     * 描述：根据id更新诊断目录
     */
    int update(Long id, DmsDiseCatalogParam dmsDiseCatalogParam);
    /**
     * 描述：查询诊断目录
     */
    List<DmsDiseCatalogResult> select(DmsDiseCatalogParam dmsDiseCatalogParam, Integer pageSize, Integer pageNum);
    /**
     * 描述：查询所有诊断目录
     */
    List<DmsDiseCatalogResult> selectAll();
}
