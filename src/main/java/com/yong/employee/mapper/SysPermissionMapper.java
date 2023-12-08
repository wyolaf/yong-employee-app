package com.yong.employee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yong.employee.model.po.SysPermissionPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysPermissionMapper extends BaseMapper<SysPermissionPO> {

    List<SysPermissionPO> getPermissionByUserId(@Param("userId") Integer userId);
}