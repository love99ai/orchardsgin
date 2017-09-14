package com.orchardsign.entity;


import java.io.Serializable;

public class Vadmin implements Serializable {

  private Integer id;
  private Integer permission;
  private String nickname;
  private String uname;
  private String upwd;
  private java.sql.Timestamp createtime;
  private Integer isenable;
  private java.sql.Timestamp logintime;
  private String loginip;
  private String groupname;

  private String phone;

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getPermission() {
    return permission;
  }

  public void setPermission(Integer permission) {
    this.permission = permission;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
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

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }

  public Integer getIsenable() {
    return isenable;
  }

  public void setIsenable(Integer isenable) {
    this.isenable = isenable;
  }

  public java.sql.Timestamp getLogintime() {
    return logintime;
  }

  public void setLogintime(java.sql.Timestamp logintime) {
    this.logintime = logintime;
  }

  public String getLoginip() {
    return loginip;
  }

  public void setLoginip(String loginip) {
    this.loginip = loginip;
  }

  public String getGroupname() {
    return groupname;
  }

  public void setGroupname(String groupname) {
    this.groupname = groupname;
  }
}
