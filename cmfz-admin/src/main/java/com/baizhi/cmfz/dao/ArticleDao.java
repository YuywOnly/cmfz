package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;

import java.util.List;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-09 10:24
 **/

public interface ArticleDao {

    public Integer insertArticle(Article article);

    public List<Article> selectAllArticle();

}