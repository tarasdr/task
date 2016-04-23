package com.example.taras.task.models;

import android.graphics.drawable.Drawable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by taras on 22.04.2016.
 */
public class Photo {

    private String _date;
    private Drawable _image;

    private static SimpleDateFormat _sdf = new SimpleDateFormat("hh:mm:ss dd.mm.yyyy");

    public  Photo(Drawable image){
        _image = image;
        _date = _sdf.format(new Date());
    }

    public  String getDate() { return _date; }

    public  Drawable getImage() { return _image; }
}
