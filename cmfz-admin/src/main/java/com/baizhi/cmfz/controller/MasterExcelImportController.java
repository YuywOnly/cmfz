package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @program: cmfz
 * @description: 上师 Excel批量上传
 * @author: Yuyiwei
 * @create: 2018-07-08 10:01
 **/

@Controller
@RequestMapping("/easypoi")
public class MasterExcelImportController {

    @Autowired
    private MasterService masterService;

    private static final Logger log = LoggerFactory.getLogger(MasterExcelImportController.class);

    @RequestMapping("/excelMaster")
    public String excelImport( MultipartFile file) {
        int resultTotal = 0;
        ImportParams importParams = new ImportParams();
        // 数据处理
        IExcelDataHandler<Master> handler = new MasterExcelHandler();
        handler.setNeedHandlerFields(new String[] { "姓名" });// 注意这里对应的是excel的列名。也就是对象上指定的列名。
        importParams.setDataHandler(handler);

        // 需要验证
        importParams.setNeedVerfiy(true);

        try {
            ExcelImportResult<Master> result = ExcelImportUtil.importExcelMore(file.getInputStream(), Master.class,
                    importParams);

            List<Master> successList = result.getList();
            List<Master> failList = result.getFailList();

            log.info("是否存在验证未通过的数据:" + result.isVerfiyFail());
            log.info("验证通过的数量:" + successList.size());
            log.info("验证未通过的数量:" + failList.size());

            for (Master master : successList) {
                log.info("成功列表信息:" + master);
                System.out.println(master);
                masterService.addMaster(master);

            }
            for (Master master : failList) {
                log.info("失败列表信息:" + master);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        if (resultTotal == 0) {
            return "success";
        } else {
            return "error";
        }
    }
}