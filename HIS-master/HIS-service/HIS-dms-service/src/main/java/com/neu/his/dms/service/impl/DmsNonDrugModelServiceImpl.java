package com.neu.his.dms.service.impl;



import com.neu.his.common.dto.dms.DmsNonDrugModelParam;

import com.neu.his.common.dto.dms.DmsNonDrugModelResult;
import com.neu.his.common.util.DateUtil;
import com.neu.his.dms.service.DmsNonDrugModelService;
import com.neu.his.mbg.mapper.DmsNonDrugModelMapper;
import com.neu.his.mbg.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author Zain
 * @ClassName: NonDrugModelServiceImpl
 * @description: TODO
 * @date 2019/6/9 9:40
 */

@Service
public class DmsNonDrugModelServiceImpl implements DmsNonDrugModelService {


    @Autowired
    DmsNonDrugModelMapper dmsNonDrugModelMapper;



    /**
     * 描述：创建模版
     * <p>author:赵煜
     * <p>author:赵煜  code可以重名
     */
    @Override
    public int createModel(DmsNonDrugModelParam dmsNonDrugModelParam) {
        System.err.println("createModel");

        //给模版实体赋值
        DmsNonDrugModel dmsNonDrugModel = new DmsNonDrugModel();
        BeanUtils.copyProperties(dmsNonDrugModelParam, dmsNonDrugModel);
        dmsNonDrugModel.setCreateTime(new Date());
        dmsNonDrugModel.setStatus(1);
        dmsNonDrugModel.setCode(codeGenerator(new Date()));

        //设置模版项串
        if (null != dmsNonDrugModelParam.getNonDrugIdList() && dmsNonDrugModelParam.getNonDrugIdList().size() > 0) {
            dmsNonDrugModel.setNonDrugIdList(toItemIdListStr(dmsNonDrugModelParam.getNonDrugIdList()));
        }

        dmsNonDrugModelMapper.insertSelective(dmsNonDrugModel);
        return 1;
    }

    @Override
    public int deleteModel(List<Long> ids) {
        int count = ids == null ? 0 : ids.size(); //得到要删除的数量
        if (!CollectionUtils.isEmpty(ids)) {
            for (Long id : ids) {
                //直接删除
                dmsNonDrugModelMapper.deleteByPrimaryKey(id);
            }
        }
        return count;
    }

    @Override
    public int deleteModelItem(Long modelId, List<Long> itemIds) {
        int count = itemIds == null ? 0 : itemIds.size(); //得到要删除的数量
        //取出nonDrugIdList 解析并删除所需
        DmsNonDrugModel dmsNonDrugModel = dmsNonDrugModelMapper.selectByPrimaryKey(modelId);
        HashSet<Long> itemIdSet=toItemIdSet(dmsNonDrugModel.getNonDrugIdList());
        if (null != dmsNonDrugModel && !CollectionUtils.isEmpty(itemIdSet) && !CollectionUtils.isEmpty(itemIds)) {
            for (Long id : itemIds) {
                if( itemIdSet.contains(id)) {
                    itemIdSet.remove(id);
                }
                }
        }
        dmsNonDrugModel=new DmsNonDrugModel();
        dmsNonDrugModel.setId(modelId);
        dmsNonDrugModel.setNonDrugIdList(toItemIdListStr(new ArrayList<Long>(itemIdSet)));

        dmsNonDrugModelMapper.updateByPrimaryKeySelective(dmsNonDrugModel);
        return count;
    }


    /**
     * 描述：根据modelId更新model信息
     *       删了重新创建
     * <p>author:赵煜
     * <p>author:赵煜  修改不能更新的bug  直接更新，不考虑code重复
     */
    @Override
    public int updateModel(Long modelId, DmsNonDrugModelParam dmsNonDrugModelParam) {
        //先找出原model信息
        DmsNonDrugModel oldDmsNonDrugModel=dmsNonDrugModelMapper.selectByPrimaryKey(modelId);

        //给实体赋值
        DmsNonDrugModel newDmsNonDrugModel = new DmsNonDrugModel();
        newDmsNonDrugModel.setId(modelId);
        //实际能更新的属性
        newDmsNonDrugModel.setNonDrugIdList(toItemIdListStr(dmsNonDrugModelParam.getNonDrugIdList()));;
        newDmsNonDrugModel.setCode(dmsNonDrugModelParam.getCode());//code可以重复
        newDmsNonDrugModel.setAim(dmsNonDrugModelParam.getAim());
        newDmsNonDrugModel.setName(dmsNonDrugModelParam.getName());//name可以重复

        //封装不更新的几个属性
        newDmsNonDrugModel.setId(oldDmsNonDrugModel.getId());
        newDmsNonDrugModel.setOwnId(oldDmsNonDrugModel.getOwnId());
        newDmsNonDrugModel.setScope(oldDmsNonDrugModel.getScope());
        newDmsNonDrugModel.setStatus(oldDmsNonDrugModel.getStatus());
        newDmsNonDrugModel.setCreateTime(oldDmsNonDrugModel.getCreateTime());
        newDmsNonDrugModel.setType(oldDmsNonDrugModel.getType());

        dmsNonDrugModelMapper.updateByPrimaryKey(newDmsNonDrugModel);
        return 1;
    }



    @Override
    public List<DmsNonDrugModelResult> selectModel(Integer isAdmin,DmsNonDrugModelParam queryParam, Integer pageSize, Integer pageNum) {

        DmsNonDrugModelExample example = null;
        List<DmsNonDrugModel> dmsNonDrugModelList = null;

        if(isAdmin == 0){  //非管理员   前台 查询个人、科室、全院
            example=  new DmsNonDrugModelExample();
            DmsNonDrugModelExample.Criteria criteria = example.createCriteria();
            criteria.andStatusNotEqualTo(0);
            criteria.andScopeEqualTo(queryParam.getScope()); //必须mvc保证不为空
            criteria.andOwnIdEqualTo(queryParam.getOwnId()); //必须宝成OwnId不为空
            if(!StringUtils.isEmpty(queryParam.getName())){
                criteria.andNameLike("%" + queryParam.getName() + "%");
            }
            if(null!=queryParam.getType()){
                criteria.andTypeEqualTo(queryParam.getType());
            }
            dmsNonDrugModelList=dmsNonDrugModelMapper.selectByExample(example);
        }else{//后台 查询所有--后端模糊查询
            //如果没有指明status，返回不为0的
            example=  new DmsNonDrugModelExample();
            DmsNonDrugModelExample.Criteria criteria = example.createCriteria();
            if(null!=queryParam.getType()){
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
            dmsNonDrugModelList=dmsNonDrugModelMapper.selectByExample(example);
        }


        //返回数据包装成Result
        //List<DmsNonDrugModel> dmsNonDrugModelList = dmsNonDrugModelMapper.selectByExample(example);
        List<DmsNonDrugModelResult> dmsNonDrugModelResultList = new ArrayList<>();

        for (DmsNonDrugModel dmsNonDrugModel : dmsNonDrugModelList) {
            DmsNonDrugModelResult dmsNonDrugModelResult = new DmsNonDrugModelResult();
            BeanUtils.copyProperties(dmsNonDrugModel, dmsNonDrugModelResult,"nonDrugIdList");
            if(!StringUtils.isEmpty(dmsNonDrugModel.getNonDrugIdList())) {//若model中list不为空串则取出封装
                dmsNonDrugModelResult.setNonDrugIdList(new ArrayList<Long>(toItemIdSet(dmsNonDrugModel.getNonDrugIdList())));
            }
            dmsNonDrugModelResultList.add(dmsNonDrugModelResult);
        }
        return dmsNonDrugModelResultList;
    }



    private String toItemIdListStr(List<Long> nonDrugIdList) {
        String nonDrugIdListStr = "";
        for (Long itemId : nonDrugIdList) {
            nonDrugIdListStr += (itemId+"");
            nonDrugIdListStr += ",";
        }
        return nonDrugIdListStr.substring(0, nonDrugIdListStr.length() - 1);
    }


    private HashSet<Long>  toItemIdSet(String  nonDrugIdListStr) {
        String[] idArray=nonDrugIdListStr.split(",");
        HashSet<Long> idSet=new HashSet<Long>();

        for(int i =0 ;i<idArray.length;i++){
            idSet.add(new Long(idArray[i]));
        }
        return idSet;

    }

    private String codeGenerator(Date date) {
        return DateUtil.getDateStr(date) + DateUtil.getTimeStr(date, 6);
    }

}
