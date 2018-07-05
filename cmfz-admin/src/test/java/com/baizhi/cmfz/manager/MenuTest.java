package com.baizhi.cmfz.manager;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @program: cmfz
 * @description: menu测试类
 * @author: Yuyiwei
 * @create: 2018-07-05 12:07
 **/

public class MenuTest {

    @Test
    public void DaoTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");

        MenuDao menuDao = (MenuDao) context.getBean("menuDao");

        List<Menu> menus = menuDao.selectMenu();

        for (Menu menu : menus ) {
            System.out.println(menu);
        }
    }


}