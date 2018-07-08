package com.baizhi.cmfz.controller;

import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.MasterService;
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
 * @create: 2018-07-07 18:43
 **/

@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService masterService;

    
    /** 
    * @Description: 显示所有上师信息
    * @Param: [nowPage, pageSize] 
    * @return: java.lang.String 
    * @Author: Yuyiwei
    * @Date: 2018/7/7 
    */
    @RequestMapping(value ="/showMaster",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String showMaster(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize){

        Map<String, Object> masterMap = masterService.showMaster(nowPage, pageSize);

        return JSON.toJSONString(masterMap);
    }


    /**
    * @Description:  根据id查询上师信息，避免脏读
    * @Param: [masterId]
    * @return: java.lang.String
    * @Author: Yuyiwei
    * @Date: 2018/7/7
    */
    @RequestMapping(value ="/queryMaster",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryMaster(String masterId){
        Master master = masterService.queryMasterById(masterId);
        return JSON.toJSONString(master);
    }

    /**
     * @Description: 上传图片到服务器，并将信息添加到数据库
     * @Param: [picture, file, session]
     * @return: java.lang.String
     * @Author: Yuyiwei
     * @Date: 2018/7/7
     */
    @RequestMapping(value = "/addMaster",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addMaster(Master master , MultipartFile file, HttpSession session) throws IOException {

        //获得文件路径
        String realPath = session.getServletContext().getRealPath("/");
        //修改文件路径 将../cmfz-admin 换成 ../upload
        String upload = realPath.replace("cmfz-admin", "upload/master");
        //生成UUID作为文件名
        String pictureId = UUID.randomUUID().toString().replace("-", "");
        //获取文件名
        String oldName = file.getOriginalFilename();
        //截取文件本身的后缀名
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        //拼接文件路径和文件名 上传文件
        file.transferTo(new File(upload + pictureId + suffix ));

        master.setMasterPhoto(pictureId + suffix);
        boolean b = masterService.addMaster(master);

        return b+"";
    }


    /**
     * @Description: 修改上师信息
     * @Param: [picture]
     * @return: java.lang.String
     * @Author: Yuyiwei
     * @Date: 2018/7/7
     */
    @RequestMapping(value = "/modifyMaster",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String modifyMaster(Master master){
        boolean b = masterService.modifyMaster(master);
        return b+"";
    }


    @RequestMapping(value = "/removeMaster",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String removeMaster(String  masterId){
        boolean b = masterService.removeMaster(masterId);
        return b+"";
    }


    /**
     * @Description:  根据name查询上师信息，模糊查询
     * @Param: [masterId]
     * @return: java.lang.String
     * @Author: Yuyiwei
     * @Date: 2018/7/7
     */
    @RequestMapping(value ="/queryMasterByName",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryMasterByName(String masterName,@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize){
        Map<String, Object> masterMap = masterService.queryMasterByName(masterName,nowPage, pageSize);
        return JSON.toJSONString(masterMap);
    }

}
