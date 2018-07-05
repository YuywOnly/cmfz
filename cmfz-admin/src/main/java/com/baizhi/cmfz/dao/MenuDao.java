package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * @program: cmfz
 * @description: 菜单的dao层
 * @author: Yuyiwei
 * @create: 2018-07-05 11:41
 **/

public interface MenuDao {

    /** 
    * @Description: 查询所有一级二级菜单
    * @Param: [] 
    * @return: java.util.List<com.baizhi.cmfz.entity.Menu> 
    * @Author: Yuyiwei
    * @Date: 2018/7/5 
    */
    public List<Menu> selectMenu();
}