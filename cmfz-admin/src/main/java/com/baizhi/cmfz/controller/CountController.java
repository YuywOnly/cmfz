package com.baizhi.cmfz.controller;

import com.alibaba.fastjson.JSON;

import com.baizhi.cmfz.entity.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-09 15:48
 **/

@Controller
@RequestMapping("/count")
public class CountController {
    @RequestMapping(value = "/manCount",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getp2(){
        List ss=new ArrayList<People>();
        People s = new People("河南", 4);
        People s1 = new People("北京", 4);


        People s2 = new People("天津", 4);

        ss.add(s);
        ss.add(s1);
        ss.add(s2);
        return JSON.toJSONString(ss);
    }
    @RequestMapping(value = "/womanCount",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getp(){
        List ss=new ArrayList<People>();
        People s = new People("河南", 4);
        People s1 = new People("北京", 4);
        People s3 = new People("南京", 5);

        People s2 = new People("天津", 4);

        ss.add(s);
        ss.add(s1);
        ss.add(s2);
        ss.add(s3);
        return JSON.toJSONString(ss);
    }


    @ResponseBody
    @RequestMapping( value = "/analyze",produces = "application/json;charset=utf-8")
    public String getAnalyze() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("intervals",new String[]{"7天","15天","30天","半年","一年"});
        map.put("counts",new int[]{5,10,20,30,40});
        return JSON.toJSONString(map);
    }
}
