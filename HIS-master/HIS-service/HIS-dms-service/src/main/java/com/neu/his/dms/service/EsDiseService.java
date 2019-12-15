package com.neu.his.dms.service;

import com.neu.his.dms.model.EsDise;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 诊断搜索（ES）
 */
public interface EsDiseService {
    /**
     * 描述：从数据库中导入所有疾病到ES
     */
    int importAll();

    /**
     * 描述：根据id删除疾病
     */
    void delete(Long id);

    /**
     * 描述：根据id创建疾病
     */
    EsDise create(Long id);

    /**
     * 描述：批量删除疾病
     */
    void delete(List<Long> ids);

    /**
     * 描述：根据关键字搜索
     */
    Page<EsDise> search(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 描述：根据关键字模糊搜索
     */
    Page<EsDise> searchFuzzy(String keyword, Integer pageNum, Integer pageSize);
}
