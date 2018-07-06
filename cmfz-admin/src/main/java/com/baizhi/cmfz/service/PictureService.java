package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-05 20:46
 **/

public interface PictureService {

    public Map<String, Object> showPictureByPage(Integer nowPage, Integer pageSize);

    public Picture queryPictureById(String pictureId);

    public boolean addPicture(Picture picture);

    public boolean modifyPicture(Picture picture);

    public boolean removePicture(String pictureId);
}