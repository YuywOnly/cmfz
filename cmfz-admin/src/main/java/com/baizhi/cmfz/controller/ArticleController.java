package com.baizhi.cmfz.controller;

import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-09 10:05
 **/

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/upload",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String uploadImg(@RequestParam("files")MultipartFile[] files, HttpServletRequest request){

        RichTextResult result = new RichTextResult();
        ArrayList<String> data = new ArrayList<String>();
        try {
            String realPath = request.getRealPath("");
            String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\"))+"\\upload\\article";
            if(files != null && files.length != 0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath+"\\"+fileName));

                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    data.add(request.getContextPath()+"/upload/"+fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return JSON.toJSONString(result);
    }


    @RequestMapping(value = "/createArticle",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String createArticle(String p1, Article article){
        System.out.println(article+"----------------------");
        System.out.println(p1+"---------------------------");

        article.setArticleContent(p1);
        Boolean b = articleService.addArticle(article);
        System.out.println(b+"-----------------------");

        return b+"";

    }

    @RequestMapping(value = "/showArticle",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String showArticle(){
        List<Article> articles = articleService.showAll();
        System.out.println("==============================="
        );
        System.out.println(articles);
        return JSON.toJSONString(articles);
    }

}