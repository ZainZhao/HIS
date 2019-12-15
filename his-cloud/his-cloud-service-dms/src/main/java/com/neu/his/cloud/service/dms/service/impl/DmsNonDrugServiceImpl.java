package com.neu.his.cloud.service.dms.service.impl;
import com.neu.his.cloud.service.dms.dto.dms.DmsNonDrugParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsNonDrugResult;
import com.neu.his.cloud.service.dms.mapper.DmsNonDrugMapper;
import com.neu.his.cloud.service.dms.mapper.SmsDeptMapper;
import com.neu.his.cloud.service.dms.model.DmsNonDrug;
import com.neu.his.cloud.service.dms.model.DmsNonDrugExample;
import com.neu.his.cloud.service.dms.service.DmsNonDrugService;
import com.neu.his.cloud.service.dms.util.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DmsNonDrugServiceImpl implements DmsNonDrugService {
    @Autowired
    private DmsNonDrugMapper dmsNonDrugMapper;

    @Autowired
    private SmsDeptMapper smsDeptMapper;

    @Autowired
    private RedisUtil redisUtil;
    /**
     * 描述：新增一个非药品
     * <p>author:王思阳
     * <p>author:赵煜     封装param中没有的数据
     * <p>author:赵煜     修复科室名字错误bug
     */
    @Override
    public int create(DmsNonDrugParam dmsNonDrugParam) {
        DmsNonDrugExample example = new DmsNonDrugExample();//根据code查询非药品是否存在
        example.createCriteria().andCodeEqualTo(dmsNonDrugParam.getCode());
        List<DmsNonDrug> dmsNonDrugList =dmsNonDrugMapper.selectByExample(example);
        if(dmsNonDrugList.size()>0){//如果存在相同的code，则插入失败
            return 0;
        }

        DmsNonDrug dmsNonDrug = new DmsNonDrug();//插入
        BeanUtils.copyProperties(dmsNonDrugParam, dmsNonDrug);
        dmsNonDrug.setStatus(1);  // 正常
        dmsNonDrug.setCreateDate(new Date());
        dmsNonDrugMapper.insertSelective(dmsNonDrug);

        //插入成功，在redis修改flag
        redisUtil.setObj("nonDrugChangeStatus","1");

        return 1;

    }

    @Override
    public int delete(List<Long> ids) {
        int count = ids == null ? 0 : ids.size();//得到要删除的数量
        if(!CollectionUtils.isEmpty(ids)){
            for(Long id : ids){
                DmsNonDrug dmsNonDrug = new DmsNonDrug();
                dmsNonDrug.setStatus(0);
                DmsNonDrugExample example = new DmsNonDrugExample();
                example.createCriteria().andIdEqualTo(id);
                dmsNonDrugMapper.updateByExampleSelective(dmsNonDrug,example);
            }
        }

        //删除成功，在redis修改flag
        redisUtil.setObj("nonDrugChangeStatus","1");

        return count;
    }

    @Override
    public int update(Long id, DmsNonDrugParam dmsNonDrugParam) {
        DmsNonDrug dmsNonDrug = new DmsNonDrug();
        BeanUtils.copyProperties(dmsNonDrugParam,dmsNonDrug);
        //dmsNonDrug.setId(id);
        DmsNonDrugExample example = new DmsNonDrugExample();
        example.createCriteria().andIdEqualTo(id);

        //更新成功，在redis修改flag
        redisUtil.setObj("nonDrugChangeStatus","1");

        return dmsNonDrugMapper.updateByExampleSelective(dmsNonDrug,example);
    }



    /**
     * 描述：模糊查询非药品、且分页
     * <p>author:王思阳
     * <p>author:赵煜   改为模糊查询,并封装科室名字
     *
     */
    @Override
    public List<DmsNonDrugResult> select(DmsNonDrugParam dmsNonDrugParam) {

        DmsNonDrugExample example = new DmsNonDrugExample();
        DmsNonDrugExample.Criteria criteria =example.createCriteria();

        if(!StringUtils.isEmpty(dmsNonDrugParam.getCode())){
            criteria.andCodeLike("%" + dmsNonDrugParam.getCode() + "%");
        }
        if(!StringUtils.isEmpty(dmsNonDrugParam.getName())){
            criteria.andNameLike("%" + dmsNonDrugParam.getName() + "%");
        }

        if(!StringUtils.isEmpty(dmsNonDrugParam.getMnemonicCode())){
            criteria.andMnemonicCodeLike("%" + dmsNonDrugParam.getMnemonicCode() + "%");
        }

        //执行科室和类型属于精确查找
        if(!StringUtils.isEmpty(dmsNonDrugParam.getRecordType())){
            criteria.andRecordTypeEqualTo(dmsNonDrugParam.getRecordType());
        }
        if(!StringUtils.isEmpty(dmsNonDrugParam.getDeptId())){
            criteria.andDeptIdEqualTo(dmsNonDrugParam.getDeptId());
        }

        criteria.andStatusNotEqualTo(0);
        example.setOrderByClause("id desc"); //按id降序
        List<DmsNonDrugResult> dmsNonDrugResultList = new ArrayList<>();
        List<DmsNonDrug> dmsNonDrugList= dmsNonDrugMapper.selectByExample(example);
        System.err.println(dmsNonDrugList);

        for (DmsNonDrug dmsNonDrug:dmsNonDrugList) {
            DmsNonDrugResult dmsNonDrugResult = new DmsNonDrugResult();
            BeanUtils.copyProperties(dmsNonDrug,dmsNonDrugResult);
            if(!StringUtils.isEmpty(dmsNonDrug.getDeptId())) {
                dmsNonDrugResult.setDeptName(smsDeptMapper.selectByPrimaryKey(dmsNonDrug.getDeptId()).getName());//封装科室名
            }
            dmsNonDrugResultList.add(dmsNonDrugResult);
        }
        return dmsNonDrugResultList;
    }

    @Override
    public List<DmsNonDrugResult> selectAll() {
        //先在redis中查询是否存在
        String status = (String)redisUtil.getObj("nonDrugChangeStatus");
        if(status != null && status.equals("0")){
            List<DmsNonDrugResult> resultList = (List<DmsNonDrugResult>)redisUtil.getObj("allNonDrug");
            if(resultList != null){
                return resultList;
            }
        }
        //在数据库中查找

        List<DmsNonDrugResult> list = new ArrayList<>();
        DmsNonDrugExample example = new DmsNonDrugExample();
        example.createCriteria().andStatusNotEqualTo(0);
        for (DmsNonDrug dmsNonDrug:dmsNonDrugMapper.selectByExample(example)) {
            DmsNonDrugResult dmsNonDrugResult = new DmsNonDrugResult();
            BeanUtils.copyProperties(dmsNonDrug,dmsNonDrugResult);
            list.add(dmsNonDrugResult);
        }

        //向redis添加
        redisUtil.setObj("allNonDrug",list);
        redisUtil.setObj("nonDrugChangeStatus","0");


        return list;
    }
}
