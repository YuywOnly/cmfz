package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-09 21:51
 **/

@Service
@Transactional
public class ServiceImplLog implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public Map<String, Object> showLogByPage(Integer nowPage, Integer pageSize) {
        Integer begin = (nowPage - 1) * pageSize;
        List<Log> logs = logDao.selectAllLog(begin, pageSize);
        Integer count = logDao.totalCount();

        Map<String, Object> pictureMap = new HashMap<String, Object>();
        pictureMap.put("total", count);
        pictureMap.put("rows", logs);
        return pictureMap;
    }

    @Override
    public boolean addLog(Log log) {

        String logId = UUID.randomUUID().toString().replace("-", "");
        log.setLogId(logId);

        Date date = new Date();
        log.setLogTime(date);

        Integer result = logDao.insertLog(log);
        if(result>0){
            return true;
        }else{
            return false;
        }

    }
}