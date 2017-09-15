package com.orchardsign.service.impl;

import com.orchardsign.dao.AdminGroupMapper;
import com.orchardsign.entity.AdminGroup;
import com.orchardsign.service.AdminGroupSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author zhaomaohui
 * @ClassName: AdminServiceImpl
 * @Description: 分组信息
 * @date 2017/9/7
 */
@Service
public class AdminGroupServiceImpl implements AdminGroupSerice
{

    @Autowired
    private AdminGroupMapper adminMapper;


    @Override
    public ArrayList<AdminGroup> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public AdminGroup selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(AdminGroup adminGroup) {

        if (adminGroup.getId() == null){
            return adminMapper.insertSelective(adminGroup);
        }else {
            return adminMapper.updateByPrimaryKeySelective(adminGroup);
        }


    }

    @Override
    public int deleteFromPrimaryKey(String ids) {
        String []idArr = ids.split(",");
        int result = 0;
        for (String id:idArr){
            adminMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }

        return result;
    }

//    @Override
//    public int updateByPrimaryKeySelective(AdminGroup adminGroup) {
//        return adminMapper.updateByPrimaryKeySelective(adminGroup);
//    }
}
