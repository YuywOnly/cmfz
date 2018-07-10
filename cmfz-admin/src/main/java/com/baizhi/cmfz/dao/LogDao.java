package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-09 21:43
 **/

public interface LogDao {

    public List<Log> selectAllLog(@Param("nowRow")Integer nowRow, @Param("pageSize") Integer pageSize);

    public Integer totalCount();

    public Integer insertLog(Log log);
}