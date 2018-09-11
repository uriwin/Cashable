package com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

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


    public void add_money(int money_to_add, TextView cash_register_view) {
        sum += money_to_add;
        Log.d("Cash Register Event", "entered to the cache register : " + String.valueOf(money_to_add) + " money");
        Log.d("Cash Register Event", "cache register have: " + String.valueOf(sum) + " money");

        cash_register_view.setText(String.valueOf(sum));
        set_accessible(false);

    }

    public void reset_sum() {
        sum = 0;
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

    public boolean money_in_bounds_of_CashRegister(ImageView image) {
        int cash_register_X_left = image_view.getLeft();
        int cash_register_Y_up = image_view.getTop();
        int cash_register_Y_down = (image_view.getTop() + image_view.getHeight());
        int cash_register_X_right = (image_view.getLeft() + image_view.getWidth());

        int centre_X_of_image = (int) (image.getX() + image.getWidth() / 2);
        int centre_Y_of_image = (int) (image.getY() + image.getHeight() / 2);

        if (cash_register_X_left < centre_X_of_image && centre_X_of_image < cash_register_X_right && cash_register_Y_up < centre_Y_of_image && cash_register_Y_down > centre_Y_of_image)
            return true;
        else if (cash_register_Y_up < (image.getY() + +image.getHeight()))
            return true;
        return false;
    }

    public void reset_cash_register(ImageButton reset_button, final TextView cash_register_view) {

        reset_button.setOnClickListener(v -> {
            reset_sum();
            cash_register_view.setText(String.valueOf(get_sum()));
        });
    }


}
