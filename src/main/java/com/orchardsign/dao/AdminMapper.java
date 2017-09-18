package com.orchardsign.dao;

import com.orchardsign.entity.Admin;
import com.orchardsign.entity.Vadmin;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin findByName(String uName);

    /**用户登录信息**/
    Vadmin adminLogin(@Param("uName") String uName,@Param("uPwd") String uPwd);
    /**跟进昵称查询商家列表**/
    ArrayList<Vadmin>  selectBusiness(@RequestParam("nickname") String nickname);

    /**跟进昵称查询管理员列表**/
    ArrayList<Vadmin> selectAdmin(@RequestParam("nickname") String nickname);

}