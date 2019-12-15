package com.neu.his.sms.impl;

import com.neu.his.common.dto.sms.SmsDeptAmountStatisticsResult;
import com.neu.his.common.dto.sms.SmsStaffAmountStatisticsResult;
import com.neu.his.common.dto.sms.SmsPatientsStatisticsResult;
import com.neu.his.common.util.DateUtil;
import com.neu.his.sms.SmsEchartsService;
import com.neu.his.mbg.mapper.SmsDeptMapper;
import com.neu.his.mbg.mapper.SmsWorkloadRecordMapper;
import com.neu.his.mbg.model.SmsDept;
import com.neu.his.mbg.model.SmsWorkloadRecord;
import com.neu.his.mbg.model.SmsWorkloadRecordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * echarts数据统计
 */
@Service
public class SmsEchartsServiceImpl implements SmsEchartsService {
    @Autowired
    SmsWorkloadRecordMapper smsWorkloadRecordMapper;
    @Autowired
    SmsDeptMapper smsDeptMapper;

    @Override
    public SmsPatientsStatisticsResult staffPatients(Long staffId) {
        SmsPatientsStatisticsResult smsPatientsStatisticsResult = new SmsPatientsStatisticsResult();
        List<String> dateOfSevenDays = new ArrayList<>(7);
        List<Long> numOfPatients = new ArrayList<>(7);

        Date today = DateUtil.setMilliSecond(DateUtil.getDate(new Date()),0);
        SmsWorkloadRecordExample smsWorkloadRecordExample = new SmsWorkloadRecordExample();
        smsWorkloadRecordExample.createCriteria().andStaffIdEqualTo(staffId).andDateBetween(DateUtil.getDateBefore(today,7),today);
        smsWorkloadRecordExample.setOrderByClause("date desc");
        List<SmsWorkloadRecord> smsWorkloadRecordList = smsWorkloadRecordMapper.selectByExample(smsWorkloadRecordExample);
        System.err.println(smsWorkloadRecordList);
        if (!smsWorkloadRecordList.isEmpty()){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (int i=0;i<7;i++){
                dateOfSevenDays.add(formatter.format(DateUtil.getDateBefore(today,7-i)));
                numOfPatients.add(0l);
            }
            for (SmsWorkloadRecord smsWorkloadRecord : smsWorkloadRecordList){
                int sub = DateUtil.getDateSubtraction(smsWorkloadRecord.getDate(),today);
                System.err.println(dateOfSevenDays);
                System.err.println("sub: "+sub);
                if (smsWorkloadRecord.getType() == 0){//门诊医生
                    numOfPatients.set(7-sub,smsWorkloadRecord.getRegistrationNum());
                }
                else if (smsWorkloadRecord.getType() == 1){//医技医生
                    numOfPatients.set(7-sub,smsWorkloadRecord.getExcuteNum());
                }

            }
            smsPatientsStatisticsResult.setDateOfSevenDays(dateOfSevenDays);
            smsPatientsStatisticsResult.setNumOfPatients(numOfPatients);
            return smsPatientsStatisticsResult;
        }
        return null;
    }

    @Override
    public SmsStaffAmountStatisticsResult staffClassifyStatistics(Long staffId) {
        SmsStaffAmountStatisticsResult smsStaffAmountStatisticsResult = new SmsStaffAmountStatisticsResult();
        List<String> amountCat = new ArrayList<>();
        List<BigDecimal> amount = new ArrayList<>();

        Date today = DateUtil.setMilliSecond(DateUtil.getDate(new Date()),0);
        SmsWorkloadRecordExample smsWorkloadRecordExample = new SmsWorkloadRecordExample();
        smsWorkloadRecordExample.createCriteria().andStaffIdEqualTo(staffId).andDateBetween(DateUtil.getDateBefore(today,7),today);
        smsWorkloadRecordExample.setOrderByClause("date desc");
        List<SmsWorkloadRecord> smsWorkloadRecordList = smsWorkloadRecordMapper.selectByExample(smsWorkloadRecordExample);
        if (!smsWorkloadRecordList.isEmpty()){
            BigDecimal medicine = new BigDecimal(0);
            BigDecimal herbal = new BigDecimal(0);
            BigDecimal check = new BigDecimal(0);
            BigDecimal test = new BigDecimal(0);
            BigDecimal disposition = new BigDecimal(0);
            if (smsWorkloadRecordList.get(0).getType() == 0){//门诊医生
                amountCat.add("西药费");
                amountCat.add("中药费");
                amountCat.add("检查费");
                amountCat.add("检验费");
                amountCat.add("处置费");
                for (SmsWorkloadRecord smsWorkloadRecord : smsWorkloadRecordList){
                    medicine = medicine.add(smsWorkloadRecord.getMedicineAmount());
                    herbal = herbal.add(smsWorkloadRecord.getHerbalAmount());
                    check = check.add(smsWorkloadRecord.getCheckAmount());
                    test = test.add(smsWorkloadRecord.getTestAmount());
                    disposition = disposition.add(smsWorkloadRecord.getDispositionAmount());
                }
                amount.add(medicine);
                amount.add(herbal);
                amount.add(check);
                amount.add(test);
                amount.add(disposition);
            }
            smsStaffAmountStatisticsResult.setAmountCat(amountCat);
            smsStaffAmountStatisticsResult.setAmount(amount);
            return smsStaffAmountStatisticsResult;
//            else if (smsWorkloadRecordList.get(0).getType() == 1){//医技医生
//                amountCat.add("检查费");
//                amountCat.add("检验费");
//                amountCat.add("处置费");
//                for (SmsWorkloadRecord smsWorkloadRecord : smsWorkloadRecordList){
//                    check = check.add(smsWorkloadRecord.getExcuteCheckAmount());
//                    test = test.add(smsWorkloadRecord.getExcuteTestAmount());
//                    disposition = disposition.add(smsWorkloadRecord.getDispositionAmount());
//                }
//                amount.add(check);
//                amount.add(test);
//                amount.add(disposition);
//            }

        }
        return null;
    }

    @Override
    public SmsPatientsStatisticsResult deptPatients(Long deptId) {
        SmsPatientsStatisticsResult smsPatientsStatisticsResult = new SmsPatientsStatisticsResult();
        List<String> dateOfSevenDays = new ArrayList<>(7);
        List<Long> numOfPatients = new ArrayList<>(7);
        Integer deptType = 0;
        SmsDept smsDept = smsDeptMapper.selectByPrimaryKey(deptId);
        if (smsDept!=null){
            if (smsDept.getType() == 0){
                deptType = 0;//门诊科室
            }
            else if (smsDept.getType()>0 && smsDept.getType()<4){
                deptType = 1;//医技科室
            }
        }

        Date today = DateUtil.setMilliSecond(DateUtil.getDate(new Date()),0);
        SmsWorkloadRecordExample smsWorkloadRecordExample = new SmsWorkloadRecordExample();
        smsWorkloadRecordExample.createCriteria().andDeptIdEqualTo(deptId).andDateBetween(DateUtil.getDateBefore(today,7),today).andTypeEqualTo(2);
        smsWorkloadRecordExample.setOrderByClause("date desc");
        List<SmsWorkloadRecord> smsWorkloadRecordList = smsWorkloadRecordMapper.selectByExample(smsWorkloadRecordExample);
        if (!smsWorkloadRecordList.isEmpty()){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (int i=0;i<7;i++){
                dateOfSevenDays.add(formatter.format(DateUtil.getDateBefore(today,7-i)));
                numOfPatients.add(0l);
            }
            for (SmsWorkloadRecord smsWorkloadRecord : smsWorkloadRecordList){
                int sub = DateUtil.getDateSubtraction(smsWorkloadRecord.getDate(),today);
                if (deptType == 0){//门诊
                    numOfPatients.set(7-sub,smsWorkloadRecord.getRegistrationNum());
                }
                else if (deptType == 1){//医技
                    numOfPatients.set(7-sub,smsWorkloadRecord.getExcuteNum());
                }

            }
            smsPatientsStatisticsResult.setDateOfSevenDays(dateOfSevenDays);
            smsPatientsStatisticsResult.setNumOfPatients(numOfPatients);
            return smsPatientsStatisticsResult;
        }
        return null;
    }

    @Override
    public SmsDeptAmountStatisticsResult deptClassifyStatistics(Long deptId) {
        SmsDeptAmountStatisticsResult smsDeptAmountStatisticsResult = new SmsDeptAmountStatisticsResult();
        List<String> dateOfSevenDays = new ArrayList<>();
        List<String> amountCat = new ArrayList<>();
        List<BigDecimal> medicineAmount = new ArrayList<>();
        List<BigDecimal> herbalAmount = new ArrayList<>();
        List<BigDecimal> checkAmount = new ArrayList<>();
        List<BigDecimal> testAmount = new ArrayList<>();
        List<BigDecimal> dispositionAmount = new ArrayList<>();
        List<BigDecimal> executedAmount = new ArrayList<>();
        Integer deptType = 0;
        SmsDept smsDept = smsDeptMapper.selectByPrimaryKey(deptId);
        amountCat.add("西药费");
        amountCat.add("中药费");
        amountCat.add("检查费");
        amountCat.add("检验费");
        amountCat.add("处置费");
        if (smsDept!=null){
            if (smsDept.getType() == 0){
                deptType = 0;//门诊科室
            }
            else if (smsDept.getType() == 1){
                deptType = 1;//检查
                amountCat.add("执行检查费");
            }
            else if (smsDept.getType() == 2){
                deptType = 2;//检验
                amountCat.add("执行检验费");
            }
            else if (smsDept.getType() == 3){
                deptType =3;//处置
                amountCat.add("执行处置费");
            }
        }
        Date today = DateUtil.setMilliSecond(DateUtil.getDate(new Date()),0);
        SmsWorkloadRecordExample smsWorkloadRecordExample = new SmsWorkloadRecordExample();
        smsWorkloadRecordExample.createCriteria().andDeptIdEqualTo(deptId).andDateBetween(DateUtil.getDateBefore(today,7),today).andTypeEqualTo(2);
        smsWorkloadRecordExample.setOrderByClause("date desc");
        List<SmsWorkloadRecord> smsWorkloadRecordList = smsWorkloadRecordMapper.selectByExample(smsWorkloadRecordExample);
        if (!smsWorkloadRecordList.isEmpty()){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (int i=0;i<7;i++){
                dateOfSevenDays.add(formatter.format(DateUtil.getDateBefore(today,7-i)));
                medicineAmount.add(new BigDecimal(0));
                herbalAmount.add(new BigDecimal(0));
                checkAmount.add(new BigDecimal(0));
                testAmount.add(new BigDecimal(0));
                dispositionAmount.add(new BigDecimal(0));
                executedAmount.add(new BigDecimal(0));
            }

            for (SmsWorkloadRecord smsWorkloadRecord : smsWorkloadRecordList){
                int sub = DateUtil.getDateSubtraction(smsWorkloadRecord.getDate(),today);
                medicineAmount.set(7-sub,smsWorkloadRecord.getMedicineAmount());
                herbalAmount.set(7-sub,smsWorkloadRecord.getHerbalAmount());
                checkAmount.set(7-sub,smsWorkloadRecord.getCheckAmount());
                testAmount.set(7-sub,smsWorkloadRecord.getTestAmount());
                dispositionAmount.set(7-sub,smsWorkloadRecord.getDispositionAmount());
                if (deptType == 1){//检查
                    executedAmount.set(7-sub,smsWorkloadRecord.getExcuteCheckAmount());
                }
                else if (deptType == 2){//检验
                    executedAmount.set(7-sub,smsWorkloadRecord.getExcuteTestAmount());
                }
                else if (deptType == 3){//处置
                    executedAmount.set(7-sub,smsWorkloadRecord.getExcuteDispositionAmount());
                }

            }
            smsDeptAmountStatisticsResult.setAmountCat(amountCat);
            smsDeptAmountStatisticsResult.setMedicineAmount(medicineAmount);
            smsDeptAmountStatisticsResult.setHerbalAmount(herbalAmount);
            smsDeptAmountStatisticsResult.setCheckAmount(checkAmount);
            smsDeptAmountStatisticsResult.setTestAmount(testAmount);
            smsDeptAmountStatisticsResult.setDispositionAmount(dispositionAmount);
            smsDeptAmountStatisticsResult.setExecutedAmount(executedAmount);
            smsDeptAmountStatisticsResult.setDateOfSevenDays(dateOfSevenDays);

            return smsDeptAmountStatisticsResult;
        }
       return null;
    }

    @Override
    public SmsDeptAmountStatisticsResult totalClassifyStatistics() {
        SmsDeptAmountStatisticsResult smsDeptAmountStatisticsResult = new SmsDeptAmountStatisticsResult();
        List<String> dateOfSevenDays = new ArrayList<>();
        List<String> amountCat = new ArrayList<>();
        List<BigDecimal> medicineAmount = new ArrayList<>();
        List<BigDecimal> herbalAmount = new ArrayList<>();
        List<BigDecimal> checkAmount = new ArrayList<>();
        List<BigDecimal> testAmount = new ArrayList<>();
        List<BigDecimal> dispositionAmount = new ArrayList<>();

        Date today = DateUtil.setMilliSecond(DateUtil.getDate(new Date()),0);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (int i=0;i<7;i++){
            dateOfSevenDays.add(formatter.format(DateUtil.getDateBefore(today,7-i)));
        }
        amountCat.add("西药费");
        amountCat.add("中药费");
        amountCat.add("检查费");
        amountCat.add("检验费");
        amountCat.add("处置费");
        SmsWorkloadRecordExample smsWorkloadRecordExample = new SmsWorkloadRecordExample();
        for (int i=7;i>0;i--){
            smsWorkloadRecordExample.clear();
            smsWorkloadRecordExample.createCriteria().andDateEqualTo(DateUtil.getDateBefore(today,i)).andTypeEqualTo(2);
            //smsWorkloadRecordExample.setOrderByClause("date desc");
            List<SmsWorkloadRecord> smsWorkloadRecordList = smsWorkloadRecordMapper.selectByExample(smsWorkloadRecordExample);
            if (!smsWorkloadRecordList.isEmpty()){
                BigDecimal medicine = new BigDecimal(0);
                BigDecimal herbal = new BigDecimal(0);
                BigDecimal check = new BigDecimal(0);
                BigDecimal test = new BigDecimal(0);
                BigDecimal disposition = new BigDecimal(0);
                for (SmsWorkloadRecord smsWorkloadRecord : smsWorkloadRecordList){
                    medicine = medicine.add(smsWorkloadRecord.getMedicineAmount());
                    herbal = herbal.add(smsWorkloadRecord.getHerbalAmount());
                    check = check.add(smsWorkloadRecord.getCheckAmount());
                    test = test.add(smsWorkloadRecord.getTestAmount());
                    disposition = disposition.add(smsWorkloadRecord.getDispositionAmount());
                }
                medicineAmount.add(medicine);
                herbalAmount.add(herbal);
                checkAmount.add(check);
                testAmount.add(test);
                dispositionAmount.add(disposition);
            }
        }
        smsDeptAmountStatisticsResult.setDateOfSevenDays(dateOfSevenDays);
        smsDeptAmountStatisticsResult.setAmountCat(amountCat);
        smsDeptAmountStatisticsResult.setMedicineAmount(medicineAmount);
        smsDeptAmountStatisticsResult.setHerbalAmount(herbalAmount);
        smsDeptAmountStatisticsResult.setCheckAmount(checkAmount);
        smsDeptAmountStatisticsResult.setTestAmount(testAmount);
        smsDeptAmountStatisticsResult.setDispositionAmount(dispositionAmount);


        return smsDeptAmountStatisticsResult;
    }

    @Override
    public SmsPatientsStatisticsResult totalPatients() {
        SmsPatientsStatisticsResult smsPatientsStatisticsResult = new SmsPatientsStatisticsResult();
        List<String> dateOfSevenDays = new ArrayList<>(7);
        List<Long> numOfPatients = new ArrayList<>(7);
        Date today = DateUtil.setMilliSecond(DateUtil.getDate(new Date()),0);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (int i=0;i<7;i++){
            dateOfSevenDays.add(formatter.format(DateUtil.getDateBefore(today,7-i)));
        }
        SmsWorkloadRecordExample smsWorkloadRecordExample = new SmsWorkloadRecordExample();
        for (int i=7;i>0;i--){
            smsWorkloadRecordExample.clear();
            smsWorkloadRecordExample.createCriteria().andDateEqualTo(DateUtil.getDateBefore(today,i)).andTypeEqualTo(2);
            //smsWorkloadRecordExample.setOrderByClause("date desc");
            List<SmsWorkloadRecord> smsWorkloadRecordList = smsWorkloadRecordMapper.selectByExample(smsWorkloadRecordExample);
            if (!smsWorkloadRecordList.isEmpty()){
                Long num = 0l;
                for (SmsWorkloadRecord smsWorkloadRecord : smsWorkloadRecordList){
                    num = num + smsWorkloadRecord.getRegistrationNum();
                }
                numOfPatients.add(num);
            }

        }
        smsPatientsStatisticsResult.setDateOfSevenDays(dateOfSevenDays);
        smsPatientsStatisticsResult.setNumOfPatients(numOfPatients);
        return smsPatientsStatisticsResult;
    }
}
