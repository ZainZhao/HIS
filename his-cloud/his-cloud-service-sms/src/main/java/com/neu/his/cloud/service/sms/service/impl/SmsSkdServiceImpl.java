package com.neu.his.cloud.service.sms.service.impl;



import cn.hutool.core.collection.CollectionUtil;
import com.neu.his.cloud.service.sms.dto.sms.*;
import com.neu.his.cloud.service.sms.mapper.*;
import com.neu.his.cloud.service.sms.model.*;
import com.neu.his.cloud.service.sms.service.SmsSkdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 排班
 */
@Service
public class SmsSkdServiceImpl implements SmsSkdService {

    @Autowired
    private SmsSkdRuleMapper smsSkdRuleMapper;

    @Autowired
    private SmsSkdRuleItemMapper smsSkdRuleItemMapper;

    @Autowired
    private SmsDeptMapper smsDeptMapper;

    @Autowired
    private SmsStaffMapper smsStaffMapper;

    @Autowired
    private SmsSkdMapper smsSkdMapper;

    @Autowired
    private SmsRegistrationRankMapper smsRegistrationRankMapper;


    @Override
    public int createRule(SmsSkdRuleParam smsSkdRuleParam){
        SmsSkdRule smsSkdRule = new SmsSkdRule();
        BeanUtils.copyProperties(smsSkdRuleParam, smsSkdRule);
        smsSkdRule.setStatus(1);
        smsSkdRule.setOperateTime(new Date());
        int skdRuleCount = smsSkdRuleMapper.insert(smsSkdRule);

        //根据操作员id和操作时间查询排版规则的id
        SmsSkdRuleExample ruleExample = new SmsSkdRuleExample();
        ruleExample.createCriteria().andOperatorIdEqualTo(smsSkdRuleParam.getOperatorId());
        ruleExample.setOrderByClause("operate_time desc");
        List<SmsSkdRule> smsSkdRuleList = smsSkdRuleMapper.selectByExample(ruleExample);
        if(smsSkdRuleList.size() <= 0){
            return 0;
        }
        Long skdRuleId = smsSkdRuleList.get(0).getId();

        //遍历排班项并全部插入
        int sumOfRuleItem = 0;
        for(SmsSkdRuleItemParam smsSkdRuleItemParam : smsSkdRuleParam.getSmsSkdRuleItemParamList()){
            SmsSkdRuleItem smsSkdRuleItem = new SmsSkdRuleItem();
            BeanUtils.copyProperties(smsSkdRuleItemParam,smsSkdRuleItem);
            smsSkdRuleItem.setStatus(1);
            smsSkdRuleItem.setSkRuleId(skdRuleId);
            sumOfRuleItem += smsSkdRuleItemMapper.insert(smsSkdRuleItem);
        }
        return skdRuleCount + sumOfRuleItem;
    }

    @Override
    public int deleteRule(List<Long> ids){
        //删除Rule
        SmsSkdRuleExample smsSkdRuleExample = new SmsSkdRuleExample();
        smsSkdRuleExample.createCriteria().andIdIn(ids);
        int skdRuleCount = smsSkdRuleMapper.deleteByExample(smsSkdRuleExample);

        //删除RuleItem
        SmsSkdRuleItemExample smsSkdRuleItemExample = new SmsSkdRuleItemExample();
        smsSkdRuleItemExample.createCriteria().andSkRuleIdIn(ids);
        int skdRuleItemCount = smsSkdRuleItemMapper.deleteByExample(smsSkdRuleItemExample);
        return skdRuleCount + skdRuleItemCount;
    }

    @Override
    public int updateRule(Long id,SmsSkdRuleParam smsSkdRuleParam){
        List<Long> deleteList = new ArrayList<>();
        deleteList.add(id);

        //根据id删除
        int deleteCount = deleteRule(deleteList);

        //插入新排版规则
        int insertCount = createRule(smsSkdRuleParam);
        return deleteCount + insertCount;
    }

    /**
     * 描述:1.调用SmsSkdRuleDao根据deptId查找数据（不包括规则项）
     * <p>author: ma
     * <p>author: 赵煜 修改查询不到科室排班规则500错误，封装操作员姓名
     */
    @Override
    public List<SmsSkdRuleResult> selectRuleByDept(Long deptId){
        //获取科室名
        SmsDept smsDept = smsDeptMapper.selectByPrimaryKey(deptId);
        if(StringUtils.isEmpty(smsDept)){
            return null;
        }
        //查询一个科室的所有排版规则(status为1)
        SmsSkdRuleExample smsSkdRuleExample = new SmsSkdRuleExample();
        smsSkdRuleExample.createCriteria().andDeptIdEqualTo(deptId).andStatusEqualTo(1);
        List<SmsSkdRule> smsSkdRuleList = smsSkdRuleMapper.selectByExample(smsSkdRuleExample);
        if(CollectionUtils.isEmpty(smsSkdRuleList)){  //如果为空，则不需要接下来的数据封装
            return null;
        }
        List<SmsSkdRuleResult> smsSkdRuleResultList = new ArrayList<>();
        for(SmsSkdRule smsSkdRule : smsSkdRuleList){
            SmsSkdRuleResult smsSkdRuleResult = new SmsSkdRuleResult();
            BeanUtils.copyProperties(smsSkdRule,smsSkdRuleResult);
            //设置科室名
            smsSkdRuleResult.setDeptName(smsDept.getName());
            //设置操作姓名
            SmsStaff operator=smsStaffMapper.selectByPrimaryKey(smsSkdRule.getOperatorId());
            if(null!=operator){
                smsSkdRuleResult.setOperatorName(operator.getUsername());
            }
            //设置排班项（暂不用）
            smsSkdRuleResultList.add(smsSkdRuleResult);
        }
        return smsSkdRuleResultList;
    }

    @Override
    public SmsSkdRuleResult getRuleDetail(Long ruleId){
        SmsSkdRule smsSkdRule = smsSkdRuleMapper.selectByPrimaryKey(ruleId);
        if(smsSkdRule == null){
            return null;
        }
        SmsSkdRuleResult smsSkdRuleResult = new SmsSkdRuleResult();
        BeanUtils.copyProperties(smsSkdRule,smsSkdRuleResult);

        //设置科室名
        String deptName = smsDeptMapper.selectByPrimaryKey(smsSkdRuleResult.getDeptId()).getName();
        if(deptName == null){
            return null;
        }
        smsSkdRuleResult.setDeptName(deptName);

        //设置排班项
        List<SmsSkdRuleItemResult> smsSkdRuleItemResultList = new ArrayList<>();
        SmsSkdRuleItemExample smsSkdRuleItemExample = new SmsSkdRuleItemExample();
        smsSkdRuleItemExample.createCriteria().andSkRuleIdEqualTo(smsSkdRuleResult.getId());
        List<SmsSkdRuleItem> smsSkdRuleItemList = smsSkdRuleItemMapper.selectByExample(smsSkdRuleItemExample);
        for(SmsSkdRuleItem smsSkdRuleItem : smsSkdRuleItemList){
            SmsSkdRuleItemResult smsSkdRuleItemResult = new SmsSkdRuleItemResult();
            BeanUtils.copyProperties(smsSkdRuleItem,smsSkdRuleItemResult);
            //获取并设置医生name
            SmsStaff smsStaff = smsStaffMapper.selectByPrimaryKey(smsSkdRuleItemResult.getStaffId());
            smsSkdRuleItemResult.setStaffName(smsStaff.getName());

            smsSkdRuleItemResultList.add(smsSkdRuleItemResult);
        }

        smsSkdRuleResult.setSmsSkdRuleItemResultList(smsSkdRuleItemResultList);
        return smsSkdRuleResult;
    }

    @Override
    public int generateSkd(List<Long> ruleIds,Date startDate,Date endDate){
        if(endDate.compareTo(startDate) < 0){
            return 0;
        }

        //设置排版规则id与科室id对应
        SmsSkdRuleExample smsSkdRuleExample = new SmsSkdRuleExample();
        smsSkdRuleExample.createCriteria().andIdIn(ruleIds);
        List<SmsSkdRule> smsSkdRuleList = smsSkdRuleMapper.selectByExample(smsSkdRuleExample);
        Map<Long, Long> ruleIdToDeptIdMap = new Hashtable<>();
        for(SmsSkdRule smsSkdRule : smsSkdRuleList){
            ruleIdToDeptIdMap.put(smsSkdRule.getId(),smsSkdRule.getDeptId());
        }

        //调用SmsSkdRuleItemDao查询所有ruleIds的排班项，并合并为一个Map
        SmsSkdRuleItemExample smsSkdRuleItemExample = new SmsSkdRuleItemExample();
        smsSkdRuleItemExample.createCriteria().andSkRuleIdIn(ruleIds).andStatusEqualTo(1);
        List<SmsSkdRuleItem> smsSkdRuleItemList = smsSkdRuleItemMapper.selectByExample(smsSkdRuleItemExample);
        Map<Long, List<SmsSkdRuleItem>> deptIdToItemListMap = new Hashtable<>();
        //生成一个StaffIdList
        List<Long> staffIdList = new ArrayList<>();
        for(SmsSkdRuleItem smsSkdRuleItem :smsSkdRuleItemList){
            Long currentDeptId = ruleIdToDeptIdMap.get(smsSkdRuleItem.getSkRuleId());
            List<SmsSkdRuleItem> currentItemList;
            if(deptIdToItemListMap.containsKey(currentDeptId)){
                currentItemList = deptIdToItemListMap.get(currentDeptId);
                //判断该staff是否已经存在
                for(SmsSkdRuleItem currentItem : currentItemList){
                    if(smsSkdRuleItem.getStaffId() == currentItem.getStaffId()){
                        return 0;
                    }
                }
            }else {
                currentItemList = new ArrayList<>();
            }
            currentItemList.add(smsSkdRuleItem);
            staffIdList.add(smsSkdRuleItem.getStaffId());
            deptIdToItemListMap.put(currentDeptId,currentItemList);
        }

        //没有重复，则遍历排班记录表，根据Date\staffId删除排班记录
        SmsSkdExample smsSkdExample = new SmsSkdExample();
        smsSkdExample.createCriteria().andDateBetween(startDate,endDate).andStaffIdIn(staffIdList);
        int deleteSkdCount = smsSkdMapper.deleteByExample(smsSkdExample);

        //遍历起止时间,判断每一天为周几，取出所有itemList中的daysOfWeek，如果为周i，则取出第2(i-1)位和第2(i-1)+1位。如果为0，则continue，如果为1，则插入skd
        int insertSkdCount = 0;
        List<Date> listDate = getDatesBetweenTwoDate(startDate, endDate);
        for(Date today : listDate){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(today);
            int week = calendar.get(Calendar.DAY_OF_WEEK) - 2;  //此时week，周日为-1
            if(week == -1){
                week = 6;       //将周日设置为6
            }
            //遍历map
            for(Long currentDeptId : deptIdToItemListMap.keySet()){
                List<SmsSkdRuleItem> currentItemList = deptIdToItemListMap.get(currentDeptId);
                //遍历同一科室id下Item
                for(SmsSkdRuleItem ruleItem : currentItemList){
                    String noon = ruleItem.getDaysOfWeek();
                    char morning = noon.charAt(2*week);
                    char afternoon = noon.charAt(2*week + 1);

                    if(morning == '1'){
                        //添加上午值班信息
                        SmsSkd skd = new SmsSkd();
                        skd.setDate(today);
                        skd.setStatus(1);
                        skd.setRemain(ruleItem.getSkLimit());
                        skd.setNoon(0);
                        skd.setStaffId(ruleItem.getStaffId());
                        skd.setDeptId(currentDeptId);
                        skd.setSkLimit(ruleItem.getSkLimit());
                        insertSkdCount += smsSkdMapper.insert(skd);
                    }
                    if(afternoon == '1'){
                        //添加下午值班信息
                        SmsSkd skd = new SmsSkd();
                        skd.setDate(today);
                        skd.setStatus(1);
                        skd.setRemain(ruleItem.getSkLimit());
                        skd.setNoon(1);
                        skd.setStaffId(ruleItem.getStaffId());
                        skd.setDeptId(currentDeptId);
                        skd.setSkLimit(ruleItem.getSkLimit());
                        insertSkdCount += smsSkdMapper.insert(skd);
                    }
                }
            }
        }
        return insertSkdCount;
    }

    @Override
    public List<SmsSkdResult> listSkd(SmsSkdParam smsSkdParam){
        SmsSkdExample smsSkdExample = new SmsSkdExample();
        SmsSkdExample.Criteria criteria = smsSkdExample.createCriteria();
        criteria.andStatusEqualTo(1);

        //根据医生id、起止时间、午别、科室id查询
        if(smsSkdParam.getStaffId() != null){
            criteria.andStaffIdEqualTo(smsSkdParam.getStaffId());
        }
        //20190625 ma
        if(smsSkdParam.getStartDate() != null){
            criteria.andDateGreaterThanOrEqualTo(smsSkdParam.getStartDate());
        }
        if(smsSkdParam.getEndDate() != null){
            criteria.andDateLessThanOrEqualTo(smsSkdParam.getEndDate());
        }
        if(smsSkdParam.getNoon() != null){
            criteria.andNoonEqualTo(smsSkdParam.getNoon());
        }
        if(smsSkdParam.getDeptId() != null){
            criteria.andDeptIdEqualTo(smsSkdParam.getDeptId());
        }
        //根据挂号级别查询
        if(smsSkdParam.getRegistrationRankId() != null){
            SmsStaffExample smsStaffExample = new SmsStaffExample();
            SmsStaffExample.Criteria staffCriteria = smsStaffExample.createCriteria();
            staffCriteria.andStatusEqualTo(1);
            if(smsSkdParam.getDeptId() != null){
                staffCriteria.andDeptIdEqualTo(smsSkdParam.getDeptId());
            }
            staffCriteria.andRegistrationRankIdEqualTo(smsSkdParam.getRegistrationRankId());

            List<SmsStaff> smsStaffList = smsStaffMapper.selectByExample(smsStaffExample);
            List<Long> smsStaffIdList = new ArrayList<>();
            for(SmsStaff smsStaff : smsStaffList){
                smsStaffIdList.add(smsStaff.getId());
            }
            criteria.andStaffIdIn(smsStaffIdList);
        }


        //返回数据包装成Result  201906225 ma
        smsSkdExample.setOrderByClause("date desc");

        List<SmsSkd> smsSkdList = smsSkdMapper.selectByExample(smsSkdExample);
        List<SmsSkdResult> smsSkdResultList = new ArrayList<>();
        for (SmsSkd smsSkd : smsSkdList) {
            SmsSkdResult smsSkdResult = new SmsSkdResult();
            BeanUtils.copyProperties(smsSkd, smsSkdResult);

            //封装部门名称
            SmsDept smsDept = smsDeptMapper.selectByPrimaryKey(smsSkd.getDeptId());
            smsSkdResult.setDeptName(smsDept.getName());

            //封装医生姓名、挂号级别
            SmsStaff smsStaff = smsStaffMapper.selectByPrimaryKey(smsSkd.getStaffId());
            smsSkdResult.setStaffName(smsStaff.getName());
            SmsRegistrationRank smsRegistrationRank = smsRegistrationRankMapper.selectByPrimaryKey(smsStaff.getRegistrationRankId());
            smsSkdResult.setRegistrationRank(smsRegistrationRank.getName());

            smsSkdResultList.add(smsSkdResult);
        }
        return smsSkdResultList;
    }

    @Override
    public List<SmsSkdDocResult> listDocBySkd(SmsSkdDocParam smsSkdDocParam){
        SmsSkdExample smsSkdExample = new SmsSkdExample();
        SmsSkdExample.Criteria criteria = smsSkdExample.createCriteria();
        criteria.andStatusEqualTo(1).andRemainGreaterThan(new Long(0));
        if(smsSkdDocParam.getDate() != null){
            System.err.println("getDate:"+smsSkdDocParam.getDate());
            criteria.andDateEqualTo(smsSkdDocParam.getDate());
        }
        if(smsSkdDocParam.getNoon() != null){
            System.err.println("getNoon:"+smsSkdDocParam.getNoon());
            criteria.andNoonEqualTo(smsSkdDocParam.getNoon());
        }
        if(smsSkdDocParam.getDeptId() != null){
            System.err.println("getDeptId:"+smsSkdDocParam.getDeptId());
            criteria.andDeptIdEqualTo(smsSkdDocParam.getDeptId());
        }
        if(smsSkdDocParam.getRegistrationRankId() != null){
            SmsStaffExample smsStaffExample = new SmsStaffExample();
            SmsStaffExample.Criteria staffCriteria = smsStaffExample.createCriteria();
            staffCriteria.andStatusEqualTo(1);
            System.err.println(smsSkdDocParam);
            if(smsSkdDocParam.getDeptId() != null){
                staffCriteria.andDeptIdEqualTo(smsSkdDocParam.getDeptId());
            }
            staffCriteria.andRegistrationRankIdEqualTo(smsSkdDocParam.getRegistrationRankId());

            List<SmsStaff> smsStaffList = smsStaffMapper.selectByExample(smsStaffExample);
            List<Long> smsStaffIdList = new ArrayList<>();
         //   System.err.println("smsStaffIdList.size():"+smsStaffIdList.size());
            for(SmsStaff smsStaff : smsStaffList){
                smsStaffIdList.add(smsStaff.getId());
            }
            if(!CollectionUtil.isEmpty(smsStaffList))
                 criteria.andStaffIdIn(smsStaffIdList);
        }



        //返回数据包装成Result
        List<SmsSkd> smsSkdList = smsSkdMapper.selectByExample(smsSkdExample);
        List<SmsSkdDocResult> smsSkdDocResultList = new ArrayList<>();
        for (SmsSkd smsSkd : smsSkdList) {
            SmsSkdDocResult smsSkdDocResult = new SmsSkdDocResult();
            smsSkdDocResult.setSkdId(smsSkd.getId());

            //封装医生名字和挂号费
            SmsStaff smsStaff = smsStaffMapper.selectByPrimaryKey(smsSkd.getStaffId());
            smsSkdDocResult.setName(smsStaff.getName());
            SmsRegistrationRank smsRegistrationRank = smsRegistrationRankMapper.selectByPrimaryKey(smsStaff.getRegistrationRankId());
            smsSkdDocResult.setAmount(smsRegistrationRank.getPrice());

            smsSkdDocResultList.add(smsSkdDocResult);
        }
        return smsSkdDocResultList;
    }

    @Override
    public List<SmsSkdRuleItemResult> listCanSkdStaffByDept(Long deptId) {
        SmsStaffExample example = new SmsStaffExample();
        example.createCriteria().andDeptIdEqualTo(deptId).andStatusNotEqualTo(0).andSkdFlagEqualTo(1);//找出可以排班的员工
        List<SmsStaff> smsStaffList = smsStaffMapper.selectByExample(example);
        List<SmsSkdRuleItemResult> smsSkdRuleItemResultList=new ArrayList<>();
        for (SmsStaff smsStaff:smsStaffList){
            SmsSkdRuleItemResult smsSkdRuleItemResult=new SmsSkdRuleItemResult();
           smsSkdRuleItemResult.setStaffName(smsStaff.getName());
           smsSkdRuleItemResult.setStaffId(smsStaff.getId());
            smsSkdRuleItemResultList.add(smsSkdRuleItemResult);
        }
        return smsSkdRuleItemResultList;
    }

    //根据起止日期生成日期List
    public List<Date> getDatesBetweenTwoDate(Date start, Date end){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        List<Date> dateList = new ArrayList<>();
        while(calendar.getTime().compareTo(end) <= 0){
            dateList.add(calendar.getTime());
            calendar.add(Calendar.DATE, 1);
        }
        return dateList;
    }
}
