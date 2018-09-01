package com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects;
import android.util.Log;
import android.widget.ImageView;
/**
 * Created by uri pc on 18/08/2017.
 */

public class Money {

    private int value;
    private ImageView image_view;
    private float initial_location_x;
    private float initial_location_y;

    public Money(int Value, ImageView pic)
    {
        this.value = Value;
        this.image_view = pic;
        this.initial_location_x = 0;
        this.initial_location_y = 0;
    }

    public int get_value()
    {
        return value;
    }

    public ImageView get_image()
    {
        return image_view;
    }

    public float get_default_X()
    {
        return initial_location_x;
    }
    public float get_default_Y()
    {
        return initial_location_y;
    }

    public void set_default_X(float x)
    {
        initial_location_x = x;
    }
    public void set_default_Y(float y)
    {
        initial_location_y = y;
    }



}
