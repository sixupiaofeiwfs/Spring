package com.wfs.pojo;

public class Wheel {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "name='" + name + '\'' +
                '}';
    }
}
