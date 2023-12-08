package com.yong.employee.filter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yong.employee.base.BaseErrorCode;
import com.yong.employee.base.ResponseResult;
import com.yong.employee.mapper.SysPermissionMapper;
import com.yong.employee.mapper.SysUserMapper;
import com.yong.employee.model.convert.SysUserConvert;
import com.yong.employee.model.dto.LoginUserInfo;
import com.yong.employee.model.po.SysPermissionPO;
import com.yong.employee.model.po.SysUserPO;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private String secretKey = "algkjaeihjaglkjfklaf";

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PERMISSIONS = "permissions";

    @Autowired
    SysUserMapper userMapper;

    @Autowired
    private SysPermissionMapper permissionMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        SecurityContextHolder.clearContext();
        String jwt = request.getHeader("Authorization");
        if ("/employee/user/login".equals(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }
        if(!StringUtils.hasText(jwt)) {
            filterChain.doFilter(request, response);
            return;
        }
        String username = null;
        String permissionsString = null;
        try {
            Claims claims = Jwts.parser().setSigningKey(secretKey)
                    .parseClaimsJws(jwt)
                    .getBody();
            username = claims.get(KEY_USERNAME).toString();
            permissionsString = JSONObject.toJSONString(claims.get(KEY_PERMISSIONS));
        } catch (ExpiredJwtException e) {
            ResponseResult result = ResponseResult.error(BaseErrorCode.BUSINESS_ERROR, "您的登录已过期,请重新登录!");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(result);
            return;
        } catch (MalformedJwtException e) {
            ResponseResult result = ResponseResult.error(BaseErrorCode.BUSINESS_ERROR, "获取登录信息失败,请重新登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(result);
            return;
        } catch (SignatureException e) {
            ResponseResult result = ResponseResult.error(BaseErrorCode.BUSINESS_ERROR, "获取登录信息失败,请重新登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(result);
            return;
        } catch (Throwable e) {
            ResponseResult result = ResponseResult.error(BaseErrorCode.BUSINESS_ERROR, "获取登录信息失败,请重新登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(result);
            return;
        }

        SysUserPO userPO = userMapper.selectOne(new LambdaQueryWrapper<SysUserPO>().eq(SysUserPO::getUsername, username));
        LoginUserInfo loginUserInfo = SysUserConvert.INSTANCE.convertToDto(userPO);

        List<SimpleGrantedAuthority> permissions = JSONArray.parseArray(permissionsString, SimpleGrantedAuthority.class);
        Authentication authentication = new UsernamePasswordAuthenticationToken
                (loginUserInfo,null, permissions);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request,response);
    }
}
