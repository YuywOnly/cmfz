package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cmfz
 * @description: Manager业务层 接口
 * @author: Yuyiwei
 * @create: 2018-07-04 16:06
 **/


public interface ManagerService {

    public Manager login(String managerName, String managerPwd);
}