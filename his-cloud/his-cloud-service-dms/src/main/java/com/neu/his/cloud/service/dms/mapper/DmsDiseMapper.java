package com.neu.his.cloud.service.dms.mapper;

import com.neu.his.cloud.service.dms.model.DmsDise;
import com.neu.his.cloud.service.dms.model.DmsDiseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsDiseMapper {
    int countByExample(DmsDiseExample example);

    int deleteByExample(DmsDiseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsDise record);

    int insertSelective(DmsDise record);

    List<DmsDise> selectByExample(DmsDiseExample example);

    DmsDise selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsDise record, @Param("example") DmsDiseExample example);

    int updateByExample(@Param("record") DmsDise record, @Param("example") DmsDiseExample example);

    int updateByPrimaryKeySelective(DmsDise record);

    int updateByPrimaryKey(DmsDise record);
}