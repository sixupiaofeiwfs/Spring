package com.wfs.service;

import com.wfs.com.wfs.dao.DogDao;

public class DogService {


    private DogDao dogDao;

    public void setDogDao(DogDao dogDao) {
        this.dogDao = dogDao;
    }

    public void add(){
        System.out.println("add.....");
        dogDao.delete();
    }
}
