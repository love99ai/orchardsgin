package com.orchardsign.entity;

public class VRroleRights {
  private Integer id;
  private Integer roleid;
  private String name;
  private String action;
  private String description;
  private Integer parentid;
  private Integer indexs;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getRoleid() {
    return roleid;
  }

  public void setRoleid(Integer roleid) {
    this.roleid = roleid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getParentid() {
    return parentid;
  }

  public void setParentid(Integer parentid) {
    this.parentid = parentid;
  }

  public Integer getIndexs() {
    return indexs;
  }

  public void setIndexs(Integer indexs) {
    this.indexs = indexs;
  }
}
