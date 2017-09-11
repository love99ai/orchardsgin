package com.orchardsign.dao;

import com.orchardsign.entity.Admin;
import com.orchardsign.entity.Vadmin;
import org.apache.ibatis.annotations.Param;


public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin findByName(String uName);

//    @Select("select * from v_admin where uName = #{uName} and uPwd = #{uPwd}")
    Vadmin adminLogin(@Param("uName") String uName,@Param("uPwd") String uPwd);
}