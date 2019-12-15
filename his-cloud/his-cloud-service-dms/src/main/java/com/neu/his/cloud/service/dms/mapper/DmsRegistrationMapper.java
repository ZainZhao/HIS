package com.neu.his.cloud.service.dms.mapper;

import com.neu.his.cloud.service.dms.model.DmsRegistration;
import com.neu.his.cloud.service.dms.model.DmsRegistrationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsRegistrationMapper {
    int countByExample(DmsRegistrationExample example);

    int deleteByExample(DmsRegistrationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsRegistration record);

    int insertSelective(DmsRegistration record);

    List<DmsRegistration> selectByExample(DmsRegistrationExample example);

    DmsRegistration selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsRegistration record, @Param("example") DmsRegistrationExample example);

    int updateByExample(@Param("record") DmsRegistration record, @Param("example") DmsRegistrationExample example);

    int updateByPrimaryKeySelective(DmsRegistration record);

    int updateByPrimaryKey(DmsRegistration record);
}