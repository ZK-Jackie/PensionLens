package edu.gdou.pensionlens.security.service;

import org.superdata.medismart.common.ResponseResult;
import org.superdata.medismart.entity.SysUser;

public interface LoginService {

    ResponseResult login(SysUser user);

    ResponseResult logout();
}
