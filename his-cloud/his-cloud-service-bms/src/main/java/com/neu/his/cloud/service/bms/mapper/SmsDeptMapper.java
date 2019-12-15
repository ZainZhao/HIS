package com.neu.his.cloud.service.bms.mapper;

import com.neu.his.cloud.service.bms.model.SmsDept;
import com.neu.his.cloud.service.bms.model.SmsDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsDeptMapper {
    int countByExample(SmsDeptExample example);

    int deleteByExample(SmsDeptExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsDept record);

    int insertSelective(SmsDept record);

    List<SmsDept> selectByExample(SmsDeptExample example);

    SmsDept selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsDept record, @Param("example") SmsDeptExample example);

    int updateByExample(@Param("record") SmsDept record, @Param("example") SmsDeptExample example);

    int updateByPrimaryKeySelective(SmsDept record);

    int updateByPrimaryKey(SmsDept record);
}