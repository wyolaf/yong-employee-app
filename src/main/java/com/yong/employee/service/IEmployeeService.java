package com.yong.employee.service;

import com.yong.employee.base.PageVO;
import com.yong.employee.model.po.EmployeePO;
import com.yong.employee.model.vo.EmployeeReqVO;
import com.yong.employee.model.vo.EmployeeVO;

import java.util.List;

public interface IEmployeeService {

    PageVO page(EmployeeReqVO vo);

    Integer save(EmployeeVO vo);

    Integer update(EmployeeVO vo);

    void delete(EmployeeVO vo);
}
