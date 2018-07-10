package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;

import java.util.Map;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-09 21:46
 **/

public interface LogService {

    public Map<String, Object> showLogByPage(Integer nowPage, Integer pageSize);

    public boolean addLog(Log log);
}