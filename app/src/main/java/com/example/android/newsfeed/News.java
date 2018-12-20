package com.example.android.newsfeed;

import android.graphics.Bitmap;

/** Created by Bobby Reay 12/14/2018 **/

/** Class to define getter methods for NewsAdapter.java **/

public class News {

    private String mTitle;
    private Bitmap mNewsImage;
    private String mNewsArticle;
    private String mSource;

    public News (String title, String source, Bitmap newsImage, String newsArticle){
        mTitle = title;
        mSource = source;
        mNewsImage = newsImage;
        mNewsArticle = newsArticle;
    }

    public News (Bitmap newsImage, String title, String source){
        mNewsImage = newsImage;
        mTitle = title;
        mSource = source;
    }


    public String getTitle() {
        return mTitle;
    }

    public String getSource() {
        return mSource;
    }

    public Bitmap getNewsImage() {
        return mNewsImage;
    }

    public String getNewsArticle() {
        return mNewsArticle;
    }
}
