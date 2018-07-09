package com.baizhi.cmfz.entity;


import java.util.Date;

public class Article {

    private String articleId;
    private String articleName;
    private String masterId;
    private String masterName;
    private String articleContent;
    private Date articleDate;
    private String articleStatus;

    public Article() {
    }

    public Article(String articleId, String articleName, String masterId, String masterName, String articleContent, Date articleDate, String articleStatus) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.masterId = masterId;
        this.masterName = masterName;
        this.articleContent = articleContent;
        this.articleDate = articleDate;
        this.articleStatus = articleStatus;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", masterId='" + masterId + '\'' +
                ", masterName='" + masterName + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleDate=" + articleDate +
                ", articleStatus='" + articleStatus + '\'' +
                '}';
    }
}
