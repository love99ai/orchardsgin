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
    ArrayList<Vadmin> selectBusiness(String nickName);

    /**修改管理员**/
    int updateByPrimaryKeySelective(Admin admin);

    /**跟进ID查询管理员**/
    Admin selectByPrimaryKey(Integer id);

    /**添加管理员**/
    int insertSelective(Admin admin);

    /**删除管理员**/
    int deleteFromPrimaryKey(String ids);

    /**查询管理员列表**/
    ArrayList<Vadmin> selectAdmin(String nickName);


}
