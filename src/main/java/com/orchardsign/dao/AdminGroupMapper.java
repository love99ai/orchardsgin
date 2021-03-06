package com.orchardsign.dao;

import com.orchardsign.entity.AdminGroup;

import java.util.ArrayList;

public interface AdminGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminGroup record);

    int insertSelective(AdminGroup record);

    AdminGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminGroup record);

    int updateByPrimaryKey(AdminGroup record);
    /**查询所有角色不等于商家的**/
    ArrayList<AdminGroup> selectAll();
}