package com.yong.employee.model.dto;

import com.yong.employee.model.po.SysUserPO;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
public class LoginUserInfo extends SysUserPO implements UserDetails {

    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        if (super.getAccountnonexpired() == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (super.getAccountnonlocked() == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        if (super.getCredentialsnonexpired() == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEnabled() {
        if (super.getEnabled() == 1) {
            return true;
        }
        return false;
    }
}
