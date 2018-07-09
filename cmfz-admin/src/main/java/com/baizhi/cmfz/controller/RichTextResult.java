package com.baizhi.cmfz.controller;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-09 10:12
 **/

public class RichTextResult implements Serializable {

    private Integer errno;
    private ArrayList<String> data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

}