package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-05 20:29
 **/

public interface PictureDao {

    public List<Picture> selectPicture(@Param("nowRow")Integer nowRow, @Param("pageSize") Integer pageSize);

    public Picture selectById(@Param("pictureId") String pictureId);

    public Integer totalCount();

    public Integer insertPicture(Picture picture);

    public Integer updatePicture(Picture picture);

    public Integer deletePicture(@Param("pictureId") String pictureId);
}