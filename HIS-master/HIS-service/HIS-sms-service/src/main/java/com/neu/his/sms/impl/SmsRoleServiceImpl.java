package com.neu.his.sms.impl;

import com.github.pagehelper.PageHelper;
import com.neu.his.common.dto.sms.SmsRoleParam;
import com.neu.his.mbg.dao.SmsRolePermissionDao;
import com.neu.his.mbg.mapper.SmsRoleMapper;
import com.neu.his.mbg.mapper.SmsRolePermissionRelationMapper;
import com.neu.his.mbg.model.*;
import com.neu.his.sms.SmsRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 角色
 */
@Service
public class SmsRoleServiceImpl implements SmsRoleService {

    @Autowired
    private SmsRoleMapper roleMapper;

    @Autowired
    private SmsRolePermissionDao rolePermissionDao;

    @Autowired
    private SmsRolePermissionRelationMapper rolePermissionRelationMapper;

    @Override
    public int create(SmsRoleParam smsRoleParam) {
        SmsRole smsRole = new SmsRole();
        BeanUtils.copyProperties(smsRoleParam, smsRole);
        //设置时间
        smsRole.setCreateTime(new Date());
        smsRole.setStatus(1);

        //查询是否有相同名字的角色
        SmsRoleExample example = new SmsRoleExample();
        example.createCriteria().andNameEqualTo(smsRole.getName());
        List<SmsRole> umsAdminList = roleMapper.selectByExample(example);
        if (umsAdminList.size() > 0) { //存在
            return 0;
        }
        return roleMapper.insert(smsRole);
    }

    @Override
    public int update(Long id, SmsRoleParam smsRoleParam) {
        SmsRole smsRole = new SmsRole();
        BeanUtils.copyProperties(smsRoleParam, smsRole);
        return roleMapper.updateByPrimaryKey(smsRole);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsRole smsRole = new SmsRole();
        smsRole.setStatus(0);
        SmsRoleExample example=new SmsRoleExample();
        example.createCriteria().andIdIn(ids);
        return roleMapper.updateByExampleSelective(smsRole,example);
    }

    @Override
    public List<SmsRole> select(SmsRoleParam smsRoleParam, Integer pageSize, Integer pageNum){
        PageHelper.startPage(pageNum, pageSize);
        SmsRoleExample example = new SmsRoleExample();
        SmsRoleExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(smsRoleParam.getName())){
            criteria.andNameLike("%"+smsRoleParam.getName()+"%");
        }
        if(!StringUtils.isEmpty(smsRoleParam.getCreateTime())){
            criteria.andCreateTimeEqualTo(smsRoleParam.getCreateTime());
        }
        if(!StringUtils.isEmpty(smsRoleParam.getStatus())){
            criteria.andStatusEqualTo(smsRoleParam.getStatus());
        }
        if(!StringUtils.isEmpty(smsRoleParam.getDescription())){
            criteria.andNameLike("%"+smsRoleParam.getDescription()+"%");
        }
        example.setOrderByClause("id desc");
        return roleMapper.selectByExample(example);
    }


    @Override
    public List<SmsRole> selectAll() {
        //选出status不为0的
        SmsRoleExample example = new SmsRoleExample();
        SmsRole smsRole=new SmsRole();
        example.createCriteria().andStatusNotEqualTo(new Integer(0));
        return roleMapper.selectByExample(example);
    }


    @Override
    public List<SmsPermission> getPermissionList(Long roleId) {

      return rolePermissionDao.getPermissionList(roleId);
    }

    @Override
    public int updatePermission(Long roleId, List<Long> permissionIds) {
        //先删除原有关系
        SmsRolePermissionRelationExample example=new SmsRolePermissionRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        rolePermissionRelationMapper .deleteByExample(example);
        // 批量插入新关系
        List<SmsRolePermissionRelation> relationList = new ArrayList<>();
        for(Long permissionId : permissionIds){
            SmsRolePermissionRelation relation = new SmsRolePermissionRelation();
            relation.setRoleId(roleId);
            relation.setPermissionId(permissionId);
            relationList.add(relation);
        }
        return rolePermissionDao.insertList(relationList);
    }


}
