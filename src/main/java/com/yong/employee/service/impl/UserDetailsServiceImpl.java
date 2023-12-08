package com.yong.employee.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yong.employee.mapper.SysPermissionMapper;
import com.yong.employee.mapper.SysUserMapper;
import com.yong.employee.model.convert.SysUserConvert;
import com.yong.employee.model.dto.LoginUserInfo;
import com.yong.employee.model.po.SysPermissionPO;
import com.yong.employee.model.po.SysUserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysPermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SysUserPO> users = userMapper.selectList(new LambdaQueryWrapper<SysUserPO>().eq(SysUserPO::getUsername, username).or(queryWrapper -> {
            queryWrapper.eq(SysUserPO::getRealname, username);
        }));
        if (CollectionUtil.isEmpty(users)) {
            throw new RuntimeException("登录失败，用户名不存在");
        }
        LoginUserInfo loginUserInfo = SysUserConvert.INSTANCE.convertToDto(users.get(0));
        List<SysPermissionPO> permissionPos = permissionMapper.getPermissionByUserId(loginUserInfo.getId());

        // 创建权限集合
        List<String> grantedAuthorities = permissionPos.stream()
                .map(po -> po.getPermtag()).collect(Collectors.toList());

        loginUserInfo.setAuthorities(AuthorityUtils.createAuthorityList(
                grantedAuthorities.toArray(new String[]{})));

        return loginUserInfo;
    }
}
