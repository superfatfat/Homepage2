package com.fatfat.homepage2;

import java.io.Serializable;

/**
 * Created by cuser on 2016/4/13.
 */
public class Food implements Serializable{
    private int imageId;
    private String title;

    public Food(int imageId, String title) {
        this.imageId = imageId;
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
