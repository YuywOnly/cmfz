package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import com.baizhi.cmfz.entity.Master;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: cmfz
 * @description: 对Excel中要上传的数据进行验证，查询数据库
 *               导入的数据某些信息不能与现有数据库中的数据冲突
 * @author: Yuyiwei
 * @create: 2018-07-08 09:57
 **/

public class MasterExcelHandler extends ExcelDataHandlerDefaultImpl<Master> {
    private static final Logger log = LoggerFactory.getLogger(MasterExcelHandler.class);


    @Override
    public Object importHandler(Master obj, String name, Object value) {
        log.info(name+":"+value);
        return super.importHandler(obj, name, value);
    }
}