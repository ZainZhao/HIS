package com.neu.his.mbg.mapper;

import com.neu.his.mbg.model.DmsCaseModel;
import com.neu.his.mbg.model.DmsCaseModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsCaseModelMapper {
    int countByExample(DmsCaseModelExample example);

    int deleteByExample(DmsCaseModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsCaseModel record);

    int insertSelective(DmsCaseModel record);

    List<DmsCaseModel> selectByExample(DmsCaseModelExample example);

    DmsCaseModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsCaseModel record, @Param("example") DmsCaseModelExample example);

    int updateByExample(@Param("record") DmsCaseModel record, @Param("example") DmsCaseModelExample example);

    int updateByPrimaryKeySelective(DmsCaseModel record);

    int updateByPrimaryKey(DmsCaseModel record);
}