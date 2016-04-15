package com.fatfat.homepage2;

/**
 * Created by user on 2016/4/12.
 */
public class Store {
    private int photo;
    private String name;

    public Store(int photo, String name) {
        this.photo = photo;
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
