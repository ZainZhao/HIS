package com.neu.his.cloud.service.dms.mapper;

import com.neu.his.cloud.service.dms.model.DmsNonDrugModel;
import com.neu.his.cloud.service.dms.model.DmsNonDrugModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsNonDrugModelMapper {
    int countByExample(DmsNonDrugModelExample example);

    int deleteByExample(DmsNonDrugModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DmsNonDrugModel record);

    int insertSelective(DmsNonDrugModel record);

    List<DmsNonDrugModel> selectByExample(DmsNonDrugModelExample example);

    DmsNonDrugModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DmsNonDrugModel record, @Param("example") DmsNonDrugModelExample example);

    int updateByExample(@Param("record") DmsNonDrugModel record, @Param("example") DmsNonDrugModelExample example);

    int updateByPrimaryKeySelective(DmsNonDrugModel record);

    int updateByPrimaryKey(DmsNonDrugModel record);
}