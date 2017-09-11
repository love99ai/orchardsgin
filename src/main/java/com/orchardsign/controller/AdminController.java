package com.orchardsign.controller;

import com.orchardsign.entity.form.FormAdminLogin;
import com.orchardsign.service.AdminService;
import com.orchardsign.util.UtilJson;
import com.orchardsign.util.ValidateCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


/**
 * @author zhaomaohui
 * @ClassName: AdminController
 * @Description:
 * @date 2017/9/7
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/admin" )
public class AdminController {

    protected static Logger logger= LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AdminService adminService;

    /**
     * 进入后台登录
     * @param model
     * @return
     */
    @RequestMapping
    public String admin(Model model){
        model.addAttribute("adminForm",new FormAdminLogin());
        logger.debug("---admin");
        return "admin/login";
    }

    /**
     * 管理员登录
     * @param admin
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String adminLogin(@ModelAttribute("adminForm") @Valid FormAdminLogin admin, BindingResult result, Model model){

        if (result.hasErrors()) {
            List<ObjectError> error = result.getAllErrors();
            model.addAttribute("msg",error.get(0).getDefaultMessage());
            return "admin/login";
        }
        UtilJson utilJson =  adminService.adminLogin(admin.getUname(),admin.getUpwd());

        if (utilJson.getCode() == 200){
            model.addAttribute("admin",utilJson.getObj());
            return "admin/index";
        }else {
            model.addAttribute("msg",utilJson.getMsg());
            return "admin/login";
        }
    }

    /**
     * 响应验证码页面
     * @return
     */
    @RequestMapping(value="/validateCode")
    public String validateCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();

        ValidateCode vCode = new ValidateCode(120,40,5,100);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
        return null;
    }

}
