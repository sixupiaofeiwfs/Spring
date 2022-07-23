package com.wfs.pojo;

public class Grade {
    private String name;
    private int count;

    public Grade(String name, int count) {
        this.name = name;
        this.count = count;
    }


    @Override
    public String toString() {
        return "Grade{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
