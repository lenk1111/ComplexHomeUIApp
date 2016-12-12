package com.lenk.complex.home.entity;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liling on 2016/12/12.
 */

public class Category {

    List<String> pagerPicUrl = new ArrayList<>();

    @NonNull
    public String text;

    public Category(@NonNull final String text) {
        this.text = text;
    }

    public List<String> getPagerPicUrl() {
        return pagerPicUrl;
    }

    public void setPagerPicUrl(List<String> pagerPicUrl) {
        this.pagerPicUrl = pagerPicUrl;
    }
}