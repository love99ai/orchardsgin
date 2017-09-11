package com.orchardsign.service.impl;

import com.orchardsign.entity.Admin;
import com.orchardsign.entity.Vadmin;
import com.orchardsign.dao.AdminMapper;
import com.orchardsign.service.AdminService;
import com.orchardsign.util.UtilJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaomaohui
 * @ClassName: AdminServiceImpl
 * @Description:
 * @date 2017/9/7
 */
@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private AdminMapper adminMapper;

    @Override
    public UtilJson adminLogin(String uName, String uPwd) {
        Vadmin  vadmin= adminMapper.adminLogin(uName,uPwd);
        UtilJson utilJson = new UtilJson();
        if (vadmin == null){
            utilJson.setCode(301);
            Admin  admin = adminMapper.findByName(uName);
            if (admin == null){
                utilJson.setMsg("用户名不存在");
            }else {
                utilJson.setMsg("密码错误");
            }
            utilJson.setObj(admin);
            return utilJson;
        }
        utilJson.setCode(200);
        utilJson.setObj(vadmin);
        utilJson.setMsg("登录成功");
        return utilJson;
    }
}