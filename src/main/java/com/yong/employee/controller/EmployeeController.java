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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "员工Controller", tags = { "员工的操作增删改查" })
@RestController
@RequestMapping("emp")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("page")
    @ApiOperation(value = "分页查询", notes = "分页查询")
    public PageVO list(EmployeeReqVO query) {
        PageVO pageVO = employeeService.page(query);
        return pageVO;
    }

    @PostMapping
    @ApiOperation(value = "插入新增", notes = "插入新增")
    public Integer save(@Validated(SaveGroup.class) @RequestBody EmployeeVO employeeVO) {
        return employeeService.save(employeeVO);
    }

    @PutMapping
    @ApiOperation(value = "更新", notes = "更新")
    public Integer update(@Validated(UpdateGroup.class) @RequestBody EmployeeVO employeeVO) {
        return employeeService.update(employeeVO);
    }

    @DeleteMapping
    @ApiOperation(value = "删除", notes = "删除")
    public void delete(@Validated(DeleteGroup.class) @RequestBody EmployeeVO employeeVO) {
        employeeService.delete(employeeVO);
    }
}
