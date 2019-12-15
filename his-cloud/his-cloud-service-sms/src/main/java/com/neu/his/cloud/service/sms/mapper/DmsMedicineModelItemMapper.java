package com.neu.his.cloud.service.sms.mapper;

import com.neu.his.cloud.service.sms.model.DmsMedicineModelItem;
import com.neu.his.cloud.service.sms.model.DmsMedicineModelItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsMedicineModelItemMapper {
    int countByExample(DmsMedicineModelItemExample example);

    int deleteByExample(DmsMedicineModelItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsMedicineModelItem record);

    int insertSelective(DmsMedicineModelItem record);

    List<DmsMedicineModelItem> selectByExample(DmsMedicineModelItemExample example);

    DmsMedicineModelItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsMedicineModelItem record, @Param("example") DmsMedicineModelItemExample example);

    int updateByExample(@Param("record") DmsMedicineModelItem record, @Param("example") DmsMedicineModelItemExample example);

    int updateByPrimaryKeySelective(DmsMedicineModelItem record);

    int updateByPrimaryKey(DmsMedicineModelItem record);
}