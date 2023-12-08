package com.yong.employee.service.impl;

import com.yong.employee.model.dto.LoginUserInfo;
import com.yong.employee.service.ISysUserService;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    private String secretKey = "algkjaeihjaglkjfklaf";

    @Override
    public String login(LoginUserInfo adminLoginDTO) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                adminLoginDTO.getUsername(), adminLoginDTO.getPassword()
        );
        Authentication authenticate = authenticationManager.authenticate(authentication);
        // 生成jwt数据
        LoginUserInfo user = (LoginUserInfo) authenticate.getPrincipal();
        Map<String,Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        claims.put("permissions", user.getAuthorities());
        String jwt = Jwts.builder()
                .setHeaderParam(Header.CONTENT_TYPE, "HS256")
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        return jwt;
    }
}
