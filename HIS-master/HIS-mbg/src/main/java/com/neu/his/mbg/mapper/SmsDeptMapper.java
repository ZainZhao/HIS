package com.neu.his.mbg.mapper;

import com.neu.his.mbg.model.SmsDept;
import com.neu.his.mbg.model.SmsDeptExample;
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