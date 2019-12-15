package com.neu.his.cloud.service.bms.service.impl;


import com.neu.his.cloud.service.bms.dto.bms.BmsInvoiceResult;
import com.neu.his.cloud.service.bms.mapper.BmsBillsRecordMapper;
import com.neu.his.cloud.service.bms.mapper.BmsInvoiceRecordMapper;
import com.neu.his.cloud.service.bms.mapper.BmsOperatorSettleRecordMapper;
import com.neu.his.cloud.service.bms.mapper.BmsSettlementCatMapper;
import com.neu.his.cloud.service.bms.model.*;
import com.neu.his.cloud.service.bms.service.BmsInvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BmsInvoiceServiceImpl implements BmsInvoiceService {
    @Autowired
    BmsBillsRecordMapper bmsBillsRecordMapper;
    @Autowired
    BmsInvoiceRecordMapper bmsInvoiceRecordMapper;
    @Autowired
    BmsSettlementCatMapper bmsSettlementCatMapper;
    @Autowired
    BmsOperatorSettleRecordMapper bmsOperatorSettleRecordMapper;
    //发票补打：
    //1.传入更新后的发票号，挂号id
    //2.根据挂号id在账单表中查找出账单，根据账单id在发票表中查找出最近的一条发票，更新发票号
    @Override
    public int supplementPrintInvoice(Long newInvoiceNo, Long registrationId) {
        BmsBillsRecordExample bmsBillsRecordExample = new BmsBillsRecordExample();
        bmsBillsRecordExample.createCriteria().andRegistrationIdEqualTo(registrationId);
        List<BmsBillsRecord> bmsBillsRecordList = bmsBillsRecordMapper.selectByExample(bmsBillsRecordExample);
        if (!bmsBillsRecordList.isEmpty()){
            BmsBillsRecord bmsBillsRecord = bmsBillsRecordList.get(0);
            Long billId = bmsBillsRecord.getId();
            BmsInvoiceRecordExample bmsInvoiceRecordExample = new BmsInvoiceRecordExample();
            bmsInvoiceRecordExample.createCriteria().andBillIdEqualTo(billId);
            //根据按照创建时间倒排，查找出最近的一条发票
            bmsInvoiceRecordExample.setOrderByClause("create_time desc");
            List<BmsInvoiceRecord> bmsInvoiceRecordList = bmsInvoiceRecordMapper.selectByExample(bmsInvoiceRecordExample);
            if (!bmsBillsRecordList.isEmpty()){
                BmsInvoiceRecord bmsInvoiceRecord = bmsInvoiceRecordList.get(0);//可能有问题
                bmsInvoiceRecord.setInvoiceNo(newInvoiceNo);
                bmsInvoiceRecordMapper.updateByPrimaryKeySelective(bmsInvoiceRecord);
                return 1;
            }
        }
        return 0;
    }
    //发票重打：
    //1.传入原发票号和新发票号
    //2.找出原发票，修改状态为4，并封装相同信息
    //3.插入新发票记录，金额等值
    @Override
    public int reprintInvoice(Long newInvoiceNo, Long oldInvoiceNo) {
        BmsInvoiceRecordExample bmsInvoiceRecordExample = new BmsInvoiceRecordExample();
        bmsInvoiceRecordExample.createCriteria().andInvoiceNoEqualTo(oldInvoiceNo);
        List<BmsInvoiceRecord> bmsInvoiceRecordList = bmsInvoiceRecordMapper.selectByExample(bmsInvoiceRecordExample);
        if (!bmsInvoiceRecordList.isEmpty()){
            BmsInvoiceRecord bmsInvoiceRecord = bmsInvoiceRecordList.get(0);
            BmsInvoiceRecord newBmsInvoiceRecord = new BmsInvoiceRecord();
            BeanUtils.copyProperties(bmsInvoiceRecord,newBmsInvoiceRecord);
            bmsInvoiceRecord.setType(4);
            newBmsInvoiceRecord.setInvoiceNo(newInvoiceNo);
            newBmsInvoiceRecord.setType(1);
            newBmsInvoiceRecord.setCreateTime(new Date());
            bmsInvoiceRecordMapper.updateByPrimaryKeySelective(bmsInvoiceRecord);
            bmsInvoiceRecordMapper.insertSelective(newBmsInvoiceRecord);
            return 1;
        }
        return 0;
    }
    //传入新的start_datetime和end_datetime和收费员id，查询发票信息
    @Override
    public List<BmsInvoiceResult> queryInvoiceInfo(Long cashierId, Date startDatetime, Date endDatetime) {
        List<BmsInvoiceResult> bmsInvoiceResultList = new ArrayList<>();
        BmsInvoiceRecordExample bmsInvoiceRecordExample = new BmsInvoiceRecordExample();
        bmsInvoiceRecordExample.createCriteria().andOperatorIdEqualTo(cashierId).andCreateTimeBetween(startDatetime,endDatetime);
        bmsInvoiceRecordExample.setOrderByClause("create_time asc");
        List<BmsInvoiceRecord> bmsInvoiceRecordList = bmsInvoiceRecordMapper.selectByExample(bmsInvoiceRecordExample);
        for (BmsInvoiceRecord bmsInvoiceRecord : bmsInvoiceRecordList){
            BmsInvoiceResult bmsInvoiceResult = new BmsInvoiceResult();
            BeanUtils.copyProperties(bmsInvoiceRecord,bmsInvoiceResult);
            //结算类型name
            if (bmsInvoiceRecord.getSettlementCatId() != null){
                String settlementCatName = bmsSettlementCatMapper.selectByPrimaryKey(bmsInvoiceRecord.getSettlementCatId()).getName();
                bmsInvoiceResult.setSettlementCatName(settlementCatName);
            }
            //对账人id,所属日结记录id
            BmsOperatorSettleRecord bmsOperatorSettleRecord = bmsOperatorSettleRecordMapper.selectByPrimaryKey(bmsInvoiceRecord.getSettleRecordId());
            if (bmsOperatorSettleRecord != null){
                bmsInvoiceResult.setOperatorSettleId(bmsOperatorSettleRecord.getVerifyOperatorId());
                bmsInvoiceResult.setSettleRecordId(bmsOperatorSettleRecord.getId());
            }
            bmsInvoiceResultList.add(bmsInvoiceResult);
        }
        return bmsInvoiceResultList;
    }
    //根据日结记录id查询发票详细信息
    @Override
    public List<BmsInvoiceResult> queryInvoiceInfoBySettleId(Long settleRecordId) {
        List<BmsInvoiceResult> bmsInvoiceResultList = new ArrayList<>();
        BmsOperatorSettleRecord bmsOperatorSettleRecord = bmsOperatorSettleRecordMapper.selectByPrimaryKey(settleRecordId);

        BmsInvoiceRecordExample bmsInvoiceRecordExample = new BmsInvoiceRecordExample();
        bmsInvoiceRecordExample.createCriteria().andSettleRecordIdEqualTo(settleRecordId);
        List<BmsInvoiceRecord> bmsInvoiceRecordList = bmsInvoiceRecordMapper.selectByExample(bmsInvoiceRecordExample);
        if (!bmsInvoiceRecordList.isEmpty()){
            for (BmsInvoiceRecord bmsInvoiceRecord : bmsInvoiceRecordList){
                BmsInvoiceResult bmsInvoiceResult = new BmsInvoiceResult();
                BeanUtils.copyProperties(bmsInvoiceRecord,bmsInvoiceResult);
                //结算类型name
                String settlementCatName = bmsSettlementCatMapper.selectByPrimaryKey(bmsInvoiceRecord.getSettlementCatId()).getName();
                bmsInvoiceResult.setSettlementCatName(settlementCatName);
                //对账人id,所属日结记录id
                bmsInvoiceResult.setOperatorSettleId(bmsOperatorSettleRecord.getVerifyOperatorId());
                bmsInvoiceResult.setSettleRecordId(bmsOperatorSettleRecord.getId());
                bmsInvoiceResultList.add(bmsInvoiceResult);
            }
        }
        return bmsInvoiceResultList;
    }
}
