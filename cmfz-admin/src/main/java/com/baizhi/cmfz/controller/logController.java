package com.baizhi.cmfz.controller;

import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-09 22:08
 **/

@Controller
@RequestMapping("/log")
public class logController {

    @Autowired
    private LogService logService;

    @RequestMapping(value = "/showLog",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String showAll(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize){

        Map<String, Object> logtMap = logService.showLogByPage(nowPage, pageSize);
        return JSON.toJSONString(logtMap);
    }

}