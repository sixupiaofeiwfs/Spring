package com.wfs.com.wfs.dao;

import org.springframework.stereotype.Component;

@Component(value = "carDaoImpl2")
public class CarDaoImpl2 implements CarDao{

    @Override
    public void add() {
        System.out.println("add2....");
    }
}
