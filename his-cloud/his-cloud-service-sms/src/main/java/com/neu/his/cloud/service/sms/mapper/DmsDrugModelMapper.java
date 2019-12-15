package com.neu.his.cloud.service.sms.mapper;

import com.neu.his.cloud.service.sms.model.DmsDrugModel;
import com.neu.his.cloud.service.sms.model.DmsDrugModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsDrugModelMapper {
    int countByExample(DmsDrugModelExample example);

    int deleteByExample(DmsDrugModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsDrugModel record);

    int insertSelective(DmsDrugModel record);

    List<DmsDrugModel> selectByExample(DmsDrugModelExample example);

    DmsDrugModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsDrugModel record, @Param("example") DmsDrugModelExample example);

    int updateByExample(@Param("record") DmsDrugModel record, @Param("example") DmsDrugModelExample example);

    int updateByPrimaryKeySelective(DmsDrugModel record);

    int updateByPrimaryKey(DmsDrugModel record);
}