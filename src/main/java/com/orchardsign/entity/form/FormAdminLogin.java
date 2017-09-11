package com.orchardsign.entity.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author zhaomaohui
 * @ClassName: FormAdminLogin
 * @Description:
 * @date 2017/9/8
 */
public class FormAdminLogin {

    @NotBlank(message="用户名不能为空")
    private String uname;

    @NotBlank(message="密码不能为空")
    @Length(min=6, message="密码长度不能少于六位")
    private String upwd;

    @NotBlank(message="验证码不能为空")
    private String code;

    public FormAdminLogin(){

    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
