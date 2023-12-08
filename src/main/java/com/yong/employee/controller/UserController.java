package com.yong.employee.controller;


import com.yong.employee.model.dto.LoginUserInfo;
import com.yong.employee.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private ISysUserService userService;

    @PostMapping("login")
    public String login(@RequestBody LoginUserInfo adminLoginDTO) {
        String jwt = userService.login(adminLoginDTO);
        return jwt;
    }

    @GetMapping("info")
    public Map info() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUserInfo userDetails = (LoginUserInfo) authentication.getPrincipal();
        Map<String, Object> resultMap = new HashMap() {{
            put("roles", new String[]{"admin"});
            put("introduction", "I am a super administrator");
            put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            put("name", userDetails.getUsername());
        }};
        return resultMap;
    }


}
