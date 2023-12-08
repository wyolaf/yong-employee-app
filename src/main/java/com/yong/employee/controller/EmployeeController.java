package com.yong.employee.controller;

import com.yong.employee.base.DeleteGroup;
import com.yong.employee.base.PageVO;
import com.yong.employee.base.SaveGroup;
import com.yong.employee.base.UpdateGroup;
import com.yong.employee.model.convert.EmployeeConvert;
import com.yong.employee.model.po.EmployeePO;
import com.yong.employee.model.vo.EmployeeReqVO;
import com.yong.employee.model.vo.EmployeeVO;
import com.yong.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("emp")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("page")
    public PageVO list(EmployeeReqVO query) {
        PageVO pageVO = employeeService.page(query);
        return pageVO;
    }

    @PostMapping
    public Integer save(@Validated(SaveGroup.class) @RequestBody EmployeeVO employeeVO) {
        return employeeService.save(employeeVO);
    }

    @PutMapping
    public Integer update(@Validated(UpdateGroup.class) @RequestBody EmployeeVO employeeVO) {
        return employeeService.update(employeeVO);
    }

    @DeleteMapping
    public void delete(@Validated(DeleteGroup.class) @RequestBody EmployeeVO employeeVO) {
        employeeService.delete(employeeVO);
    }
}
