package com.orchardsign.service;

import com.orchardsign.entity.Admin;
import com.orchardsign.entity.Vadmin;
import com.orchardsign.util.UtilJson;

import java.util.ArrayList;

/**
 * @author zhaomaohui
 * @ClassName: AdminService
 * @Description: 管理员信息
 * @date 2017/9/7
 */
public interface AdminService {


    /**用户登录**/
    UtilJson adminLogin(String uName, String uPwd);

    /**查询商家列表**/
    ArrayList<Vadmin> selectBusiness();

    /**修改管理员**/
    int updateByPrimaryKeySelective(Admin admin);


}
