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
}
