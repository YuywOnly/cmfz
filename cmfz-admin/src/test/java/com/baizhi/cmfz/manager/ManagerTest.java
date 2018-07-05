package com.baizhi.cmfz.manager;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.EncryptionUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: cmfz
 * @description: manager的测试类
 * @author: Yuyiwei
 * @create: 2018-07-04 16:19
 **/

public class ManagerTest {


    @Test
    public void loginTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        ManagerService managerService = (ManagerService) context.getBean("managerServiceImpl");

        Manager manager = managerService.login("张三", "123456");
//        ManagerDao managerDao = (ManagerDao) context.getBean("managerDao");
//        Manager zs = managerDao.selectManager("zs");

        System.out.println(manager);


    }
}