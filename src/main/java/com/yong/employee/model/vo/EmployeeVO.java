package com.yong.employee.model.vo;

import com.yong.employee.base.DeleteGroup;
import com.yong.employee.base.SaveGroup;
import com.yong.employee.base.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeVO {

    @ApiModelProperty("职工工号")
    @NotNull(groups = {UpdateGroup.class, DeleteGroup.class}, message = "主键不允许为空")
    private Integer id;

    @ApiModelProperty("职工姓名")
    @NotBlank(groups = {UpdateGroup.class, SaveGroup.class}, message = "职工姓名不能为空")
    private String empName;

    @ApiModelProperty("职工性别")
    @NotBlank(groups = {UpdateGroup.class, SaveGroup.class}, message = "职工性别不能为空")
    private String sex;

    @ApiModelProperty("职工年龄")
    @NotNull(groups = {UpdateGroup.class, SaveGroup.class}, message = "职工年龄不能为空")
    private Integer age;

    @ApiModelProperty("职工部门")
    @NotBlank(groups = {UpdateGroup.class, SaveGroup.class}, message = "职工部门不能为空")
    private String deptName;

    @ApiModelProperty("职工学历")
    @NotBlank(groups = {UpdateGroup.class, SaveGroup.class}, message = "职工学历不能为空")
    private String empDegreeName;
}
