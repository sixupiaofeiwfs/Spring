package com.wfs.pojo;

public class Student {


    private String name;

    public void setName(String name) {
        this.name = name;
        System.out.println("这里调用了Student中setName方法");
    }

    public void add(){
        System.out.println("add......");
    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                '}';
//    }


    public Student() {
        System.out.println("这里调用了Student的无参构造方法");
    }




    public void init(){
        System.out.println("这里调用了Student的初始化方法");
    }

    public void destory(){
        System.out.println("这里调用了Student的销毁方法");
    }
}
