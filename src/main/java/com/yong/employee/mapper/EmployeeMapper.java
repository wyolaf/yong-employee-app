package com.yong.employee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yong.employee.model.po.EmployeePO;
import com.yong.employee.model.vo.EmployeeReqVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper extends BaseMapper<EmployeePO> {

    List<EmployeePO> page(EmployeeReqVO reqVO);
}