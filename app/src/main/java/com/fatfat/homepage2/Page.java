package com.fatfat.homepage2;

import android.support.v4.app.Fragment;

/**
 * Created by cuser on 2016/4/15.
 */
public class Page {
    private Fragment fragment;
    private String title;

    public Page(Fragment fragment, String title) {
        this.title = title;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
