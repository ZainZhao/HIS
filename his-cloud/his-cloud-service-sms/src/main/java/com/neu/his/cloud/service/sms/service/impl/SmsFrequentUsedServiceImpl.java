package com.neu.his.cloud.service.sms.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.neu.his.cloud.service.sms.dto.dms.DmsDrugResult;
import com.neu.his.cloud.service.sms.dto.dms.DmsNonDrugResult;
import com.neu.his.cloud.service.sms.dto.sms.SmsFrequentUsedResult;
import com.neu.his.cloud.service.sms.mapper.*;
import com.neu.his.cloud.service.sms.model.*;
import com.neu.his.cloud.service.sms.service.SmsFrequentUsedService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 常用项
 */
@Service
public class SmsFrequentUsedServiceImpl implements SmsFrequentUsedService {

    @Autowired
    private SmsFrequentUsedMapper smsFrequentUsedMapper;
    @Autowired
    private DmsNonDrugMapper dmsNonDrugMapper;
    @Autowired
    private DmsDiseMapper dmsDiseMapper;
    @Autowired
    private DmsDrugMapper dmsDrugMapper;
    @Autowired
    private SmsDeptMapper smsDeptMapper;
    @Autowired
    private DmsDosageMapper dmsDosageMapper;


    @Override
    public int addFrequent(Long staffId,int addType,Long addId){
        SmsFrequentUsedExample example = new SmsFrequentUsedExample();
        example.createCriteria().andStaffIdEqualTo(staffId);
        List<SmsFrequentUsed> frequentUsedList = smsFrequentUsedMapper.selectByExample(example);
        SmsFrequentUsed frequentUsed;
        if(frequentUsedList.size() <= 0){
            //第一次创建
            frequentUsed = new SmsFrequentUsed();
            frequentUsed.setStaffId(staffId);
            if(smsFrequentUsedMapper.insert(frequentUsed) <= 0){
                return 0;
            }
        }else{
            frequentUsed = frequentUsedList.get(0);
        }
        boolean addBoolean = false;
        switch(addType){
            case 1:
                String checkIdStr = frequentUsed.getCheckIdList();
                Set<Long> checkSet = strToSet(checkIdStr);
                addBoolean = checkSet.add(addId);
                frequentUsed.setCheckIdList(setToStr(checkSet));
                break;
            case 2:
                String medicineDiseIdStr = frequentUsed.getMedicineDiseIdList();
                Set<Long> medicineDiseIdSet = strToSet(medicineDiseIdStr);
                addBoolean = medicineDiseIdSet.add(addId);
                frequentUsed.setMedicineDiseIdList(setToStr(medicineDiseIdSet));
                break;
            case 3:
                String dispositionIdStr = frequentUsed.getDispositionIdList();
                Set<Long> dispositionIdSet = strToSet(dispositionIdStr);
                addBoolean = dispositionIdSet.add(addId);
                frequentUsed.setDispositionIdList(setToStr(dispositionIdSet));
                break;
            case 4:
                String testIdStr = frequentUsed.getTestIdList();
                Set<Long> testIdSet = strToSet(testIdStr);
                addBoolean = testIdSet.add(addId);
                frequentUsed.setTestIdList(setToStr(testIdSet));
                break;
            case 5:
                String herbalDiseIdStr = frequentUsed.getHerbalDiseIdList();
                Set<Long> herbalDiseIdSet = strToSet(herbalDiseIdStr);
                addBoolean = herbalDiseIdSet.add(addId);
                frequentUsed.setHerbalDiseIdList(setToStr(herbalDiseIdSet));
                break;
            case 6:
                String drugIdStr = frequentUsed.getDrugIdList();
                Set<Long> drugIdSet = strToSet(drugIdStr);
                addBoolean = drugIdSet.add(addId);
                frequentUsed.setDrugIdList(setToStr(drugIdSet));
                break;
            case 7:
                String checkModelIdStr = frequentUsed.getCheckModelIdList();
                Set<Long> checkModelIdSet = strToSet(checkModelIdStr);
                addBoolean = checkModelIdSet.add(addId);
                frequentUsed.setCheckModelIdList(setToStr(checkModelIdSet));
                break;
            case 8:
                String dispositionModelIdStr = frequentUsed.getDispositionModelIdList();
                Set<Long> dispositionModelIdSet = strToSet(dispositionModelIdStr);
                addBoolean = dispositionModelIdSet.add(addId);
                frequentUsed.setDispositionModelIdList(setToStr(dispositionModelIdSet));
                break;
            case 9:
                String testModelIdStr = frequentUsed.getTestModelIdList();
                Set<Long> testModelIdSet = strToSet(testModelIdStr);
                addBoolean = testModelIdSet.add(addId);
                frequentUsed.setTestModelIdList(setToStr(testModelIdSet));
                break;
            case 0:
                String drugModelIdStr = frequentUsed.getDrugModelIdList();
                Set<Long> drugModelIdSet = strToSet(drugModelIdStr);
                addBoolean = drugModelIdSet.add(addId);
                frequentUsed.setDrugModelIdList(setToStr(drugModelIdSet));
                break;
            default:
                return 0;
        }
        if(addBoolean){
            return smsFrequentUsedMapper.updateByPrimaryKeySelective(frequentUsed);
        }else{
            return 0;
        }
    }

    @Override
    public int deleteFrequent(Long staffId,int deleteType,Long deleteId){
        SmsFrequentUsedExample example = new SmsFrequentUsedExample();
        example.createCriteria().andStaffIdEqualTo(staffId);
        List<SmsFrequentUsed> frequentUsedList = smsFrequentUsedMapper.selectByExample(example);
        SmsFrequentUsed frequentUsed;
        if(frequentUsedList.size() <= 0){
            return 0;
        }
        frequentUsed = frequentUsedList.get(0);
        boolean deleteBoolean = false;
        switch(deleteType){
            case 1:
                String checkIdStr = frequentUsed.getCheckIdList();
                Set<Long> checkSet = strToSet(checkIdStr);
                deleteBoolean = checkSet.remove(deleteId);
                frequentUsed.setCheckIdList(setToStr(checkSet));
                break;
            case 2:
                String medicineDiseIdStr = frequentUsed.getMedicineDiseIdList();
                Set<Long> medicineDiseIdSet = strToSet(medicineDiseIdStr);
                deleteBoolean = medicineDiseIdSet.remove(deleteId);
                frequentUsed.setMedicineDiseIdList(setToStr(medicineDiseIdSet));
                break;
            case 3:
                String dispositionIdStr = frequentUsed.getDispositionIdList();
                Set<Long> dispositionIdSet = strToSet(dispositionIdStr);
                deleteBoolean = dispositionIdSet.remove(deleteId);
                frequentUsed.setDispositionIdList(setToStr(dispositionIdSet));
                break;
            case 4:
                String testIdStr = frequentUsed.getTestIdList();
                Set<Long> testIdSet = strToSet(testIdStr);
                deleteBoolean = testIdSet.remove(deleteId);
                frequentUsed.setTestIdList(setToStr(testIdSet));
                break;
            case 5:
                String herbalDiseIdStr = frequentUsed.getHerbalDiseIdList();
                Set<Long> herbalDiseIdSet = strToSet(herbalDiseIdStr);
                deleteBoolean = herbalDiseIdSet.remove(deleteId);
                frequentUsed.setHerbalDiseIdList(setToStr(herbalDiseIdSet));
                break;
            case 6:
                String drugIdStr = frequentUsed.getDrugIdList();
                Set<Long> drugIdSet = strToSet(drugIdStr);
                deleteBoolean = drugIdSet.remove(deleteId);
                frequentUsed.setDrugIdList(setToStr(drugIdSet));
                break;
            case 7:
                String checkModelIdStr = frequentUsed.getCheckModelIdList();
                Set<Long> checkModelIdSet = strToSet(checkModelIdStr);
                deleteBoolean = checkModelIdSet.remove(deleteId);
                frequentUsed.setCheckModelIdList(setToStr(checkModelIdSet));
                break;
            case 8:
                String dispositionModelIdStr = frequentUsed.getDispositionModelIdList();
                Set<Long> dispositionModelIdSet = strToSet(dispositionModelIdStr);
                deleteBoolean = dispositionModelIdSet.remove(deleteId);
                frequentUsed.setDispositionModelIdList(setToStr(dispositionModelIdSet));
                break;
            case 9:
                String testModelIdStr = frequentUsed.getTestModelIdList();
                Set<Long> testModelIdSet = strToSet(testModelIdStr);
                deleteBoolean = testModelIdSet.remove(deleteId);
                frequentUsed.setTestModelIdList(setToStr(testModelIdSet));
                break;
            case 0:
                String drugModelIdStr = frequentUsed.getDrugModelIdList();
                Set<Long> drugModelIdSet = strToSet(drugModelIdStr);
                deleteBoolean = drugModelIdSet.remove(deleteId);
                frequentUsed.setDrugModelIdList(setToStr(drugModelIdSet));
                break;
            default:
                return 0;
        }
        if(deleteBoolean){
            return smsFrequentUsedMapper.updateByPrimaryKeySelective(frequentUsed);
        }else{
            return 0;
        }
    }

    @Override
    public SmsFrequentUsedResult selectFrequent(Long staffId, int selectType){
        SmsFrequentUsedExample example = new SmsFrequentUsedExample();
        example.createCriteria().andStaffIdEqualTo(staffId);
        List<SmsFrequentUsed> frequentUsedList = smsFrequentUsedMapper.selectByExample(example);
        SmsFrequentUsed frequentUsed;
        if(frequentUsedList.size() <= 0){
            return null;
        }
        frequentUsed = frequentUsedList.get(0);

        SmsFrequentUsedResult result = new SmsFrequentUsedResult();
        result.setId(frequentUsed.getId());
        result.setStaffId(frequentUsed.getStaffId());
        System.err.println("selectType:"+selectType);
        switch(selectType){
            case 1: //检查
                List<Long> checkIdList = strToList(frequentUsed.getCheckIdList());
                if(!checkIdList.isEmpty()){
                    DmsNonDrugExample checkNonDrugExample=new DmsNonDrugExample();
                    checkNonDrugExample.createCriteria().andIdIn(checkIdList);
                    List<DmsNonDrug> checkList=dmsNonDrugMapper.selectByExample(checkNonDrugExample);
                    List<DmsNonDrugResult> checkResultList=new ArrayList<>();

                    //封装deptName属性
                    if(!CollectionUtil.isEmpty(checkList)){
                        for(DmsNonDrug dmsNonDrug: checkList){
                            DmsNonDrugResult dmsNonDrugResult=new DmsNonDrugResult();
                            BeanUtils.copyProperties(dmsNonDrug,dmsNonDrugResult);
                            SmsDept smsDept=smsDeptMapper.selectByPrimaryKey(dmsNonDrug.getDeptId());
                            dmsNonDrugResult.setDeptName(smsDept==null?null:smsDept.getName());
                            checkResultList.add(dmsNonDrugResult);
                        }
                    }
                    result.setCheckList(checkResultList);
                }
                break;

            case 2: //西医诊断
                List<Long> medicineDiseIdList = strToList(frequentUsed.getMedicineDiseIdList());
                if(!medicineDiseIdList.isEmpty()){
                    DmsDiseExample medicineDiseExample=new DmsDiseExample();
                    medicineDiseExample.createCriteria().andIdIn(medicineDiseIdList);
                    result.setMedicineDiseList(dmsDiseMapper.selectByExample(medicineDiseExample));
                }
                break;

            case 3://处置
                List<Long> dispositionIdList = strToList(frequentUsed.getDispositionIdList());
                if(!dispositionIdList.isEmpty()){
                    DmsNonDrugExample dispositionNonDrugExample=new DmsNonDrugExample();
                    dispositionNonDrugExample.createCriteria().andIdIn(dispositionIdList);
                    List<DmsNonDrug> dispositionList=dmsNonDrugMapper.selectByExample(dispositionNonDrugExample);
                    List<DmsNonDrugResult> dispositionResultList=new ArrayList<>();

                    //封装deptName属性
                    if(!CollectionUtil.isEmpty(dispositionList)){
                        for(DmsNonDrug dmsNonDrug: dispositionList){
                            DmsNonDrugResult dmsNonDrugResult=new DmsNonDrugResult();
                            BeanUtils.copyProperties(dmsNonDrug,dmsNonDrugResult);
                            SmsDept smsDept=smsDeptMapper.selectByPrimaryKey(dmsNonDrug.getDeptId());
                            dmsNonDrugResult.setDeptName(smsDept==null?null:smsDept.getName());
                            dispositionResultList.add(dmsNonDrugResult);
                        }
                    }

                    result.setDispositionList(dispositionResultList);
                }
                break;

            case 4://检验
                List<Long> testIdList = strToList(frequentUsed.getTestIdList());
                if(!testIdList.isEmpty()){
                    DmsNonDrugExample testIdListNonDrugExample=new DmsNonDrugExample();
                    testIdListNonDrugExample.createCriteria().andIdIn(testIdList);

                    List<DmsNonDrug> testList=dmsNonDrugMapper.selectByExample(testIdListNonDrugExample);
                    List<DmsNonDrugResult> testResultList=new ArrayList<>();

                    //封装deptName属性
                    if(!CollectionUtil.isEmpty(testList)){
                        for(DmsNonDrug dmsNonDrug: testList){
                            DmsNonDrugResult dmsNonDrugResult=new DmsNonDrugResult();
                            BeanUtils.copyProperties(dmsNonDrug,dmsNonDrugResult);
                            SmsDept smsDept=smsDeptMapper.selectByPrimaryKey(dmsNonDrug.getDeptId());
                            dmsNonDrugResult.setDeptName(smsDept==null?null:smsDept.getName());
                            testResultList.add(dmsNonDrugResult);
                        }
                    }
                    result.setTestList(testResultList);
                }
                break;

            case 5://中医诊断
                List<Long> herbalDiseIdStr = strToList(frequentUsed.getHerbalDiseIdList());
                if(!herbalDiseIdStr.isEmpty()){
                    DmsDiseExample herbalDiseExample=new DmsDiseExample();
                    herbalDiseExample.createCriteria().andIdIn(herbalDiseIdStr);
                    result.setHerbalDiseList(dmsDiseMapper.selectByExample(herbalDiseExample));
                }
                break;

            case 6: //药
                List<Long> drugIdStr = strToList(frequentUsed.getDrugIdList());
                if(!drugIdStr.isEmpty()){
                    DmsDrugExample drugExample=new DmsDrugExample();
                    drugExample.createCriteria().andIdIn(drugIdStr);
                    List<DmsDrug> dmsDrugList = dmsDrugMapper.selectByExample(drugExample);
                    List<DmsDrugResult> smsDrugResultList = new ArrayList<>();
                    for (DmsDrug dmsDrug : dmsDrugList) {
                        DmsDrugResult dmsDrugResult = new DmsDrugResult();
                        BeanUtils.copyProperties(dmsDrug, dmsDrugResult);
                        DmsDosage dmsDosage=dmsDosageMapper.selectByPrimaryKey(dmsDrug.getDosageId());
                        dmsDrugResult.setDosage(dmsDosage);
                        smsDrugResultList.add(dmsDrugResult);
                    }
                    result.setDrugList(smsDrugResultList);
                }
                break;

            case 7: //检查模板id
                String checkModelIdStr = frequentUsed.getCheckModelIdList();
                result.setCheckModelIdList(strToList(checkModelIdStr));
                break;

            case 8://处置模板id
                String dispositionModelIdStr = frequentUsed.getDispositionModelIdList();
                result.setDispositionModelIdList(strToList(dispositionModelIdStr));
                break;

            case 9://检验模板id
                String testModelIdStr = frequentUsed.getTestModelIdList();
                result.setTestModelIdList(strToList(testModelIdStr));
                break;

            case 0://药品模板id
                String drugModelIdStr = frequentUsed.getDrugModelIdList();
                result.setDrugModelIdList(strToList(drugModelIdStr));
                break;

            default:
                return null;
        }
        return result;
    }




    private List<Long> strToList(String itemListStr) {
        List<Long> idList = new ArrayList<>();
        if(itemListStr == null || itemListStr.length() <= 0){
            return idList;
        }
        String[] idArray = itemListStr.split(",");
        for(int i=0;i < idArray.length;i++){
            idList.add(new Long(idArray[i]));
        }
        return idList;
    }

    private String setToStr(Set<Long> itemSet) {
        String itemListStr = "";
        if(itemSet == null || itemSet.isEmpty()){
            return itemListStr;
        }
        for (Long itemId : itemSet) {
            itemListStr += (itemId + "");
            itemListStr += ",";
        }
        return itemListStr.substring(0, itemListStr.length() - 1);
    }

    private HashSet<Long> strToSet(String itemListStr) {
        HashSet<Long> idSet = new HashSet<>();
        if(itemListStr == null || itemListStr.length() <= 0){
            return idSet;
        }
        String[] idArray = itemListStr.split(",");
        for(int i=0;i < idArray.length;i++){
            idSet.add(new Long(idArray[i]));
        }
        return idSet;
    }

}
