package com.orchardsign.controller.admin;

import com.orchardsign.entity.Admin;
import com.orchardsign.entity.Vadmin;
import com.orchardsign.entity.form.FormAdminLogin;
import com.orchardsign.service.AdminService;
import com.orchardsign.service.RoleRightsService;
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
import org.thymeleaf.util.StringUtils;

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

    @Autowired
    RoleRightsService roleRightsService;

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
    @RequestMapping(value = "/login")
    public String adminLogin(@ModelAttribute("adminForm") @Valid FormAdminLogin admin, BindingResult result, Model model,HttpServletRequest request) throws Exception{
        //表单验证
        if (result.hasErrors()) {
            List<ObjectError> error = result.getAllErrors();
            model.addAttribute("msg",error.get(0).getDefaultMessage());
            return "redirect:/admin";
        }
        //验证码验证
        HttpSession session = request.getSession();
        String sessionCode = (String) session.getAttribute("code");
        if (!StringUtils.equalsIgnoreCase(admin.getCode(), sessionCode)) {  //忽略验证码大小写
            model.addAttribute("msg","验证码错误");
            return "redirect:/admin";
        }
        //登录信息
        UtilJson utilJson =  adminService.adminLogin(admin.getUname(),admin.getUpwd());
        if (utilJson.getCode() == 200){
            //登录成功、、将登录信息保存到session
            session.setAttribute("admin",utilJson.getObj());
            return "redirect:/admin/index";
        }else {
            //登录失败
            model.addAttribute("msg",utilJson.getMsg());
            return "redirect:/admin";
        }
    }
    //管理员首页
    @RequestMapping(value = "/index")
    public String adminIndex( Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Vadmin admin = (Vadmin) session.getAttribute("admin");
        if (admin == null){//登录过期
            return "redirect:/admin";
        }

        model.addAttribute("roleRights",roleRightsService.selectRole(0, admin.getPermission()));
        model.addAttribute("admin", admin);
        return "admin/index";
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

    /**管理员欢迎界面**/
    @RequestMapping(value="/welcome")
    public String welcome(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        model.addAttribute("admin", session.getAttribute("admin"));
//        model.addAttribute("adminForm",new FormAdminLogin());
//        logger.debug("---admin");
        return "admin/welcome";
    }
    /**商家列表**/
    @RequestMapping(value="/business")
    public String businessList(Model model,HttpServletRequest request){
        model.addAttribute("businessList", adminService.selectBusiness());
        return "admin/business-list";

    }

    /**管理员启用\禁用**/
    @RequestMapping(value="/isEnable")
    public String isEnable(@RequestParam("objectid") int id,@RequestParam("isEnable") int isEnable, HttpServletResponse response) throws Exception{
        Admin admin = new Admin();
        admin.setId(id);
        admin.setIsenable(isEnable);
        int result = adminService.updateByPrimaryKeySelective(admin);
        if (result>0){
            response.getWriter().write("success");
        }else {
            response.getWriter().write("fail");
        }
        return null;
    }



}