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
}
