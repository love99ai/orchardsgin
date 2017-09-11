package com.orchardsign.util;


import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaomaohui
 * @ClassName: UtilJson
 * @Description: json 接口拼装
 * @date 2017/9/4
 */
public class UtilJson {


    private int code;
    private String msg;
    private Object obj;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getJson(){

        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        map.put("data",obj);
        Gson gson = new Gson();
//        System.out.print(gson.toJson(map));
        return gson.toJson(map);

    }

    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        map.put("data",obj);
        return map;
    }


}
