package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: cmfz
 * @description: ...
 * @author: Yuyiwei
 * @create: 2018-07-05 13:26
 **/

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> showMenu() {
        return menuDao.selectMenu();
    }
}