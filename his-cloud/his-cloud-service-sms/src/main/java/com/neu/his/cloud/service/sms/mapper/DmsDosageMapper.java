package com.neu.his.cloud.service.sms.mapper;

import com.neu.his.cloud.service.sms.model.DmsDosage;
import com.neu.his.cloud.service.sms.model.DmsDosageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsDosageMapper {
    int countByExample(DmsDosageExample example);

    int deleteByExample(DmsDosageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsDosage record);

    int insertSelective(DmsDosage record);

    List<DmsDosage> selectByExample(DmsDosageExample example);

    DmsDosage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsDosage record, @Param("example") DmsDosageExample example);

    int updateByExample(@Param("record") DmsDosage record, @Param("example") DmsDosageExample example);

    int updateByPrimaryKeySelective(DmsDosage record);

    int updateByPrimaryKey(DmsDosage record);
}