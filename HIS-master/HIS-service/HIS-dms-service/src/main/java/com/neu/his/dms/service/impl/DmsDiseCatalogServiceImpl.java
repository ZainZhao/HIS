package com.neu.his.dms.service.impl;


import com.github.pagehelper.PageHelper;
import com.neu.his.common.dto.dms.DmsDiseCatalogParam;
import com.neu.his.common.dto.dms.DmsDiseCatalogResult;
import com.neu.his.dms.service.DmsDiseCatalogService;
import com.neu.his.mbg.mapper.DmsDiseCatalogMapper;
import com.neu.his.mbg.mapper.DmsDiseMapper;
import com.neu.his.mbg.model.DmsDise;
import com.neu.his.mbg.model.DmsDiseCatalog;
import com.neu.his.mbg.model.DmsDiseCatalogExample;
import com.neu.his.mbg.model.DmsDiseExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
@Service
public class DmsDiseCatalogServiceImpl implements DmsDiseCatalogService {
    @Autowired
    DmsDiseCatalogMapper dmsDiseCatalogMapper;

    @Autowired
    DmsDiseMapper dmsDiseMapper;

    @Override
    public int create(DmsDiseCatalogParam dmsDiseCatalogParam) {
        DmsDiseCatalogExample example = new DmsDiseCatalogExample();
        example.createCriteria().andNameEqualTo(dmsDiseCatalogParam.getName());//根据name查询插入的是否已存在
        List<DmsDiseCatalog> dmsDiseCatalogList = dmsDiseCatalogMapper.selectByExample(example);
        if(dmsDiseCatalogList.size()>0){//如果存在相同的name，则插入失败
            return 0;
        }
        DmsDiseCatalog dmsDiseCatalog = new DmsDiseCatalog();
        BeanUtils.copyProperties(dmsDiseCatalogParam,dmsDiseCatalog);
        dmsDiseCatalogMapper.insertSelective(dmsDiseCatalog);
        return 1;
    }

    /**
     * 描述：根据ids删除诊断目录
     * <p>author:王思阳
     * <p>author:赵煜 删除目录并删除目录中地诊断
     */
    @Override
    public int delete(List<Long> ids) {
        int count = ids == null ? 0 : ids.size();//得到要删除的数量
        if(!CollectionUtils.isEmpty(ids)) {
            for (Long id : ids) {
                DmsDiseCatalog dmsDiseCatalog = new DmsDiseCatalog();
                dmsDiseCatalog.setStatus(0);
                DmsDiseCatalogExample example = new DmsDiseCatalogExample();
                example.createCriteria().andIdEqualTo(id);
                dmsDiseCatalogMapper.updateByExampleSelective(dmsDiseCatalog, example);
                //删除诊断
                for(Long catalogId:ids){
                    DmsDiseExample dmsDiseExample=new DmsDiseExample();
                    dmsDiseExample.createCriteria().andCatIdEqualTo(catalogId);
                    DmsDise dmsDise=new DmsDise();
                    dmsDise.setStatus(0);
                    dmsDiseMapper.updateByExampleSelective(dmsDise,dmsDiseExample);
                }
            }
        }
        return count;
    }

    @Override
    public int update(Long id, DmsDiseCatalogParam dmsDiseCatalogParam) {
        DmsDiseCatalog dmsDiseCatalog = new DmsDiseCatalog();
        BeanUtils.copyProperties(dmsDiseCatalogParam,dmsDiseCatalog);
        DmsDiseCatalogExample example = new DmsDiseCatalogExample();
        example.createCriteria().andIdEqualTo(id);
        return dmsDiseCatalogMapper.updateByExampleSelective(dmsDiseCatalog,example);
    }

    @Override
    public List<DmsDiseCatalogResult> select(DmsDiseCatalogParam dmsDiseCatalogParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        DmsDiseCatalogExample example = new DmsDiseCatalogExample();
        DmsDiseCatalogExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(dmsDiseCatalogParam.getName())){
            criteria.andNameEqualTo(dmsDiseCatalogParam.getName());
        }
        if(!StringUtils.isEmpty(dmsDiseCatalogParam.getStatus())){
            criteria.andStatusEqualTo(dmsDiseCatalogParam.getStatus());
        }
        criteria.andStatusNotEqualTo(0);
        example.setOrderByClause("id desc");//按id升序
        List<DmsDiseCatalogResult> list = new ArrayList<>();
        for (DmsDiseCatalog dmsDiseCatalog:dmsDiseCatalogMapper.selectByExample(example)) {
            DmsDiseCatalogResult dmsDiseCatalogResult = new DmsDiseCatalogResult();
            BeanUtils.copyProperties(dmsDiseCatalog,dmsDiseCatalogResult);
            list.add(dmsDiseCatalogResult);
        }
        return list;
    }


    /**
     * 描述：查询所有诊断目录
     * <p>author:王思阳
     * <p>author:赵煜 列出目录也需要倒序
     */
    @Override
    public List<DmsDiseCatalogResult> selectAll() {
        List<DmsDiseCatalogResult> list = new ArrayList<>();
        DmsDiseCatalogExample example = new DmsDiseCatalogExample();
        example.createCriteria().andStatusNotEqualTo(0);
        example.setOrderByClause("id desc");//按id倒序
        for (DmsDiseCatalog dmsDiseCatalog:dmsDiseCatalogMapper.selectByExample(example)) {
            DmsDiseCatalogResult dmsDiseCatalogResult = new DmsDiseCatalogResult();
            BeanUtils.copyProperties(dmsDiseCatalog,dmsDiseCatalogResult);
            list.add(dmsDiseCatalogResult);
        }
        return list;
    }
}
