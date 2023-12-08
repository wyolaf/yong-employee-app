package com.yong.employee.model.convert;

import com.yong.employee.model.dto.LoginUserInfo;
import com.yong.employee.model.po.SysUserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserConvert {

    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    LoginUserInfo convertToDto(SysUserPO sysUserPO);
}
