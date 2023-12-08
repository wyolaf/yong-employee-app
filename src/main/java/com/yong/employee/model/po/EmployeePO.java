package com.yong.employee.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("employee")
public class EmployeePO {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String empName;

    private String sex;

    private Integer age;

    private String deptName;

    private String empDegreeName;
}