package com.baizhi.cmfz.manager;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-05 20:36
 **/

public class PictureTest {

    @Test
    public void selectTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

//        PictureDao pictureDao = (PictureDao) context.getBean("pictureDao");
//
//        List<Picture> pictures = pictureDao.selectPicture(0, 3);
//        Integer integer = pictureDao.totalCount();
//
        PictureService pictureServiceImpl = (PictureService) context.getBean("pictureServiceImpl");

        Map<String, Object> stringObjectMap = pictureServiceImpl.showPictureByPage(1, 3);


        for (String p: stringObjectMap.keySet()  ) {
            System.out.println(p+"   "+stringObjectMap.get(p));
        }

//        System.out.println(integer);
//        for (Picture p: pictures ) {
//            System.out.println(p);
//        }


    }


    @Test
    public void addTest(){
        Picture picture = new Picture();
        String path = "38.jpg";
        String des = "图片";
        Integer status = 0;
        picture.setPicturePath(path);
        picture.setPictureDescription(des);
        picture.setPictureStatus(status);
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        PictureService pictureServiceImpl = (PictureService) context.getBean("pictureServiceImpl");
        boolean b = pictureServiceImpl.addPicture(picture);
//        System.out.println(b);


    }

    @Test
    public void deleteTest(){
        String id = "d80135aa6f244208b27e75726f6f089e";
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        PictureService pictureServiceImpl = (PictureService) context.getBean("pictureServiceImpl");
        boolean b = pictureServiceImpl.removePicture(id);
        System.out.println(b);

    }

    @Test
    public void updatePivture(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        PictureService pictureServiceImpl = (PictureService) context.getBean("pictureServiceImpl");
        Picture picture = pictureServiceImpl.queryPictureById("2");
        System.out.println(picture);

        picture.setPictureDescription("藏传佛教");
        boolean b = pictureServiceImpl.modifyPicture(picture);
        System.out.println(b);


    }


}