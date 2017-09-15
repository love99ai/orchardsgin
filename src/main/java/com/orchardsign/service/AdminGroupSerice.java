package com.orchardsign.service;

import com.orchardsign.entity.AdminGroup;

import java.util.ArrayList;

/**
 * @author zhaomaohui
 * @ClassName: AdminService
 * @Description: 管理员分组信息
 * @date 2017/9/7
 */
public interface AdminGroupSerice {

    /**查询所有分组（除商家）**/
    ArrayList<AdminGroup> selectAll();

    /**查询角色信息**/
    AdminGroup selectByPrimaryKey(Integer id);

    /**添加角色|修改角色**/
    int insertSelective(AdminGroup adminGroup);
//    /**修改角色**/
//    int updateByPrimaryKeySelective(AdminGroup adminGroup);

    /**删除角色**/
    int deleteFromPrimaryKey(String ids);
}
