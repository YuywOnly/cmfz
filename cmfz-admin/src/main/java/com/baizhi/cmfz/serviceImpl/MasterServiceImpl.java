package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-07 16:57
 **/

@Service
@Transactional
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterDao masterDao;

    @Override
    public Map<String, Object> showMaster(Integer nowPage, Integer pageSize) {
        Integer begin = (nowPage - 1) * pageSize;
        List<Master> masters = masterDao.selectMaster(begin, pageSize);
        Integer count = masterDao.totalCount();

        Map<String, Object> pictureMap = new HashMap<String, Object>();
        pictureMap.put("total", count);
        pictureMap.put("rows", masters);
        return pictureMap;
    }

    @Override
    public Master queryMasterById(String masterId) {
        return masterDao.selectById(masterId);
    }

    @Override
    public boolean addMaster(Master master) {
        String masterId = UUID.randomUUID().toString().replace("-", "");
        master.setMasterId(masterId);

        Integer result = masterDao.insertMaster(master);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean modifyMaster(Master master) {
        Integer result = masterDao.updateMaster(master);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean removeMaster(String masterId) {
        Integer result = masterDao.deleteMaster(masterId);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Map<String, Object> queryMasterByName(String masterName,Integer nowPage, Integer pageSize) {
        Integer begin = (nowPage - 1) * pageSize;
        List<Master> masters = masterDao.selectByName(masterName, begin, pageSize);
        Integer count = masterDao.selectByNameCount(masterName);

        Map<String, Object> pictureMap = new HashMap<String, Object>();
        pictureMap.put("total", count);
        pictureMap.put("rows", masters);
        return pictureMap;
    }
}