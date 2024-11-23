package com.boss.modelClass;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

public class CoursesModel {
    private String name;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public CoursesModel(String name, int image) {
        this.name = name;
        this.image = image;
    }
}
