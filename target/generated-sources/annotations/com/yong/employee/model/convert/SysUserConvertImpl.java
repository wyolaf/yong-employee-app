package com.yong.employee.model.convert;

import com.yong.employee.model.dto.LoginUserInfo;
import com.yong.employee.model.po.SysUserPO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-08T11:03:18+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class SysUserConvertImpl implements SysUserConvert {

    @Override
    public LoginUserInfo convertToDto(SysUserPO sysUserPO) {
        if ( sysUserPO == null ) {
            return null;
        }

        LoginUserInfo loginUserInfo = new LoginUserInfo();

        loginUserInfo.setId( sysUserPO.getId() );
        loginUserInfo.setUsername( sysUserPO.getUsername() );
        loginUserInfo.setRealname( sysUserPO.getRealname() );
        loginUserInfo.setPassword( sysUserPO.getPassword() );
        loginUserInfo.setCreatedate( sysUserPO.getCreatedate() );
        loginUserInfo.setLastlogintime( sysUserPO.getLastlogintime() );
        loginUserInfo.setEnabled( sysUserPO.getEnabled() );
        loginUserInfo.setAccountnonexpired( sysUserPO.getAccountnonexpired() );
        loginUserInfo.setAccountnonlocked( sysUserPO.getAccountnonlocked() );
        loginUserInfo.setCredentialsnonexpired( sysUserPO.getCredentialsnonexpired() );

        return loginUserInfo;
    }
}
