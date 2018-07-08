package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Master;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cmfz
 * @description: 上师
 * @author: Yuyiwei
 * @create: 2018-07-07 16:49
 **/

public interface MasterDao {
    public List<Master> selectMaster(@Param("nowRow")Integer nowRow, @Param("pageSize") Integer pageSize);

    public Master selectById(@Param("masterId") String masterId);

    public Integer totalCount();

    public Integer insertMaster(Master master);

    public Integer updateMaster(Master master);

    public Integer deleteMaster(@Param("masterId") String masterId);

    public List<Master> selectByName(@Param("masterName") String masterName,@Param("nowRow")Integer nowRow, @Param("pageSize") Integer pageSize);

    public Integer selectByNameCount(@Param("masterName") String masterName);
}