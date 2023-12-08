package com.yong.employee.config;

import com.yong.employee.base.BaseErrorCode;
import com.yong.employee.base.ResponseResult;
import com.yong.employee.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁止防跨域攻击
        http.csrf().disable();

        //配置白名单
        String[] urls = {
                "/user/login",
                "/swagger-ui.html",
                "/doc.html",
                "/**/*.js",
                "/**/*.css",
                "/swagger-resources",
                "/v2/api-docs",
                "/favicon.ico"
        };

        // 配置各请求路径的认证与授权
        http.authorizeRequests()
                // 请求需要授权才可以访问
                // 配置白名单内的请求路径放行
                .antMatchers(urls)
                // 允许直接访问
                .permitAll()
                // 匹配除了以上配置的其他请求
                .anyRequest()
                // 都需要认证
                .authenticated();
        http.exceptionHandling().accessDeniedHandler((request, response, accessDeniedException) -> {
            ResponseResult result = ResponseResult.error(BaseErrorCode.BUSINESS_ERROR, "登录失败!");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(result);
        }).authenticationEntryPoint((request, response, accessDeniedException) -> {
            ResponseResult result = ResponseResult.error(BaseErrorCode.BUSINESS_ERROR, accessDeniedException.getMessage());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(result);
        });
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
