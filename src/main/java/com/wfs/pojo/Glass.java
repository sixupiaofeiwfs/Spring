package com.wfs.pojo;

//杯子类
public class Glass {

    private Lid lid;

    public void setLid(Lid lid) {
        this.lid = lid;
    }


    @Override
    public String toString() {
        return "Glass{" +
                "lid=" + lid +
                '}';
    }
}
