package com.neu.his.dms.service.impl;


import com.neu.his.common.dto.dms.DmsDrugModelParam;
import com.neu.his.common.dto.dms.DmsDrugModelResult;
import com.neu.his.common.dto.dms.DmsNonDrugModelResult;
import com.neu.his.common.util.DateUtil;
import com.neu.his.dms.service.DmsDrugModelService;
import com.neu.his.mbg.mapper.DmsDrugModelMapper;
import com.neu.his.mbg.mapper.DmsHerbalModelItemMapper;
import com.neu.his.mbg.mapper.DmsMedicineModelItemMapper;
import com.neu.his.mbg.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DmsDrugModelServiceImpl implements DmsDrugModelService {
    @Autowired
    DmsDrugModelMapper dmsDrugModelMapper;
    @Autowired
    DmsMedicineModelItemMapper dmsMedicineModelItemMapper;
    @Autowired
    DmsHerbalModelItemMapper dmsHerbalModelItemMapper;

    @Override
    public int createModel(DmsDrugModelParam dmsDrugModelParam) {

        DmsDrugModelExample example=new DmsDrugModelExample();
        //插入模版
        DmsDrugModel dmsDrugModel=new DmsDrugModel();
        BeanUtils.copyProperties(dmsDrugModelParam,dmsDrugModel);
        dmsDrugModel.setStatus(1);//正常
        Date currentTime=new Date();
        dmsDrugModel.setCreateTime(currentTime);
        String code=codeGenerator(currentTime);
        dmsDrugModel.setCode(code);
        dmsDrugModelMapper.insert(dmsDrugModel);
        //根据code返回id
        example.clear();
        example.createCriteria().andCodeEqualTo(code);
        Long id = dmsDrugModelMapper.selectByExample(example).get(0).getId();
        //插入模版项
        if(dmsDrugModelParam.getType()==0){//草药
            for(DmsHerbalModelItem dmsHerbalModelItem:dmsDrugModelParam.getDmsHerbalModelItemList()){
                dmsHerbalModelItem.setModelId(id);
                dmsHerbalModelItem.setStatus(1);//正常
                dmsHerbalModelItemMapper.insert(dmsHerbalModelItem);
            }
        }else{//成药
            for(DmsMedicineModelItem dmsMedicineModelItem:dmsDrugModelParam.getDmsMedicineModelItemList()){
                dmsMedicineModelItem.setModelId(id);
                dmsMedicineModelItem.setStatus(1);//正常
                dmsMedicineModelItemMapper.insert(dmsMedicineModelItem);
            }
        }
        return 1;
    }

    @Override
    public int deleteModel(List<Long> ids) {
        int count = ids == null ? 0 : ids.size();//得到要删除的数量
        if(!CollectionUtils.isEmpty(ids)){
            for(Long id : ids) {
               DmsDrugModel dmsDrugModel= dmsDrugModelMapper.selectByPrimaryKey(id);
                if(null == dmsDrugModel){
                    count--;
                    continue;
                }
                Integer mdoelType=dmsDrugModelMapper.selectByPrimaryKey(id).getType();//  0草药   1成药
                dmsDrugModelMapper.deleteByPrimaryKey(id);
                if(mdoelType==0){//草药
                    DmsHerbalModelItemExample example=new DmsHerbalModelItemExample();
                    example.createCriteria().andModelIdEqualTo(id);
                    dmsHerbalModelItemMapper.deleteByExample(example);
                }else{//成药
                    DmsMedicineModelItemExample example=new DmsMedicineModelItemExample();
                    example.createCriteria().andModelIdEqualTo(id);
                    dmsMedicineModelItemMapper.deleteByExample(example);
                }
            }
        }
        return count;
    }

    @Override
    public int deleteModelItem(Long modelId, List<Long> itemIds) {
        return 0;
    }

    @Override
    public int updateModel(Long modelId, DmsDrugModelParam dmsDrugModelParam) {
       //先找出原model信息
        DmsDrugModel oldDmsNonDrugModel=dmsDrugModelMapper.selectByPrimaryKey(modelId);
        if(null==oldDmsNonDrugModel)
            return 0;

        dmsDrugModelParam.setCreateTime(oldDmsNonDrugModel.getCreateTime());
        dmsDrugModelParam.setCode(oldDmsNonDrugModel.getCode());
        List<Long> ids=new ArrayList<>();
        ids.add(modelId);
        deleteModel(ids);//删除原model和modelId
        // 插入新model
        DmsDrugModelExample example=new DmsDrugModelExample();
        //插入模版
        DmsDrugModel dmsDrugModel=new DmsDrugModel();
        BeanUtils.copyProperties(dmsDrugModelParam,dmsDrugModel);
        //不用再初始化状态和code
        dmsDrugModelMapper.insert(dmsDrugModel);
        //更新Id
        example.clear();
        example.createCriteria().andCodeEqualTo(dmsDrugModel.getCode());
        dmsDrugModel=new DmsDrugModel();
        dmsDrugModel.setId(modelId);//modelId不变
        dmsDrugModelMapper.updateByExampleSelective(dmsDrugModel,example);

        //插入模版项
        if(dmsDrugModelParam.getType()==0){//草药
            for(DmsHerbalModelItem dmsHerbalModelItem:dmsDrugModelParam.getDmsHerbalModelItemList()){
                dmsHerbalModelItem.setModelId(modelId);
                dmsHerbalModelItem.setStatus(1);//正常
                dmsHerbalModelItemMapper.insert(dmsHerbalModelItem);
            }
        }else{//成药
            for(DmsMedicineModelItem dmsMedicineModelItem:dmsDrugModelParam.getDmsMedicineModelItemList()){
                dmsMedicineModelItem.setModelId(modelId);
                dmsMedicineModelItem.setStatus(1);//正常
                dmsMedicineModelItemMapper.insert(dmsMedicineModelItem);
            }
        }











        //



        return 0;
    }


    /**
     * 描述：根据modelId更新model信息
     *       删了重新创建
     * <p>author:赵煜
     * <p>author:赵煜  排除空指针异常
     * <p>author:赵煜  排除根据type和name查询异常
     */
    @Override
    public List<DmsDrugModelResult> selectModel(Integer isAdmin, DmsDrugModelParam queryParam, Integer pageSize, Integer pageNum) {
        DmsDrugModelExample example = null;
        List<DmsDrugModel> dmsDrugModelList = null;
        if(null==isAdmin){
            return null;
        }

        if(isAdmin == 0){  //非管理员   前台 查询个人、科室、全院
            example=  new DmsDrugModelExample();
            DmsDrugModelExample.Criteria criteria = example.createCriteria();
            criteria.andStatusNotEqualTo(0);
            criteria.andScopeEqualTo(queryParam.getScope()); //必须mvc保证不为空
            criteria.andOwnIdEqualTo(queryParam.getOwnId()); //如果isAdmin为0，则必有ownId
            if(queryParam.getType()!=null){
                criteria.andTypeEqualTo(queryParam.getType());
            }
            if(!StringUtils.isEmpty(queryParam.getName())){
                criteria.andNameLike("%"+queryParam.getType()+"%");
            }

            dmsDrugModelList=dmsDrugModelMapper.selectByExample(example);
            System.err.println("非管理员查询");
        }else{//后台 查询所有--后端模糊查询
            example=  new DmsDrugModelExample();
            DmsDrugModelExample.Criteria criteria = example.createCriteria();
            if(queryParam.getType()!=null){
                criteria.andTypeEqualTo(queryParam.getType());
            }

            if(queryParam.getStatus() == null){
                criteria.andStatusNotEqualTo(0);
            }
            if(!StringUtils.isEmpty(queryParam.getCode())){
                criteria.andCodeLike("%" + queryParam.getCode() + "%");
            }
            if(!StringUtils.isEmpty(queryParam.getName())){
                criteria.andNameLike("%" + queryParam.getName() + "%");
            }
            example.setOrderByClause("id desc");
            dmsDrugModelList=dmsDrugModelMapper.selectByExample(example);
        }

        //封装result
        List<DmsDrugModelResult> dmsDrugModelResultList = new ArrayList<>();
        for (DmsDrugModel dmsDrugModel : dmsDrugModelList) {
            DmsDrugModelResult dmsDrugModelResult = new DmsDrugModelResult();
            BeanUtils.copyProperties(dmsDrugModel, dmsDrugModelResult);
            //封装模版项
            if (dmsDrugModel.getType() == 0) {//草药
                DmsHerbalModelItemExample dmsHerbalModelItemExample = new DmsHerbalModelItemExample();
                dmsHerbalModelItemExample.createCriteria().andModelIdEqualTo(dmsDrugModel.getId());
                dmsDrugModelResult.setDmsHerbalModelItemList(dmsHerbalModelItemMapper.selectByExample(dmsHerbalModelItemExample));
            } else {//成药
                DmsMedicineModelItemExample dmsMedicineModelItemExample = new DmsMedicineModelItemExample();
                dmsMedicineModelItemExample.createCriteria().andModelIdEqualTo(dmsDrugModel.getId());
                dmsDrugModelResult.setDmsMedicineModelItemList(dmsMedicineModelItemMapper.selectByExample(dmsMedicineModelItemExample));
            }

            dmsDrugModelResultList.add(dmsDrugModelResult);
        }
        return dmsDrugModelResultList;
    }

    private String codeGenerator(Date date) {
        return DateUtil.getDateStr(date) + DateUtil.getTimeStr(date, 6);
    }

}
