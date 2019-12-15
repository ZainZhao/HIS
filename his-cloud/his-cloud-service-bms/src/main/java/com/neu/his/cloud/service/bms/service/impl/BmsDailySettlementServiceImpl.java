package com.neu.his.cloud.service.bms.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.neu.his.cloud.service.bms.dto.bms.BmsDailySettleRecordResult;
import com.neu.his.cloud.service.bms.dto.bms.BmsSettleListItemResult;
import com.neu.his.cloud.service.bms.mapper.BmsInvoiceRecordMapper;
import com.neu.his.cloud.service.bms.mapper.BmsOperatorSettleRecordMapper;
import com.neu.his.cloud.service.bms.mapper.SmsStaffMapper;
import com.neu.his.cloud.service.bms.model.*;
import com.neu.his.cloud.service.bms.service.BmsDailySettlementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BmsDailySettlementServiceImpl implements BmsDailySettlementService {
    @Autowired
    BmsOperatorSettleRecordMapper bmsOperatorSettleRecordMapper;
    @Autowired
    BmsInvoiceRecordMapper bmsInvoiceRecordMapper;
    @Autowired
    SmsStaffMapper smsStaffMapper;

    //1. 根据收费员id在日结记录表中查询最近的end_datetime
    //如果没有日结记录则返回该收费员最早的操作记录时间，则返回最早最早发票的时间
    @Override
    public Date queryRecentEndDatetime(Long staffId) {
        BmsOperatorSettleRecordExample bmsOperatorSettleRecordExample = new BmsOperatorSettleRecordExample();
        bmsOperatorSettleRecordExample.createCriteria().andCashierIdEqualTo(staffId);
        //按截止时间倒序，选取最上面的一条记录
        bmsOperatorSettleRecordExample.setOrderByClause("end_datetime desc");
        List<BmsOperatorSettleRecord> bmsOperatorSettleRecordList = bmsOperatorSettleRecordMapper.selectByExample(bmsOperatorSettleRecordExample);
        Date endDatetime = null;
        if (!bmsOperatorSettleRecordList.isEmpty()){
            BmsOperatorSettleRecord bmsOperatorSettleRecord = bmsOperatorSettleRecordList.get(0);//可能有问题
            endDatetime = bmsOperatorSettleRecord.getEndDatetime();
        }
        else {
            BmsInvoiceRecordExample bmsInvoiceRecordExample = new BmsInvoiceRecordExample();
            bmsInvoiceRecordExample.createCriteria().andOperatorIdEqualTo(staffId);

            bmsInvoiceRecordExample.setOrderByClause("create_time asc");
            List<BmsInvoiceRecord> bmsInvoiceRecordList = bmsInvoiceRecordMapper.selectByExample(bmsInvoiceRecordExample);
            if (!bmsInvoiceRecordList.isEmpty()){
                endDatetime = bmsInvoiceRecordList.get(0).getCreateTime();
            }
            else {//所操作发票最早的时间
                BmsInvoiceRecordExample bmsInvoiceRecordExampleTemp=new BmsInvoiceRecordExample();
                bmsInvoiceRecordExampleTemp.createCriteria().andOperatorIdEqualTo(staffId);
                bmsInvoiceRecordExampleTemp.setOrderByClause("create_time desc");
                List<BmsInvoiceRecord> bmsInvoiceRecordListTemp = bmsInvoiceRecordMapper.selectByExample(bmsInvoiceRecordExampleTemp);
                if(!CollectionUtil.isEmpty(bmsInvoiceRecordListTemp))
                    endDatetime = bmsInvoiceRecordListTemp.get(0).getCreateTime();
            }
        }
        return endDatetime;

    }


    //根据起始、结束时间和收费员id统计日结信息
    //1. 传入新的start_datetime和end_datetime和收费员id，查询发票信息
    //2. 在发票表中查询记录并封装信息，（所有发票先按时间排序，++看是否断开）
    //除了日结时间CreateDatetime，对账人id verifyOperatorId，对账时间 verifyDatetime，对账状态 verifyStatus
    @Override
    public BmsDailySettleRecordResult statisticDailySettlement(Long cashierId, Date startDatetime, Date endDatetime) {
        BmsDailySettleRecordResult bmsDailySettleRecordResult = new BmsDailySettleRecordResult();

        BmsInvoiceRecordExample bmsInvoiceRecordExample = new BmsInvoiceRecordExample();

        bmsInvoiceRecordExample.createCriteria().andOperatorIdEqualTo(cashierId).andCreateTimeBetween(startDatetime,endDatetime);
        bmsInvoiceRecordExample.setOrderByClause("create_time asc");
        List<BmsInvoiceRecord> bmsInvoiceRecordList = bmsInvoiceRecordMapper.selectByExample(bmsInvoiceRecordExample);

        Long invoiceNum = 0l;//发票总数量
        Long rushInvoiceNum = 0l;//冲红发票数量
        Long reprintInvoiceNum = 0l;//重打发票数量

        String startEndInvoiceIdStr = "";//起始结束发票id串
        String rushInvoiceIdListStr = "";//冲红发票id list
        String reprintInvoiceIdListStr = "";//重打发票id list

        BigDecimal medicineAmount = new BigDecimal(0);//成药总金额
        BigDecimal herbalAmount = new BigDecimal(0);//草药总金额
        BigDecimal checkAmount = new BigDecimal(0);//检查总金额
        BigDecimal registrationAmount = new BigDecimal(0);//挂号总金额
        BigDecimal dispositionAmount = new BigDecimal(0);//处置总金额
        BigDecimal testAmount = new BigDecimal(0);//检验总金额

        BigDecimal amount = new BigDecimal(0);//总金额
        BigDecimal cashAmount = new BigDecimal(0);//现金总金额
        BigDecimal insuranceAmount = new BigDecimal(0);//医保总金额
        BigDecimal bankCardAmount = new BigDecimal(0);//银行卡总金额
        BigDecimal  alipayAmount = new BigDecimal(0);//支付宝总金额
        BigDecimal  wechatAmount = new BigDecimal(0);//微信总金额
        BigDecimal  creditCardAmount = new BigDecimal(0);//信用卡总金额
        BigDecimal otherAmount = new BigDecimal(0);//其他总金额

        if (!bmsInvoiceRecordList.isEmpty()){
            Long lastInvoiceNo = null;//存上一张发票的发票号
            Long startInvoice = null;
            Long endInvoice = null;
            for (int i=0;i<bmsInvoiceRecordList.size();i++){
                //拼接起始结束发票id串
                if (lastInvoiceNo == null){
                    startInvoice = bmsInvoiceRecordList.get(i).getInvoiceNo();
                }
                else if (bmsInvoiceRecordList.get(i).getInvoiceNo() != (lastInvoiceNo+1)){
                    endInvoice = lastInvoiceNo;
                    if (startInvoice != endInvoice){
                        startEndInvoiceIdStr = startEndInvoiceIdStr + (startInvoice + "-" + endInvoice + ",");
                    }
                    else if (startInvoice == endInvoice){
                        startEndInvoiceIdStr = startEndInvoiceIdStr + (startInvoice + ",");
                    }
                    startInvoice = bmsInvoiceRecordList.get(i).getInvoiceNo();
                }
                if (i == (bmsInvoiceRecordList.size()-1)){
                    if (bmsInvoiceRecordList.get(i).getInvoiceNo() == (lastInvoiceNo + 1)){
                        startEndInvoiceIdStr = startEndInvoiceIdStr + (startInvoice + "-" + bmsInvoiceRecordList.get(i).getInvoiceNo());
                    }
                    else{
                        if (startInvoice == lastInvoiceNo){
                            startEndInvoiceIdStr = startEndInvoiceIdStr + (startInvoice + "," + bmsInvoiceRecordList.get(i).getInvoiceNo());
                        }
                        else{
                            startEndInvoiceIdStr = startEndInvoiceIdStr + bmsInvoiceRecordList.get(i).getInvoiceNo();
                        }
                    }
                }
                lastInvoiceNo = bmsInvoiceRecordList.get(i).getInvoiceNo();
                invoiceNum++;//发票总数量
                if (bmsInvoiceRecordList.get(i).getType() == 2){//冲红发票
                    rushInvoiceNum++;
                    if (rushInvoiceIdListStr == ""){
                        rushInvoiceIdListStr = rushInvoiceIdListStr + (bmsInvoiceRecordList.get(i).getInvoiceNo());
                    }
                    else{
                        rushInvoiceIdListStr = rushInvoiceIdListStr + ("," + bmsInvoiceRecordList.get(i).getInvoiceNo() );
                    }
                }
                else if (bmsInvoiceRecordList.get(i).getType() == 4){//重打发票
                    reprintInvoiceNum++;
                    if (reprintInvoiceIdListStr == ""){
                        reprintInvoiceIdListStr = reprintInvoiceIdListStr + (bmsInvoiceRecordList.get(i).getInvoiceNo());
                    }
                    else{
                        reprintInvoiceIdListStr = reprintInvoiceIdListStr + ( "," + bmsInvoiceRecordList.get(i).getInvoiceNo());
                    }
                }
                if (bmsInvoiceRecordList.get(i).getType() == 1){//正常发票
                    String itemList = bmsInvoiceRecordList.get(i).getItemList();
                    if (itemList != null){
                        String[][] resolvedItemList = resolveItemList(itemList);
                        if (resolvedItemList.length != 0){
                            for(int x = 0; x < resolvedItemList.length ; x++) {
                           //     Long idOfOneItem = Long.valueOf(resolvedItemList[x][0]);
                                Integer typeOfOneItem = Integer.valueOf(resolvedItemList[x][1]);
                                BigDecimal amountOfOneItem = new BigDecimal(resolvedItemList[x][2]);
                                if (typeOfOneItem == 0){//挂号
                                    registrationAmount = registrationAmount.add(amountOfOneItem);
                                }
                                else if (typeOfOneItem == 1){//检查
                                    checkAmount = checkAmount.add(amountOfOneItem);
                                }
                                else if (typeOfOneItem == 2){//检验
                                    testAmount = testAmount.add(amountOfOneItem);
                                }
                                else if (typeOfOneItem == 3){//处置
                                    dispositionAmount = dispositionAmount.add(amountOfOneItem);
                                }
                                else if (typeOfOneItem == 4){//草药
                                    herbalAmount = herbalAmount.add(amountOfOneItem);

                                }
                                else if (typeOfOneItem == 5){//成药
                                    medicineAmount = medicineAmount.add(amountOfOneItem);
                                }
                            }
                            amount = amount.add(bmsInvoiceRecordList.get(i).getAmount());//总金额
                            if (bmsInvoiceRecordList.get(i).getSettlementCatId() == 1){//现金
                                cashAmount = cashAmount.add(bmsInvoiceRecordList.get(i).getAmount());
                            }
                            else if (bmsInvoiceRecordList.get(i).getSettlementCatId() == 2){//银行卡
                                bankCardAmount = bankCardAmount.add(bmsInvoiceRecordList.get(i).getAmount());
                            }
                            else if (bmsInvoiceRecordList.get(i).getSettlementCatId() == 3){//医保
                                insuranceAmount = insuranceAmount.add(bmsInvoiceRecordList.get(i).getAmount());
                            }
                            else if (bmsInvoiceRecordList.get(i).getSettlementCatId() == 4){//信用卡
                                creditCardAmount = creditCardAmount.add(bmsInvoiceRecordList.get(i).getAmount());
                            }
                            else  if (bmsInvoiceRecordList.get(i).getSettlementCatId() == 5){//支付宝
                                alipayAmount = alipayAmount.add(bmsInvoiceRecordList.get(i).getAmount());
                            }
                            else if (bmsInvoiceRecordList.get(i).getSettlementCatId() == 6){//微信
                                wechatAmount = wechatAmount.add(bmsInvoiceRecordList.get(i).getAmount());
                            }
                            else if (bmsInvoiceRecordList.get(i).getSettlementCatId() == 7){//其他
                                otherAmount = otherAmount.add(bmsInvoiceRecordList.get(i).getAmount());
                            }
                        }
                    }
                }
            }
        }
        //开始,截止时间
        bmsDailySettleRecordResult.setStartDatetime(startDatetime);
        bmsDailySettleRecordResult.setEndDatetime(endDatetime);
        //收银员（日结员）id
        bmsDailySettleRecordResult.setCashierId(cashierId);

        bmsDailySettleRecordResult.setInvoiceNum(invoiceNum);
        bmsDailySettleRecordResult.setRushInvoiceNum(rushInvoiceNum);
        bmsDailySettleRecordResult.setReprintInvoiceNum(reprintInvoiceNum);
        bmsDailySettleRecordResult.setStartEndInvoiceIdStr(startEndInvoiceIdStr);
        bmsDailySettleRecordResult.setRushInvoiceIdListStr(rushInvoiceIdListStr);
        bmsDailySettleRecordResult.setReprintInvoiceIdListStr(reprintInvoiceIdListStr);
        bmsDailySettleRecordResult.setMedicineAmount(medicineAmount);
        bmsDailySettleRecordResult.setHerbalAmount(herbalAmount);
        bmsDailySettleRecordResult.setCheckAmount(checkAmount);
        bmsDailySettleRecordResult.setRegistrationAmount(registrationAmount);
        bmsDailySettleRecordResult.setDispositionAmount(dispositionAmount);
        bmsDailySettleRecordResult.setTestAmount(testAmount);
        bmsDailySettleRecordResult.setAmount(amount);
        bmsDailySettleRecordResult.setCashAmount(cashAmount);
        bmsDailySettleRecordResult.setInsuranceAmount(insuranceAmount);
        bmsDailySettleRecordResult.setBankCardAmount(bankCardAmount);
        bmsDailySettleRecordResult.setAlipayAmount(alipayAmount);
        bmsDailySettleRecordResult.setWechatAmount(wechatAmount);
        bmsDailySettleRecordResult.setCreditCardAmount(creditCardAmount);
        bmsDailySettleRecordResult.setOtherAmount(otherAmount);

        return bmsDailySettleRecordResult;
    }
    //根据起始、结束时间和收费员id列出日结历史
    @Override
    public List<BmsSettleListItemResult> listDailySettleListRecord(Long cashierId, Date startDatetime, Date endDatetime) {
        List<BmsSettleListItemResult> bmsSettleListItemResultList = new ArrayList<>();
        BmsOperatorSettleRecordExample bmsOperatorSettleRecordExample = new BmsOperatorSettleRecordExample();
        bmsOperatorSettleRecordExample.createCriteria().andCashierIdEqualTo(cashierId).andCreateDatetimeBetween(startDatetime,endDatetime);
        List<BmsOperatorSettleRecord> bmsOperatorSettleRecordList = bmsOperatorSettleRecordMapper.selectByExample(bmsOperatorSettleRecordExample);
        if (!bmsOperatorSettleRecordList.isEmpty()){
            SmsStaff smsStaff = smsStaffMapper.selectByPrimaryKey(cashierId);
            String cashierName = smsStaff.getName();
            for (BmsOperatorSettleRecord bmsOperatorSettleRecord : bmsOperatorSettleRecordList){
                BmsSettleListItemResult bmsSettleListItemResult = new BmsSettleListItemResult();
                bmsSettleListItemResult.setCashierId(cashierId);
                bmsSettleListItemResult.setOperatorName(cashierName);
                bmsSettleListItemResult.setCreateDatetme(bmsOperatorSettleRecord.getCreateDatetime());
                bmsSettleListItemResult.setSettleRecordId(bmsOperatorSettleRecord.getId());
                bmsSettleListItemResult.setVerifyStatus(bmsOperatorSettleRecord.getVerifyStatus());
                bmsSettleListItemResultList.add(bmsSettleListItemResult);
            }
        }

        return bmsSettleListItemResultList;
    }
    //根据日结记录id查询日结详细信息
    @Override
    public BmsDailySettleRecordResult querySettleDetailById(Long id) {
        BmsOperatorSettleRecord bmsOperatorSettleRecord = bmsOperatorSettleRecordMapper.selectByPrimaryKey(id);
        BmsDailySettleRecordResult bmsDailySettleRecordResult = new BmsDailySettleRecordResult();
        if (bmsOperatorSettleRecord != null){

            BeanUtils.copyProperties(bmsOperatorSettleRecord,bmsDailySettleRecordResult);
            return bmsDailySettleRecordResult;
        }
        return null;
    }
    //收费员日结：
    //1. 传入新的start_datetime和end_datetime和收费员id，查询发票信息
    //2. 在发票表中查询记录并封装信息，（所有发票先按时间排序，++看是否断开）插入日结记录，并根据start_datetime和end_datetime和收费员id查询并返回刚插入的日结记录id
    //3. 遍历相关发票，设置发票所属日结记录id，并修改freeze_status为1
    @Override
    public Long dailySettle(Long cashierId, Date startDatetime, Date endDatetime) {
        BmsDailySettleRecordResult bmsDailySettleRecordResult = statisticDailySettlement(cashierId, startDatetime, endDatetime);
        BmsOperatorSettleRecord bmsOperatorSettleRecord = new BmsOperatorSettleRecord();
        BeanUtils.copyProperties(bmsDailySettleRecordResult,bmsOperatorSettleRecord);
        //日结时间
        bmsOperatorSettleRecord.setCreateDatetime(new Date());
        bmsOperatorSettleRecordMapper.insertSelective(bmsOperatorSettleRecord);
        Long bmsOperatorSettleRecordId = bmsOperatorSettleRecord.getId();//插入的日结记录id
        //遍历相关发票，设置发票所属日结记录id，并修改freeze_status为1
        BmsInvoiceRecordExample bmsInvoiceRecordExample = new BmsInvoiceRecordExample();
        bmsInvoiceRecordExample.createCriteria().andOperatorIdEqualTo(cashierId).andCreateTimeBetween(startDatetime,endDatetime);
        bmsInvoiceRecordExample.setOrderByClause("create_time asc");
        List<BmsInvoiceRecord> bmsInvoiceRecordList = bmsInvoiceRecordMapper.selectByExample(bmsInvoiceRecordExample);
        if (!bmsInvoiceRecordList.isEmpty()){
            for (BmsInvoiceRecord bmsInvoiceRecord : bmsInvoiceRecordList){
                bmsInvoiceRecord.setFreezeStatus(1);
                bmsInvoiceRecord.setSettleRecordId(bmsOperatorSettleRecordId);
                bmsInvoiceRecordMapper.updateByPrimaryKeySelective(bmsInvoiceRecord);
            }
        }
        return bmsOperatorSettleRecordId;
    }
    //财务处对账
    //1.根据settleRecordId找出日结记录，并修改status为1，更新对账时间和对账人id
    @Override
    public int verifySettle(Long verifyOperatorId, Long settleRecordId) {
        BmsOperatorSettleRecord bmsOperatorSettleRecord = bmsOperatorSettleRecordMapper.selectByPrimaryKey(settleRecordId);
        if (bmsOperatorSettleRecord != null){
            bmsOperatorSettleRecord.setVerifyStatus(1);
            bmsOperatorSettleRecord.setVerifyDatetime(new Date());
            bmsOperatorSettleRecord.setVerifyOperatorId(verifyOperatorId);
            bmsOperatorSettleRecordMapper.updateByPrimaryKeySelective(bmsOperatorSettleRecord);
            return 1;
        }
        return 0;
    }

    //解析发票的itemList
    public String[][] resolveItemList(String itemList){
        String[] prescription = itemList.split("><");
        String[][] result = new String[prescription.length][3];
        for (int i = 0 ; i < prescription.length ; i++){
            String[] item = prescription[i].split(",");
            for (int j = 0 ; j < item.length ; j++){
                result[i][j] = item[j];
            }
        }
        return result;
    }
}
