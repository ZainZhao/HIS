package com.neu.his.cloud.service.sms.service.impl;

import com.neu.his.cloud.service.sms.dto.sms.SmsPermissionNode;
import com.neu.his.cloud.service.sms.dto.sms.SmsPermissionParam;
import com.neu.his.cloud.service.sms.mapper.SmsPermissionMapper;
import com.neu.his.cloud.service.sms.model.SmsPermission;
import com.neu.his.cloud.service.sms.model.SmsPermissionExample;
import com.neu.his.cloud.service.sms.service.SmsPermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限
 */
@Service
public class SmsPermissionServiceImpl implements SmsPermissionService {

    @Autowired
    private SmsPermissionMapper smsPermissionMapper;

    @Override
    public int create(SmsPermissionParam smsPermissionParam) {
        SmsPermission smsPermission=new SmsPermission();
        BeanUtils.copyProperties(smsPermissionParam,smsPermission);
        smsPermission.setStatus(1);
        smsPermission.setCreateTime(new Date());
        smsPermission.setSort(0);
        return smsPermissionMapper.insert(smsPermission);
    }

    @Override
    public int update(Long id,SmsPermissionParam smsPermissionParam) {
        SmsPermission smsPermission=new SmsPermission();
        BeanUtils.copyProperties(smsPermissionParam,smsPermission);
        smsPermission.setId(id);
        return smsPermissionMapper.updateByPrimaryKey(smsPermission);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsPermissionExample example = new SmsPermissionExample();
        example.createCriteria().andIdIn(ids);
        return smsPermissionMapper.deleteByExample(example);
    }

    @Override
    public List<SmsPermission> selectAll() {
        return smsPermissionMapper.selectByExample(new SmsPermissionExample());
    }

    @Override
    public List<SmsPermissionNode> treeList() {
        //查询出所有的权限
        List<SmsPermission> permissionList = smsPermissionMapper.selectByExample(new SmsPermissionExample());

        List<SmsPermissionNode> result = permissionList.stream()
                .filter(permission -> permission.getPid().equals(0L))//筛选出pid为0的权限
                .map(permission -> covert(permission,permissionList)).collect(Collectors.toList());
        return result;
    }


    /**
     * 将权限转换为带有子级的权限对象
     * 当找不到子级权限的时候map操作不会再递归调用covert
     */
    private SmsPermissionNode covert(SmsPermission smsPermission,List<SmsPermission> permissionList){
        SmsPermissionNode node = new SmsPermissionNode();
        BeanUtils.copyProperties(smsPermission,node);
        List<SmsPermissionNode> children = permissionList.stream()
                .filter(subPermission -> subPermission.getPid().equals(smsPermission.getId()))
                .map(subPermission -> covert(subPermission,permissionList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }


}
