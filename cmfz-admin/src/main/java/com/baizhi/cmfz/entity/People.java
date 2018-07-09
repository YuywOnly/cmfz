package com.baizhi.cmfz.entity;

/**
 * @program: cmfz
 * @description:
 * @author: Yuyiwei
 * @create: 2018-07-09 20:37
 **/

public class People {

    private String name;
    private Integer value;

    public People() {
    }

    public People(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}