package com.neu.his.dms.model;

import com.neu.his.dms.model.EsDrug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 商品ES操作类
 * Created by wang on 2019/6/19.
 */
public interface EsDrugRepository extends ElasticsearchRepository<EsDrug, Long> {
    /**
     * 搜索查询
     *
     * @param name              药品名称
     * @param code              药品编码
     * @param genericName       通用名
     * @param page              分页信息
     * @return
     */
    Page<EsDrug> findByNameOrCodeOrGenericName(String name, String code, String genericName, Pageable page);

    Page<EsDrug> findByNameContainsOrMnemonicCodeContainsOrGenericNameContains(String name, String mnemonicCode, String genericName, Pageable page);
}
