package com.neu.his.dms.service;

import com.neu.his.dms.model.EsDrug;
import org.springframework.data.domain.Page;

import java.util.List;


/**
 * 药品搜索
 */
public interface EsDrugService {
    /**
     * 描述：从数据库中导入所有药品到ES
     */
    int importAll();

    /**
     * 描述：根据id删除药品
     */
    void delete(Long id);

    /**
     * 描述：根据id创建药品
     */
    EsDrug create(Long id);

    /**
     * 描述：批量删除药品
     */
    void delete(List<Long> ids);

    /**
     * 描述：根据关键字搜索
     */
    Page<EsDrug> search(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 描述：根据关键字模糊搜索
     */
    Page<EsDrug> searchFuzzy(String keyword, Integer pageNum, Integer pageSize);
}
