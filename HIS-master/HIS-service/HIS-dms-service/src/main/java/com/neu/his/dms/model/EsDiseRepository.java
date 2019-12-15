package com.neu.his.dms.model;

import com.neu.his.dms.model.EsDise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsDiseRepository  extends ElasticsearchRepository<EsDise, Long>  {
    Page<EsDise> findByNameOrIcdOrCode(String name, String icd, String code, Pageable page);


    Page<EsDise> findByNameContainsOrIcdContainsOrCodeContains(String name, String icd, String code, Pageable page);
}
