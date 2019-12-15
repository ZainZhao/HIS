package com.neu.his.dms.service.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.neu.his.common.dto.dms.DmsCaseModelCatalogNode;
import com.neu.his.common.dto.dms.DmsCaseModelListResult;
import com.neu.his.common.dto.dms.DmsCaseModelOrCatalogParam;

import com.neu.his.common.dto.dms.DmsCaseModelResult;
import com.neu.his.dms.service.DmsCaseModelService;
import com.neu.his.mbg.mapper.DmsCaseModelCatalogMapper;
import com.neu.his.mbg.mapper.DmsCaseModelMapper;
import com.neu.his.mbg.mapper.SmsStaffMapper;
import com.neu.his.mbg.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DmsCaseModelServiceImpl implements DmsCaseModelService {
    @Autowired
    DmsCaseModelMapper dmsCaseModelMapper;

    @Autowired
    DmsCaseModelCatalogMapper dmsCaseModelCatalogMapper;

    @Autowired
    SmsStaffMapper smsStaffMapper;

    @Override
    public List<DmsCaseModelCatalogNode> listModelCatTree(Long ownId,Integer scope) {

        DmsCaseModelCatalogExample dmsCaseModelCatalogExample=new DmsCaseModelCatalogExample();
        dmsCaseModelCatalogExample.createCriteria().andOwnIdEqualTo(ownId).andScopeEqualTo(scope);
        List<DmsCaseModelCatalog> dmsCaseModelCatalogList = dmsCaseModelCatalogMapper.selectByExample(dmsCaseModelCatalogExample);

        List<DmsCaseModelCatalogNode> result = dmsCaseModelCatalogList.stream()
                .filter(catalog -> catalog.getParentId().equals(0L))//筛选出pid为0的目录
                .map(catalog -> covert(catalog,dmsCaseModelCatalogList)).collect(Collectors.toList());
        return result;
    }


    @Override
    public int createCatOrModel(DmsCaseModelOrCatalogParam dmsCaseModelOrCatalogParam) {
        if(dmsCaseModelOrCatalogParam.getType()==null){
            return 0;
        }else if(dmsCaseModelOrCatalogParam.getType()==1){//目录

            DmsCaseModelCatalog dmsCaseModelCatalog=new DmsCaseModelCatalog();
            BeanUtils.copyProperties(dmsCaseModelOrCatalogParam,dmsCaseModelCatalog);
            dmsCaseModelCatalog.setCreateTime(new Date());
            //获取父目录的level+1
            if(dmsCaseModelOrCatalogParam.getParentId()==null||dmsCaseModelCatalogMapper.selectByPrimaryKey(dmsCaseModelOrCatalogParam.getParentId())==null){
                dmsCaseModelCatalog.setLevel(1);// 找不到父目录设置为level1
                dmsCaseModelCatalog.setParentId(0L);
            }else{
                dmsCaseModelCatalog.setLevel(dmsCaseModelCatalogMapper.selectByPrimaryKey(dmsCaseModelOrCatalogParam.getParentId()).getLevel()+1);//+1
                dmsCaseModelCatalog.setParentId(dmsCaseModelOrCatalogParam.getParentId());
            }
            dmsCaseModelCatalog.setStatus(1);
            dmsCaseModelCatalog.setCreateTime(new Date());
            dmsCaseModelCatalogMapper.insert(dmsCaseModelCatalog);


        }else if(dmsCaseModelOrCatalogParam.getType()==2){//模板
            //先插入模板详细信息
            DmsCaseModel dmsCaseModel=new DmsCaseModel();
            BeanUtils.copyProperties(dmsCaseModelOrCatalogParam,dmsCaseModel);
            dmsCaseModel.setStatus(1);

            dmsCaseModelMapper.insert(dmsCaseModel);//插入后自动注入了模板id
            //插入记录
            DmsCaseModelCatalog dmsCaseModelCatalog=new DmsCaseModelCatalog();
            BeanUtils.copyProperties(dmsCaseModelOrCatalogParam,dmsCaseModelCatalog);
            dmsCaseModelCatalog.setCreateTime(new Date());
            //获取父目录的level+1
            if(dmsCaseModelOrCatalogParam.getParentId()==null||dmsCaseModelCatalogMapper.selectByPrimaryKey(dmsCaseModelOrCatalogParam.getParentId())==null){
                dmsCaseModelCatalog.setLevel(1);// 找不到父目录设置为level1
                dmsCaseModelCatalog.setParentId(0L);
            }else{
                dmsCaseModelCatalog.setLevel(dmsCaseModelCatalogMapper.selectByPrimaryKey(dmsCaseModelOrCatalogParam.getParentId()).getLevel()+1);//+1
                dmsCaseModelCatalog.setParentId(dmsCaseModelOrCatalogParam.getParentId());
            }
            dmsCaseModelCatalog.setStatus(1);
            dmsCaseModelCatalog.setCreateTime(new Date());
            dmsCaseModelCatalog.setModelId(dmsCaseModel.getId());
            dmsCaseModelCatalogMapper.insert(dmsCaseModelCatalog);

        }else{ //不为0或1
            return 0;
        }

        return 1;
    }

    @Override
    public int deleteModelOrCat(Long id) {
        DmsCaseModelCatalog dmsCaseModelCatalog= dmsCaseModelCatalogMapper.selectByPrimaryKey(id);
        if(null!=dmsCaseModelCatalog) {
            Long modelId=dmsCaseModelCatalog.getModelId();
            dmsCaseModelCatalogMapper.deleteByPrimaryKey(id);
            dmsCaseModelMapper.deleteByPrimaryKey(modelId);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateModel(Long modelId, DmsCaseModel newDmsCaseModel) {

        //仅更新目录
       DmsCaseModel oldModel = dmsCaseModelMapper.selectByPrimaryKey(modelId);
       if(null==oldModel){
           return 0;
       }
        newDmsCaseModel.setStatus(oldModel.getStatus());
        newDmsCaseModel.setId(oldModel.getId());
        newDmsCaseModel.setName(oldModel.getName()); // 名字统一在更新名字的接口上改，因为模板名也会存在目录中
        dmsCaseModelMapper.updateByPrimaryKey(newDmsCaseModel);
        return 1;
    }

    @Override
    public int updateName(Long id, String name) { // 2 模板 1 目录
        DmsCaseModelCatalog dmsCaseModelCatalog = dmsCaseModelCatalogMapper.selectByPrimaryKey(id);
        int count =0;
        if(dmsCaseModelCatalog.getType()==1){
            DmsCaseModelCatalog dmsCaseModelCatalogName=new DmsCaseModelCatalog();
            dmsCaseModelCatalogName.setId(id);
            dmsCaseModelCatalogName.setName(name);
            count = dmsCaseModelCatalogMapper.updateByPrimaryKeySelective(dmsCaseModelCatalogName);
        }else if(dmsCaseModelCatalog.getType()==2){DmsCaseModelCatalog dmsCaseModelCatalogName=new DmsCaseModelCatalog();
            dmsCaseModelCatalogName.setId(id);
            dmsCaseModelCatalogName.setName(name);
            dmsCaseModelCatalogMapper.updateByPrimaryKeySelective(dmsCaseModelCatalogName);
            //如果是模板还需要更新模板表中的模板名（两个字段是同步的）
            DmsCaseModel dmsCaseModeName =new DmsCaseModel();
            dmsCaseModeName.setName(name);
            dmsCaseModeName.setId(dmsCaseModelCatalog.getModelId());
            count= dmsCaseModelMapper.updateByPrimaryKeySelective(dmsCaseModeName);
        }

        return count;

    }

    @Override
    public DmsCaseModel getModelDetail(Long id) {
        return dmsCaseModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public DmsCaseModelListResult getAllStaffModel(Long staffId){
        DmsCaseModelListResult caseModelListResult = new DmsCaseModelListResult();
        List<DmsCaseModelResult> modelList = new ArrayList<>();
        caseModelListResult.setStaffList(modelList);
        caseModelListResult.setDeptList(modelList);
        caseModelListResult.setHospitalList(modelList);
        if(staffId == null){
            return caseModelListResult;
        }
        SmsStaff staff = smsStaffMapper.selectByPrimaryKey(staffId);
        if(staff == null){
            return caseModelListResult;
        }

        //先查个人
        DmsCaseModelCatalogExample catalogExample = new DmsCaseModelCatalogExample();
        catalogExample.createCriteria().andOwnIdEqualTo(staffId)
                .andTypeEqualTo(2)
                .andStatusEqualTo(1)
                .andScopeEqualTo(0);
        List<DmsCaseModelCatalog> staffCatalogList = dmsCaseModelCatalogMapper.selectByExample(catalogExample);
        List<Long> staffCaseIdList = new ArrayList<>();
        for(DmsCaseModelCatalog catalog : staffCatalogList){
            staffCaseIdList.add(catalog.getModelId());
        }
        List<DmsCaseModelResult> staffList = new ArrayList<>();
        if(!staffCaseIdList.isEmpty()){
            DmsCaseModelExample modelExample = new DmsCaseModelExample();
            modelExample.createCriteria().andIdIn(staffCaseIdList);
            List<DmsCaseModel> staffCaseModelList = dmsCaseModelMapper.selectByExample(modelExample);
            //封装list
            for(DmsCaseModel model : staffCaseModelList){
                DmsCaseModelResult result = new DmsCaseModelResult();
                BeanUtils.copyProperties(model,result);
                result.setPriliminaryDiseIdList(strToList(model.getPriliminaryDiseIdList()));
                result.setPriliminaryDiseStrList(strToStrList(model.getPriliminaryDiseStrList()));
                staffList.add(result);
            }
        }
        caseModelListResult.setStaffList(staffList);

        //再查科室
        catalogExample.clear();
        catalogExample.createCriteria().andOwnIdEqualTo(staff.getDeptId())
                .andTypeEqualTo(2)
                .andStatusEqualTo(1)
                .andScopeEqualTo(1);
        List<DmsCaseModelCatalog> deptCatalogList = dmsCaseModelCatalogMapper.selectByExample(catalogExample);
        List<Long> deptCaseIdList = new ArrayList<>();
        for(DmsCaseModelCatalog catalog : deptCatalogList){
            deptCaseIdList.add(catalog.getModelId());
        }
        List<DmsCaseModelResult> deptList = new ArrayList<>();
        if(!deptCaseIdList.isEmpty()){
            DmsCaseModelExample modelExample = new DmsCaseModelExample();
            modelExample.createCriteria().andIdIn(deptCaseIdList);
            List<DmsCaseModel> deptCaseModelList = dmsCaseModelMapper.selectByExample(modelExample);
            //封装list
            for(DmsCaseModel model : deptCaseModelList){
                DmsCaseModelResult result = new DmsCaseModelResult();
                BeanUtils.copyProperties(model,result);
                result.setPriliminaryDiseIdList(strToList(model.getPriliminaryDiseIdList()));
                result.setPriliminaryDiseStrList(strToStrList(model.getPriliminaryDiseStrList()));
                deptList.add(result);
            }
        }
        caseModelListResult.setDeptList(deptList);
        //再查全院
        catalogExample.clear();
        catalogExample.createCriteria().andTypeEqualTo(2)
                .andStatusEqualTo(1)
                .andScopeEqualTo(2);
        List<DmsCaseModelCatalog> hospitalCatalogList = dmsCaseModelCatalogMapper.selectByExample(catalogExample);
        List<Long> hospitalCaseIdList = new ArrayList<>();
        for(DmsCaseModelCatalog catalog : hospitalCatalogList){
            hospitalCaseIdList.add(catalog.getModelId());
        }
        List<DmsCaseModelResult> hospitalList = new ArrayList<>();
        if(!hospitalCaseIdList.isEmpty()){
            DmsCaseModelExample modelExample = new DmsCaseModelExample();
            modelExample.createCriteria().andIdIn(hospitalCaseIdList);
            List<DmsCaseModel> hospitalCaseModelList = dmsCaseModelMapper.selectByExample(modelExample);
            //封装list
            for(DmsCaseModel model : hospitalCaseModelList){
                DmsCaseModelResult result = new DmsCaseModelResult();
                BeanUtils.copyProperties(model,result);
                result.setPriliminaryDiseIdList(strToList(model.getPriliminaryDiseIdList()));
                result.setPriliminaryDiseStrList(strToStrList(model.getPriliminaryDiseStrList()));
                hospitalList.add(result);
            }
        }
        caseModelListResult.setHospitalList(hospitalList);

        return caseModelListResult;
    }


    /**
     * 将权限转换为带有子级的目录对象
     * 当找不到子级目录的时候map操作不会再递归调用covert
     */
    private DmsCaseModelCatalogNode covert(DmsCaseModelCatalog dmsCaseModelCatalog, List<DmsCaseModelCatalog> dmsCaseModelCatalogList){
        DmsCaseModelCatalogNode node = new DmsCaseModelCatalogNode();
        BeanUtils.copyProperties(dmsCaseModelCatalog,node);
        List<DmsCaseModelCatalogNode> children = dmsCaseModelCatalogList.stream()
                .filter(subCatalog -> subCatalog.getParentId().equals(dmsCaseModelCatalog.getId()))
                .map(subCatalog -> covert(subCatalog,dmsCaseModelCatalogList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
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

    private List<String> strToStrList(String itemListStr) {
        List<String> idList = new ArrayList<>();
        if(itemListStr == null || itemListStr.length() <= 0){
            return idList;
        }
        String[] idArray = itemListStr.split(",");
        for(int i=0;i < idArray.length;i++){
            idList.add(idArray[i]);
        }
        return idList;
    }

}
