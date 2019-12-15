package com.neu.his.mbg.mapper;

import com.neu.his.mbg.model.DmsCaseHistory;
import com.neu.his.mbg.model.DmsCaseHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsCaseHistoryMapper {
    int countByExample(DmsCaseHistoryExample example);

    int deleteByExample(DmsCaseHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsCaseHistory record);

    int insertSelective(DmsCaseHistory record);

    List<DmsCaseHistory> selectByExample(DmsCaseHistoryExample example);

    DmsCaseHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsCaseHistory record, @Param("example") DmsCaseHistoryExample example);

    int updateByExample(@Param("record") DmsCaseHistory record, @Param("example") DmsCaseHistoryExample example);

    int updateByPrimaryKeySelective(DmsCaseHistory record);

    int updateByPrimaryKey(DmsCaseHistory record);
}