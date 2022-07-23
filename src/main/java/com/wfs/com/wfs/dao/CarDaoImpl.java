package com.wfs.com.wfs.dao;


import org.springframework.stereotype.Component;

@Component(value = "carDaoImpl")
public class CarDaoImpl  implements  CarDao{

    @Override
    public void add() {
        System.out.println("add......");
    }
}
