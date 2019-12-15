package com.neu.his.cloud.service.dms.service.impl;



import cn.hutool.core.collection.CollectionUtil;
import com.neu.his.cloud.service.dms.dto.dms.DmsDosageResult;
import com.neu.his.cloud.service.dms.dto.dms.DmsDrugParam;
import com.neu.his.cloud.service.dms.dto.dms.DmsDrugResult;
import com.neu.his.cloud.service.dms.mapper.DmsDosageMapper;
import com.neu.his.cloud.service.dms.mapper.DmsDrugMapper;
import com.neu.his.cloud.service.dms.model.DmsDosage;
import com.neu.his.cloud.service.dms.model.DmsDosageExample;
import com.neu.his.cloud.service.dms.model.DmsDrug;
import com.neu.his.cloud.service.dms.model.DmsDrugExample;
import com.neu.his.cloud.service.dms.service.DmsDrugService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class DmsDrugServiceImpl implements DmsDrugService {

    @Autowired
    private DmsDrugMapper dmsDrugMapper;

    @Autowired
    private DmsDosageMapper dmsDosageMapper;




    @Override
    public int createDrug(DmsDrugParam dmsDiseParam){
        DmsDrug dmsDrug = new DmsDrug();
        BeanUtils.copyProperties(dmsDiseParam, dmsDrug);
        dmsDrug.setStatus(1);
        //查询是否有同code药品，且status为1的药品
        DmsDrugExample example = new DmsDrugExample();
        example.createCriteria().andCodeEqualTo(dmsDrug.getCode());
        List<DmsDrug> dmsDrugList = dmsDrugMapper.selectByExample(example);
        if (dmsDrugList.size() <= 0) {
            //没有则插入数据
            return dmsDrugMapper.insert(dmsDrug);
        }
        //有则判断status是否为0
        DmsDrug oldDrug = dmsDrugList.get(0);
        if(oldDrug.getStatus() == 1){
            return 0;
        }else{
            //status不为0,先删除，再插入
            dmsDrugMapper.deleteByExample(example);
            return dmsDrugMapper.insert(dmsDrug);
        }
    }

    @Override
    public int deleteDrug(List<Long> ids){
        DmsDrug dmsDrug = new DmsDrug();
        dmsDrug.setStatus(0);
        DmsDrugExample example = new DmsDrugExample();
        example.createCriteria().andIdIn(ids);
        return dmsDrugMapper.updateByExampleSelective(dmsDrug, example);
    }


    /**
     * 描述:更新
     * <p>author: ma
     * <p>author: 赵煜 修改更新逻辑，更新操作与code无关，code可以重复
     */
    @Override
    public int updateDrug(Long id, DmsDrugParam dmsDrugParam ){
        DmsDrug dmsDrug = new DmsDrug();
        BeanUtils.copyProperties(dmsDrugParam, dmsDrug);
        dmsDrug.setId(id);
        return dmsDrugMapper.updateByPrimaryKeySelective(dmsDrug);
    }

    @Override
    public List<DmsDrugResult> selectDrug(DmsDrugParam dmsDrugParam, Integer pageSize, Integer pageNum){
        DmsDrugExample example = new DmsDrugExample();
        DmsDrugExample.Criteria criteria = example.createCriteria();
        //如果没有指明state，返回不为0的
        if(dmsDrugParam.getStatus() == null){
            criteria.andStatusNotEqualTo(0);
        }
        //是否按编码、名称、规格、单价查询
        if(!StringUtils.isEmpty(dmsDrugParam.getCode())){
            criteria.andCodeLike("%" + dmsDrugParam.getCode() + "%");
        }
        if(!StringUtils.isEmpty(dmsDrugParam.getName())){
            criteria.andNameLike("%" + dmsDrugParam.getName() + "%");
        }
        if(!StringUtils.isEmpty(dmsDrugParam.getFormat())){
            criteria.andFormatLike("%" + dmsDrugParam.getFormat() + "%");
        }
        if(dmsDrugParam.getPrice() != null){
            criteria.andPriceEqualTo(dmsDrugParam.getPrice());
        }

        //是否按包装单位、生产厂家、药品剂型、药品类型查询
        if(!StringUtils.isEmpty(dmsDrugParam.getUnit())){
            criteria.andUnitLike("%" + dmsDrugParam.getUnit() + "%");
        }
        if(!StringUtils.isEmpty(dmsDrugParam.getManufacturer())){
            criteria.andManufacturerLike("%" + dmsDrugParam.getManufacturer() + "%");
        }
        if(dmsDrugParam.getDosageId() != null){
            criteria.andDosageIdEqualTo(dmsDrugParam.getDosageId());
        }
        if(dmsDrugParam.getTypeId() != null){
            criteria.andTypeIdEqualTo(dmsDrugParam.getTypeId());
        }

        //是否按拼音助记码、库存、通用名查询
        if(!StringUtils.isEmpty(dmsDrugParam.getMnemonicCode())){
            criteria.andMnemonicCodeLike("%" + dmsDrugParam.getMnemonicCode() + "%");
        }
        if(dmsDrugParam.getStock() != null){
            criteria.andStockEqualTo(dmsDrugParam.getStock());
        }
        if(!StringUtils.isEmpty(dmsDrugParam.getGenericName())){
            criteria.andGenericNameLike("%" + dmsDrugParam.getGenericName() + "%");
        }
        //返回数据包装成Result
        example.setOrderByClause("id desc");
        List<DmsDrug> smsDepts = dmsDrugMapper.selectByExample(example);
        List<DmsDrugResult> smsDeptResults = new ArrayList<>();
        for (DmsDrug s : smsDepts) {
            DmsDrugResult r = new DmsDrugResult();
            BeanUtils.copyProperties(s, r);

            DmsDosageExample dmsDosageExample = new DmsDosageExample();
            dmsDosageExample.createCriteria().andIdEqualTo(s.getDosageId());
            List<DmsDosage> dmsDosageList = dmsDosageMapper.selectByExample(dmsDosageExample);
            if(dmsDosageList.size() <= 0){
                return null;
            }
            r.setDosage(dmsDosageList.get(0));

            smsDeptResults.add(r);
        }
        return smsDeptResults;
    }


    /**
     * 描述:1.调用DmsDrugDao查询所有记录（不包括status=0）
     * <p>author: ma
     * <p>author: 赵煜 修改越界错误
     */
    @Override
    public List<DmsDrugResult> selectAllDrug(){
        DmsDrugExample example = new DmsDrugExample();
        example.createCriteria().andStatusNotEqualTo(0);
        //返回数据包装成Result
        List<DmsDrug> dmsDrugs = dmsDrugMapper.selectByExample(example);
        List<DmsDrugResult> dmsDrugResultList = new ArrayList<>();
        for (DmsDrug dmsDrug   : dmsDrugs) {
            DmsDrugResult dmsDrugResult = new DmsDrugResult();
            BeanUtils.copyProperties(dmsDrug, dmsDrugResult);

            DmsDosageExample dmsDosageExample = new DmsDosageExample();
            //封装剂型
            dmsDosageExample.createCriteria().andIdEqualTo(dmsDrug.getDosageId());
            List<DmsDosage> dmsDosageList = dmsDosageMapper.selectByExample(dmsDosageExample);
            if(!CollectionUtil.isEmpty(dmsDosageList)){
                dmsDrugResult.setDosage(dmsDosageList.get(0));
            }
            dmsDrugResultList.add(dmsDrugResult);
        }
        return dmsDrugResultList;
    }

    @Override
    public List<DmsDosageResult> selectAllDosage(){
        DmsDosageExample example = new DmsDosageExample();
        example.createCriteria().andStatusNotEqualTo(0);
        //返回数据包装成Result
        List<DmsDosage> dmsDosages = dmsDosageMapper.selectByExample(example);
        List<DmsDosageResult> dosageResults = new ArrayList<>();
        for (DmsDosage s : dmsDosages) {
            DmsDosageResult r = new DmsDosageResult();
            BeanUtils.copyProperties(s, r);
            dosageResults.add(r);
        }
        return dosageResults;
    }

    @Override
    public DmsDrugResult selectById(Long id) {
        DmsDrug dmsDrug = dmsDrugMapper.selectByPrimaryKey(id);
        DmsDrugResult dmsDrugResult = new DmsDrugResult();
        BeanUtils.copyProperties(dmsDrug,dmsDrugResult);
        //封装剂型
        DmsDosage dmsDosage = dmsDosageMapper.selectByPrimaryKey(dmsDrug.getDosageId());
        dmsDrugResult.setDosage(dmsDosage);
        return dmsDrugResult;
    }

}
