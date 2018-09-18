package com.example.nishida.transitiontest;

import android.graphics.Bitmap;

public class ListImageViewItem {

    private int imageId;
    private String text;
    private Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
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
