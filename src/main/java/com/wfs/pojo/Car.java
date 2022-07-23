package com.wfs.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Car {
    private String[] array;

    private List<String> list;

    private Map<String,String> map;

    private List<Wheel> lists;


    public void setArray(String[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setLists(List<Wheel> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "Car{" +
                "array=" + Arrays.toString(array) +
                ", list=" + list +
                ", map=" + map +
                ", lists=" + lists +
                '}';
    }
}
