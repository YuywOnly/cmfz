package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cmfz
 * @description: Manager DAO层
 * @author: Yuyiwei
 * @create: 2018-07-04 15:42
 **/
public interface ManagerDao {

  /**
  * @Description: 根据ID查询manager 
  * @Param: [managerId] 
  * @return: com.baizhi.cmfz.entity.Manager 
  * @Author: Yuyiwei
  * @Date: 2018/7/4 
  */
    public Manager selectManager(@Param("managerName") String managerName);
}

