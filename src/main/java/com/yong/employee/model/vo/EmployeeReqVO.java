package com.yong.employee.model.vo;

import com.yong.employee.base.ReqVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="分页查询", description="员工信息分页查询对象")
@Data
public class EmployeeReqVO extends ReqVO {

    @ApiModelProperty("姓名")
    private String empName;

    @ApiModelProperty("部门")
    private String deptName;

    @ApiModelProperty("学历")
    private String empDegreeName;
}
