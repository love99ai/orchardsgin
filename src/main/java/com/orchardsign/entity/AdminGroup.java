package com.orchardsign.entity;

public class AdminGroup {
    private Integer id;

    private String groupname;

    private String groupmsg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    public String getGroupmsg() {
        return groupmsg;
    }

    public void setGroupmsg(String groupmsg) {
        this.groupmsg = groupmsg == null ? null : groupmsg.trim();
    }
}