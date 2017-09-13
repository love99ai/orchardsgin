package com.orchardsign.dao;

import com.orchardsign.entity.RoleRights;
import com.orchardsign.entity.VRroleRights;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface RoleRightsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleRights record);

    int insertSelective(RoleRights record);

    RoleRights selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleRights record);

    int updateByPrimaryKey(RoleRights record);

    /**根据父ID与管理组查询权限集合**/
    ArrayList<VRroleRights> selectRole(@Param("parentId") int parentId,@Param("roleid")int roleid);
}