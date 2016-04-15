package com.fatfat.homepage2;

/**
 * Created by user on 2016/4/11.
 */
public class News {
    String title;
    int storeId;

    public News(String title, int storeId) {
        this.title = title;
        this.storeId = storeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
