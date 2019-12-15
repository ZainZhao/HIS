package com.neu.his.cloud.service.bms.mapper;

import com.neu.his.cloud.service.bms.model.SmsStaff;
import com.neu.his.cloud.service.bms.model.SmsStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsStaffMapper {
    int countByExample(SmsStaffExample example);

    int deleteByExample(SmsStaffExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsStaff record);

    int insertSelective(SmsStaff record);

    List<SmsStaff> selectByExample(SmsStaffExample example);

    SmsStaff selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsStaff record, @Param("example") SmsStaffExample example);

    int updateByExample(@Param("record") SmsStaff record, @Param("example") SmsStaffExample example);

    int updateByPrimaryKeySelective(SmsStaff record);

    int updateByPrimaryKey(SmsStaff record);
}