package com.neu.his.cloud.service.dms.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.neu.his.cloud.service.dms.dto.dms.DmsDiseParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsDiseResult;
import com.neu.his.cloud.service.dms.mapper.DmsDiseMapper;
import com.neu.his.cloud.service.dms.model.DmsDise;
import com.neu.his.cloud.service.dms.model.DmsDiseExample;
import com.neu.his.cloud.service.dms.service.DmsDiseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

@Service
public class DmsDiseServiceImpl implements DmsDiseService {
    @Autowired
    DmsDiseMapper dmsDiseMapper;

    /**
     * 描述：新增一个诊断
     * <p>author:王思阳
     * <p>author:赵煜 修复新增疾病诊断时,不能增加已删除的且name相同的记录
     */
    @Override
    public int create(DmsDiseParam dmsDiseParam) {
        DmsDiseExample example = new DmsDiseExample();
        example.createCriteria().andNameEqualTo(dmsDiseParam.getName()).andStatusNotEqualTo(0);
        List<DmsDise> dmsDiseList = dmsDiseMapper.selectByExample(example);
        if (dmsDiseList.size() > 0) {
            return 0;
        }
        DmsDise dmsDise = new DmsDise();
        BeanUtils.copyProperties(dmsDiseParam,dmsDise);
        dmsDiseMapper.insertSelective(dmsDise);
        return 1;
    }



    @Override
    public int delete(List<Long> ids) {
        int count = ids == null ? 0 : ids.size();//得到要删除的数量
        if (!CollectionUtils.isEmpty(ids)){
            for (Long id:ids) {
                DmsDise dmsDise = new DmsDise();
                dmsDise.setStatus(0);
                DmsDiseExample example = new DmsDiseExample();
                example.createCriteria().andIdEqualTo(id);
                dmsDiseMapper.updateByExampleSelective(dmsDise,example);
            }
        }
        return count;
    }

    @Override
    public int update(Long id, DmsDiseParam dmsDiseParam) {
        DmsDise dmsDise = new DmsDise();
        BeanUtils.copyProperties(dmsDiseParam,dmsDise);
        System.err.println("dmsDiseParam-->"+dmsDiseParam);
        System.err.println("dmsDise-->"+dmsDise);
        DmsDiseExample example = new DmsDiseExample();
        example.createCriteria().andIdEqualTo(id);
        return dmsDiseMapper.updateByExampleSelective(dmsDise,example);
    }

    @Override
    public List<DmsDiseResult> select(DmsDiseParam dmsDiseParam, Integer pageSize, Integer pageNum) {
        DmsDiseExample example = new DmsDiseExample();
        DmsDiseExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(dmsDiseParam.getCatId())){
            criteria.andCatIdEqualTo(dmsDiseParam.getCatId());
        }
        if(!StringUtils.isEmpty(dmsDiseParam.getCode())){
            criteria.andCodeEqualTo(dmsDiseParam.getCode());
        }
        if(!StringUtils.isEmpty(dmsDiseParam.getName())){
            criteria.andNameLike("%"+dmsDiseParam.getName()+"%");
        }
        if(!StringUtils.isEmpty(dmsDiseParam.getIcd())){
            criteria.andIcdEqualTo(dmsDiseParam.getIcd());
        }
        if(!StringUtils.isEmpty(dmsDiseParam.getStatus())){
            criteria.andStatusEqualTo(dmsDiseParam.getStatus());
        }
        criteria.andStatusNotEqualTo(0);//状态不为0
        example.setOrderByClause("id desc");//按id倒序
        List<DmsDiseResult> list = new ArrayList<>();
        for (DmsDise dmsDise:dmsDiseMapper.selectByExample(example)) {
            DmsDiseResult dmsDiseResult = new DmsDiseResult();
            BeanUtils.copyProperties(dmsDise,dmsDiseResult);
            list.add(dmsDiseResult);
        }
        return list;
    }

    @Override
    public List<DmsDiseResult> selectAll() {
        List<DmsDiseResult> list = new ArrayList<>();
        DmsDiseExample example = new DmsDiseExample();
        example.createCriteria().andStatusNotEqualTo(0);
        for (DmsDise dmsDise:dmsDiseMapper.selectByExample(example)) {
            DmsDiseResult dmsDiseResult = new DmsDiseResult();
            BeanUtils.copyProperties(dmsDise,dmsDiseResult);
            list.add(dmsDiseResult);
        }
        return list;
    }

    @Override
    public List<DmsDiseResult> parseList( String idsStr) {
        //解析ids->list<Id>
        List<Long> idList = strToList(idsStr);
       //根据list<Id>查询并封装诊断简单对象
        DmsDiseExample dmsDiseExample=new DmsDiseExample();
        dmsDiseExample.createCriteria().andIdIn(idList);
        List<DmsDise> dmsDiseList=dmsDiseMapper.selectByExample(dmsDiseExample);
        List<DmsDiseResult> dmsDiseResultList = new ArrayList<>();

        if(CollectionUtil.isEmpty(dmsDiseList)){
           return null;
        }

        //封装dto
        for(DmsDise dmsDise: dmsDiseList){
            DmsDiseResult dmsDiseResult=new DmsDiseResult();
            BeanUtils.copyProperties(dmsDise,dmsDiseResult);
            dmsDiseResultList.add(dmsDiseResult);
        }
        return dmsDiseResultList;
    }


    private List<Long> strToList(String idsStr) {
        List<Long> idList = new ArrayList<>();
        if(idsStr == null || idsStr.length() <= 0){
            return idList;
        }
        String[] idArray = idsStr.split(",");
        for(int i=0;i < idArray.length;i++){
            idList.add(new Long(idArray[i]));
        }
        return idList;
    }

}
