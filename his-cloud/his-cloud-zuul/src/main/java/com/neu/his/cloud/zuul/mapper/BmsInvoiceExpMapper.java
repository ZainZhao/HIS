package com.neu.his.cloud.zuul.mapper;

import com.neu.his.cloud.zuul.model.BmsInvoiceExp;
import com.neu.his.cloud.zuul.model.BmsInvoiceExpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmsInvoiceExpMapper {
    int countByExample(BmsInvoiceExpExample example);

    int deleteByExample(BmsInvoiceExpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BmsInvoiceExp record);

    int insertSelective(BmsInvoiceExp record);

    List<BmsInvoiceExp> selectByExample(BmsInvoiceExpExample example);

    BmsInvoiceExp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BmsInvoiceExp record, @Param("example") BmsInvoiceExpExample example);

    int updateByExample(@Param("record") BmsInvoiceExp record, @Param("example") BmsInvoiceExpExample example);

    int updateByPrimaryKeySelective(BmsInvoiceExp record);

    int updateByPrimaryKey(BmsInvoiceExp record);
}