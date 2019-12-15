package com.neu.his.cloud.zuul.component;

import com.neu.his.cloud.zuul.model.SmsPermission;
import com.neu.his.cloud.zuul.model.SmsStaff;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 */
public class StaffDetails implements UserDetails {
    private SmsStaff smsStaff;
    private List<SmsPermission> permissionList;
    public StaffDetails(SmsStaff smsStaff, List<SmsPermission> permissionList) {
        this.smsStaff = smsStaff;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return permissionList.stream()
                .filter(permission -> permission.getValue()!=null)
                .map(permission ->new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return smsStaff.getPassword();
    }

    @Override
    public String getUsername() {
        return smsStaff.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return smsStaff.getStatus().equals(1);
    }
}
