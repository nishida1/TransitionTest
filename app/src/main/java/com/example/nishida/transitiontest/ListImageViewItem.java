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
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

}
