package com.example.bikebuddy;

public class Bikeinput {
    private String name;
    private int engine;
    private int thumbnail;

    public Bikeinput(){}

    public Bikeinput(String name, int engine, int thumbnail) {
        this.name = name;
        this.engine = engine;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
