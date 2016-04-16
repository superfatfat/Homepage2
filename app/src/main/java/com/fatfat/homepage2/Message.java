package com.fatfat.homepage2;

/**
 * Created by user on 2016/4/16.
 */
public class Message {
    private int imageId;
    private String text;

    public Message(int imageId, String text) {
        this.imageId = imageId;
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
