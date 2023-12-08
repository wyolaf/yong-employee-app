package com.yong.employee.model.convert;

import com.yong.employee.model.po.EmployeePO;
import com.yong.employee.model.vo.EmployeeReqVO;
import com.yong.employee.model.vo.EmployeeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeConvert {

    EmployeeConvert INSTANCE = Mappers.getMapper(EmployeeConvert.class);

    EmployeePO convertToPo(EmployeeVO vo);

    EmployeeVO convertToVo(EmployeePO employeePO);

    List<EmployeeVO> convertToVoList(List<EmployeePO> employeePOList);
}
