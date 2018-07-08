package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Master;

import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-07 16:56
 **/


public interface MasterService {

    public Map<String, Object> showMaster(Integer nowPage, Integer pageSize);

    public Master queryMasterById(String masterId);

    public boolean addMaster(Master master);

    public boolean modifyMaster(Master master);

    public boolean removeMaster(String masterId);

    public Map<String, Object> queryMasterByName(String manterName,Integer nowPage, Integer pageSize);
}