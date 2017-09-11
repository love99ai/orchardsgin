package com.orchardsign.service;

import com.orchardsign.entity.Vadmin;
import com.orchardsign.util.UtilJson;

/**
 * @author zhaomaohui
 * @ClassName: AdminService
 * @Description: 管理员信息
 * @date 2017/9/7
 */
public interface AdminService {



    UtilJson adminLogin(String uName, String uPwd);

}
