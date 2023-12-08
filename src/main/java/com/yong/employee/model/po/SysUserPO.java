package com.yong.employee.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

@Data
@TableName("sys_user")
public class SysUserPO {
    @TableId
    private Integer id;

    private String username;

    private String realname;

    private String password;

    private Date createdate;

    private Date lastlogintime;

    private Integer enabled;

    private Integer accountnonexpired;

    private Integer accountnonlocked;

    private Integer credentialsnonexpired;
}