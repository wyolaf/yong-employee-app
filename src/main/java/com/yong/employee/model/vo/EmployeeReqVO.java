package com.yong.employee.model.vo;

import com.yong.employee.base.ReqVO;
import lombok.Data;

@Data
public class EmployeeReqVO extends ReqVO {

    private String empName;

    private String deptName;

    private String empDegreeName;
}
