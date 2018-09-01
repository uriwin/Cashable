package com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects;

import android.widget.ImageView;

/**
 * Created by uri pc on 18/08/2017.
 */

public class CashRegister {

    private int sum;
    private ImageView image_view;
    private boolean accessible;

    public CashRegister(ImageView pic) {
        this.sum = 0;
        this.image_view = pic;
        this.accessible = true;

    }


    public void add_money(int money_added) {
        sum += money_added;
    }

    public void reset_sum() {
        sum = 0;
    }

    public ImageView getImage_view() {
        return image_view;
    }

    public int get_sum() {
        return sum;
    }

    public void set_accessible(boolean is_accessible) {
        accessible = is_accessible;
    }

    public boolean get_accessible() {
        return accessible;
    }


}
