package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-05 20:47
 **/

@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    @Override
    public Map<String, Object> showPictureByPage(Integer nowPage, Integer pageSize) {
        Integer begin = (nowPage - 1) * pageSize;
        List<Picture> pictures = pictureDao.selectPicture(begin, pageSize);
        Integer count = pictureDao.totalCount();

        Map<String, Object> pictureMap = new HashMap<String, Object>();
        pictureMap.put("total", count);
        pictureMap.put("rows", pictures);
        return pictureMap;
    }

    @Override
    public Picture queryPictureById(String pictureId) {
        Picture picture = pictureDao.selectById(pictureId);
        return picture;
    }

    @Override
    public boolean addPicture(Picture picture) {
        String addressId = UUID.randomUUID().toString().replace("-", "");
        picture.setPictureId(addressId);

        Date date = new Date();
        picture.setPictureDate(date);

        Integer result = pictureDao.insertPicture(picture);
        if(result>0){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean modifyPicture(Picture picture) {
        Integer result = pictureDao.updatePicture(picture);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean removePicture(String pictureId) {
        Integer result = pictureDao.deletePicture(pictureId);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }
}