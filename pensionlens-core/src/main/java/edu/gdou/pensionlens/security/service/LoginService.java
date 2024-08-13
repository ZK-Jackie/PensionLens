package edu.gdou.pensionlens.security.service;

import edu.gdou.pensionlens.pojo.Result;
import edu.gdou.pensionlens.pojo.SysUser;

public interface LoginService {

    Result login(SysUser user);

    Result logout();
}
