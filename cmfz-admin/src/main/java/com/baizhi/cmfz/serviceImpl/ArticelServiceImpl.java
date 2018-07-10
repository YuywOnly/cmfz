package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-09 10:29
 **/

@Service
@Transactional
public class ArticelServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public Boolean addArticle(Article article) {
        String articelId = UUID.randomUUID().toString().replace("-", "");
        article.setArticleId(articelId);

        Date date = new Date();
        article.setArticleDate(date);

        Integer integer = articleDao.insertArticle(article);
        if(integer>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public List<Article> showAll() {
        return articleDao.selectAllArticle();
    }
}