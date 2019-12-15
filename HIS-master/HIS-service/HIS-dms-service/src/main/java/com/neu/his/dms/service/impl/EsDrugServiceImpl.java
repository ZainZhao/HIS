package com.neu.his.dms.service.impl;

import com.neu.his.dms.model.EsDrug;
import com.neu.his.dms.model.EsDrugRepository;
import com.neu.his.dms.service.EsDrugService;
import com.neu.his.mbg.mapper.DmsDrugMapper;
import com.neu.his.mbg.model.DmsDrug;
import com.neu.his.mbg.model.DmsDrugExample;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EsDrugServiceImpl implements EsDrugService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsDrugServiceImpl.class);
    @Autowired
    private DmsDrugMapper dmsDrugMapper;
    @Autowired
    private EsDrugRepository drugRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Override
    public int importAll() {
        DmsDrugExample dmsDrugExample = new DmsDrugExample();
        dmsDrugExample.createCriteria().andStatusNotEqualTo(0);
        List<DmsDrug> dmsDrugList = dmsDrugMapper.selectByExample(dmsDrugExample);
        List<EsDrug> esDrugList = new ArrayList<>();
        for (DmsDrug dmsDrug : dmsDrugList){
            EsDrug esDrug = new EsDrug();
            BeanUtils.copyProperties(dmsDrug,esDrug);
            esDrugList.add(esDrug);
        }
        Iterable<EsDrug> esDrugIterable = drugRepository.saveAll(esDrugList);
        Iterator<EsDrug> iterator = esDrugIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        drugRepository.deleteById(id);
    }

    @Override
    public EsDrug create(Long id) {
        EsDrug result = null;
        DmsDrug dmsDrug = dmsDrugMapper.selectByPrimaryKey(id);
        if (dmsDrug != null){
            EsDrug esDrug = new EsDrug();
            BeanUtils.copyProperties(dmsDrug,esDrug);
            result = drugRepository.save(esDrug);
        }
        return result;
    }

    @Override
    public void delete(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<EsDrug> esDrugList = new ArrayList<>();
            for (Long id : ids){
                EsDrug esDrug = new EsDrug();
                esDrug.setId(id);
                esDrugList.add(esDrug);
            }
            drugRepository.deleteAll(esDrugList);
        }
    }

    @Override
    public Page<EsDrug> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        //return drugRepository.findByNameOrCodeOrManufacturerOrGenericName(keyword, keyword, keyword, keyword, pageable);
        return drugRepository.findByNameOrCodeOrGenericName(keyword,keyword,keyword,pageable);
    }

    @Override
    public Page<EsDrug> searchFuzzy(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);

        return drugRepository.findByNameContainsOrMnemonicCodeContainsOrGenericNameContains(keyword,keyword,keyword,pageable);
    }
}
