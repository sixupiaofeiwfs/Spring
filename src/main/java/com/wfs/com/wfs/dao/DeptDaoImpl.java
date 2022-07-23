package com.wfs.com.wfs.dao;

public class DeptDaoImpl implements DeptDao{

    @Override
    public int add(int a, int b) {
        System.out.println("开始执行add方法");
        return a+b;
    }

    @Override
    public String query(String id) {
        return id;
    }
}
