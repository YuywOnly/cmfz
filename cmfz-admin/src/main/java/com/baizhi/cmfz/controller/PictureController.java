package com.baizhi.cmfz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-05 20:50
 **/

@Controller
@RequestMapping("picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;


    /**
    * @Description: 显示所有图片信息
    * @Param: [nowPage, pageSize]
    * @return: java.lang.String
    * @Author: Yuyiwei
    * @Date: 2018/7/6
    */
    @RequestMapping(value ="/showPicture",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String showPicture(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize){
        Map<String, Object> pictureMap = pictureService.showPictureByPage(nowPage, pageSize);
        return JSON.toJSONString(pictureMap);
    }


    /** 
    * @Description: 修改信息前通过 id查询数据库
    * @Param: [pictureId] 
    * @return: java.lang.String 
    * @Author: Yuyiwei
    * @Date: 2018/7/6 
    */
    @RequestMapping(value ="/queryPicture",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryPicture(String pictureId){
        Picture picture = pictureService.queryPictureById(pictureId);
        return JSON.toJSONString(picture);
    }




    /**
    * @Description: 上传图片到服务器，并将信息添加到数据库
    * @Param: [picture, file, session]
    * @return: java.lang.String
    * @Author: Yuyiwei
    * @Date: 2018/7/6
    */
    @RequestMapping(value = "/addPicture",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addPicture(Picture picture , MultipartFile file, HttpSession session) throws IOException {

        //获得文件路径
        String realPath = session.getServletContext().getRealPath("/");
        //修改文件路径 将../cmfz-admin 换成 ../upload
        String upload = realPath.replace("cmfz-admin", "upload/picture");
        //生成UUID作为文件名
        String pictureId = UUID.randomUUID().toString().replace("-", "");
        //获取文件名
        String oldName = file.getOriginalFilename();
        //截取文件本身的后缀名
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        //拼接文件路径和文件名 上传文件
        file.transferTo(new File(upload + pictureId + suffix ));

        picture.setPicturePath(pictureId + suffix);
        boolean b = pictureService.addPicture(picture);


        System.out.println(upload + pictureId + suffix);

        return b+"";
    }


    /** 
    * @Description: 修改图片信息
    * @Param: [picture] 
    * @return: java.lang.String 
    * @Author: Yuyiwei
    * @Date: 2018/7/6 
    */
    @RequestMapping(value = "/modifyPicture",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String modifyPicture(String pictureId, String pictureDescription, long pictureStatus){
        Picture picture = new Picture(pictureId, pictureDescription, pictureStatus);
        boolean b = pictureService.modifyPicture(picture);
        return b+"";
    }

    @RequestMapping(value = "/removePicture",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String removePicture(String  pictureId){
        boolean b = pictureService.removePicture(pictureId);
        return b+"";
    }
}