package com.wfs.service;



import com.wfs.com.wfs.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CarService {

//    @Autowired
//    @Qualifier(value = "carDaoImpl2")


    @Resource(name = "carDaoImpl2")
    private CarDao carDao;


    public int  delete(){
        System.out.println("delete...");
        carDao.add();
        return 0;
    }

}
