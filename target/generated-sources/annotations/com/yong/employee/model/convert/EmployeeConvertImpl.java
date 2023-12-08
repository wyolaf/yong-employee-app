package com.yong.employee.model.convert;

import com.yong.employee.model.po.EmployeePO;
import com.yong.employee.model.vo.EmployeeVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-08T11:03:17+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class EmployeeConvertImpl implements EmployeeConvert {

    @Override
    public EmployeePO convertToPo(EmployeeVO vo) {
        if ( vo == null ) {
            return null;
        }

        EmployeePO employeePO = new EmployeePO();

        employeePO.setId( vo.getId() );
        employeePO.setEmpName( vo.getEmpName() );
        employeePO.setSex( vo.getSex() );
        employeePO.setAge( vo.getAge() );
        employeePO.setDeptName( vo.getDeptName() );
        employeePO.setEmpDegreeName( vo.getEmpDegreeName() );

        return employeePO;
    }

    @Override
    public EmployeeVO convertToVo(EmployeePO employeePO) {
        if ( employeePO == null ) {
            return null;
        }

        EmployeeVO employeeVO = new EmployeeVO();

        employeeVO.setId( employeePO.getId() );
        employeeVO.setEmpName( employeePO.getEmpName() );
        employeeVO.setSex( employeePO.getSex() );
        employeeVO.setAge( employeePO.getAge() );
        employeeVO.setDeptName( employeePO.getDeptName() );
        employeeVO.setEmpDegreeName( employeePO.getEmpDegreeName() );

        return employeeVO;
    }

    @Override
    public List<EmployeeVO> convertToVoList(List<EmployeePO> employeePOList) {
        if ( employeePOList == null ) {
            return null;
        }

        List<EmployeeVO> list = new ArrayList<EmployeeVO>( employeePOList.size() );
        for ( EmployeePO employeePO : employeePOList ) {
            list.add( convertToVo( employeePO ) );
        }

        return list;
    }
}
