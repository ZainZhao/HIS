package com.neu.his.dms.service.impl;

import com.neu.his.dms.model.EsDise;
import com.neu.his.dms.model.EsDiseRepository;
import com.neu.his.dms.service.EsDiseService;
import com.neu.his.mbg.mapper.DmsDiseMapper;
import com.neu.his.mbg.model.DmsDise;
import com.neu.his.mbg.model.DmsDiseExample;

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
public class EsDiseServiceImpl implements EsDiseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsDrugServiceImpl.class);
    @Autowired
    private DmsDiseMapper dmsDiseMapper;
    @Autowired
    private EsDiseRepository esDiseRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public int importAll() {
        DmsDiseExample dmsDiseExample = new DmsDiseExample();
        dmsDiseExample.createCriteria().andStatusNotEqualTo(0);
        List<DmsDise> dmsDiseList = dmsDiseMapper.selectByExample(dmsDiseExample);
        List<EsDise> esDiseList = new ArrayList<>();
        for (DmsDise dmsDise : dmsDiseList){
            EsDise esDise = new EsDise();
            BeanUtils.copyProperties(dmsDise,esDise);
            esDiseList.add(esDise);
        }
        Iterable<EsDise> esDiseIterable = esDiseRepository.saveAll(esDiseList);
        Iterator<EsDise> iterator = esDiseIterable.iterator();
        int result = 0;
        while (iterator.hasNext()){
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        esDiseRepository.deleteById(id);
    }

    @Override
    public EsDise create(Long id) {
        EsDise result = null;
        DmsDise dmsDise = dmsDiseMapper.selectByPrimaryKey(id);
        if (dmsDise !=null){
            EsDise esDise = new EsDise();
            BeanUtils.copyProperties(dmsDise,esDise);
            result = esDiseRepository.save(esDise);
        }
        return result;
    }

    @Override
    public void delete(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<EsDise> esDiseList = new ArrayList<>();
            for (Long id : ids){
                EsDise esDise = new EsDise();
                esDise.setId(id);
                esDiseList.add(esDise);
            }
            esDiseRepository.deleteAll(esDiseList);
        }
    }

    @Override
    public Page<EsDise> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return esDiseRepository.findByNameOrIcdOrCode(keyword,keyword,keyword,pageable);
    }

    @Override
    public Page<EsDise> searchFuzzy(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return esDiseRepository.findByNameContainsOrIcdContainsOrCodeContains(keyword,keyword,keyword,pageable);
    }
}
