package com.orchardsign.controller.admin;

import com.google.gson.Gson;
import com.orchardsign.entity.Admin;
import com.orchardsign.entity.AdminGroup;
import com.orchardsign.entity.form.FormAdminLogin;
import com.orchardsign.service.AdminGroupSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhaomaohui
 * @ClassName: AdminGroupController
 * @Description: 管理员角色
 * @date 2017/9/15
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/admin" )
public class AdminGroupController {

    @Autowired
    AdminGroupSerice adminGroupSerice;

    /**角色数据列表**/
    @RequestMapping(value = "/groupList")
    public String admin(Model model){
        model.addAttribute("groupList",adminGroupSerice.selectAll());
        return "admin/admin-group";
    }

    /**添加修改角色初始化**/
    @RequestMapping(value = "/addGroupInit")
    public String addGroupInit(Model model,HttpServletRequest request){

        if (request.getParameter("id") == null || request.getParameter("id").equals("")){
            model.addAttribute("adminGroup",new AdminGroup());
        }else {
            model.addAttribute("adminGroup", adminGroupSerice.selectByPrimaryKey( Integer.parseInt(request.getParameter("id") )));
        }

        return "admin/admin-group-add";
    }

    /****
     * 添加/修改
     * @param adminGroup
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addGroup")
    public String addGroup(@ModelAttribute("adminGroup") AdminGroup adminGroup, HttpServletResponse response)throws Exception {

        Gson gson = new Gson();
        int result = adminGroupSerice.insertSelective(adminGroup);

        if (result > 0) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("fail");
        }

        return null;
    }

    @RequestMapping(value = "/delGroup")
    public String delGroup(@RequestParam("ids") String ids, HttpServletResponse response)throws Exception{
        int result = adminGroupSerice.deleteFromPrimaryKey(ids);
        if (result>0){
            response.getWriter().write("success");
        }else {
            response.getWriter().write("fail");
        }
        return null;
    }



}
