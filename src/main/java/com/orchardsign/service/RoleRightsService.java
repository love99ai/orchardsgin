package com.orchardsign.service;


import java.util.ArrayList;
import java.util.Map;

/**
 * @author zhaomaohui
 * @ClassName: RoleRightsService
 * @Description: 权限管理
 * @date 2017/9/12
 */
public interface RoleRightsService {

    /**查询角色权限**/
    ArrayList<Map<String,Object>> selectRole(int  parentId, int roleid);

}
