package com.orchardsign.service.impl;

import com.google.gson.Gson;
import com.orchardsign.dao.RoleRightsMapper;
import com.orchardsign.entity.VRroleRights;
import com.orchardsign.service.RoleRightsService;
import com.orchardsign.util.UtilJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaomaohui
 * @ClassName: RoleRightsServiceImpl
 * @Description:
 * @date 2017/9/12
 */
@Service
public class RoleRightsServiceImpl implements RoleRightsService {

    @Autowired
    RoleRightsMapper roleRightsMapper;


    @Override
    public ArrayList<Map<String,Object>> selectRole(int parentId, int roleid) {
        ArrayList<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = null;
        ArrayList<VRroleRights> parentRoleRights = roleRightsMapper.selectRole(parentId,roleid);
        for (VRroleRights vRroleRights:parentRoleRights) {
            map = new HashMap<>();
            map.put("parentRrole",vRroleRights);
            map.put("childRrole",roleRightsMapper.selectRole(vRroleRights.getId(),roleid));
            list.add(map);
        }
        return list;
    }
}
