package com.example.afiq.app_basic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by afiq on 1/15/18.
 */

class   Adapterhewan extends BaseAdapter{

    private String[] namahewan;
    private Integer[] gambarhewan;
    Context tempatTampil;
    public Adapterhewan(CustumActivity custumActivity, String[] namahewan, Integer[] gambarhewan) {
        this.namahewan = namahewan;
        this.gambarhewan = gambarhewan;
        tempatTampil = custumActivity;

    }

    @Override
    public int getCount() {
        return namahewan.length; // seluruh item di vaariable nama
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // memasukan layout item ke dalam custom activity
        View tampilan_item = LayoutInflater.from(tempatTampil).inflate(R.layout.item, null);
        TextView txtitem = (TextView) tampilan_item.findViewById(R.id.txt_item);
        ImageView imgitem = (ImageView) tampilan_item.findViewById(R.id.btnimageview);
        txtitem.setText(namahewan[position]);
        imgitem.setImageResource(gambarhewan[position]);
        //ta,pilkan listview
        return tampilan_item;
    }
}
