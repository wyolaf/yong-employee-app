package com.yong.employee.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageInfo;
import com.yong.employee.base.PageVO;
import com.yong.employee.mapper.EmployeeMapper;
import com.yong.employee.model.convert.EmployeeConvert;
import com.yong.employee.model.po.EmployeePO;
import com.yong.employee.model.vo.EmployeeReqVO;
import com.yong.employee.model.vo.EmployeeVO;
import com.yong.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public PageVO page(EmployeeReqVO vo) {
        List<EmployeePO> list = employeeMapper.page(vo);
        PageInfo page = new PageInfo(list);
        PageVO pageVO = new PageVO<>();
        pageVO.setItems(list);
        pageVO.setTotal(page.getTotal());
        return pageVO;
    }

    @Override
    public Integer save(EmployeeVO vo) {
        EmployeePO po = EmployeeConvert.INSTANCE.convertToPo(vo);
        employeeMapper.insert(po);
        return po.getId();
    }

    @Override
    public Integer update(EmployeeVO vo) {
        EmployeePO po = EmployeeConvert.INSTANCE.convertToPo(vo);
        employeeMapper.updateById(po);
        return po.getId();
    }

    @Override
    public void delete(EmployeeVO vo) {
        employeeMapper.deleteById(vo.getId());
    }
}
