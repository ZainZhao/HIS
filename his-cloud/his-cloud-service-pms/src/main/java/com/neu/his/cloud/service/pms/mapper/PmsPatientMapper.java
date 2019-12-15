package com.neu.his.cloud.service.pms.mapper;

import com.neu.his.cloud.service.pms.model.PmsPatient;
import com.neu.his.cloud.service.pms.model.PmsPatientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsPatientMapper {
    int countByExample(PmsPatientExample example);

    int deleteByExample(PmsPatientExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsPatient record);

    int insertSelective(PmsPatient record);

    List<PmsPatient> selectByExample(PmsPatientExample example);

    PmsPatient selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsPatient record, @Param("example") PmsPatientExample example);

    int updateByExample(@Param("record") PmsPatient record, @Param("example") PmsPatientExample example);

    int updateByPrimaryKeySelective(PmsPatient record);

    int updateByPrimaryKey(PmsPatient record);
}