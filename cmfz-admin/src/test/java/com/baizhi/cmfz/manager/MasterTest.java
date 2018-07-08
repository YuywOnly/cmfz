package com.baizhi.cmfz.manager;

import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description: master 上师测试类
 * @author: Yuyiwei
 * @create: 2018-07-07 18:00
 **/

public class MasterTest {
    @Test
    public void selectTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        MasterService masterServiceImpl = (MasterService) context.getBean("masterServiceImpl");

        Map<String, Object> masterMap = masterServiceImpl.showMaster(1, 2);

        for (String k : masterMap.keySet()){
            System.out.println(k+"   "+masterMap.get(k));
        }
    }

    @Test
    public void selectName(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        MasterDao masterDao = (MasterDao) context.getBean("masterDao");

        List<Master> masters = masterDao.selectByName("仁波切",1,2);

        for (Master m:masters ) {
            System.out.println(m);
        }
    }
}