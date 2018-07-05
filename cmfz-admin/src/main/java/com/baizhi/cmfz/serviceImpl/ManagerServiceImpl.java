package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: cmfz
 * @description: Manager业务层实现类
 * @author: Yuyiwei
 * @create: 2018-07-04 16:09
 **/

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public Manager login(String managerName, String managerPwd) {

        Manager manager = managerDao.selectManager(managerName);

        String password = EncryptionUtils.encryptions(manager.getManagerSalt()+managerPwd);

        if(manager != null && password.equals(manager.getManagerPassword())){
            return manager;
        }

        return null;
    }
}