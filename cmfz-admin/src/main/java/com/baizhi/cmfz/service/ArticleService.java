package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.List;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-09 10:28
 **/

public interface ArticleService {

    public Boolean addArticle(Article article);

    public List<Article> showAll();
}