package com.example.afiq.app_basic;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by afiq on 2/1/18.
 */

class HewanpagerAdapter
extends PagerAdapter {
    String[] judul;
    String[] deskripsihewan;
    Integer[] gambarhewan;
    Context temapatTampil;

    public HewanpagerAdapter(pagerActivity pagerActivity, String[] detail, String[] judul, Integer[] gambar, DetailHewan detailHewan) {

        this.judul = judul;
        this.gambarhewan = gambar;
        deskripsihewan = detail;
        temapatTampil = pagerActivity;
    }

    @Override
    public int getCount() {
        return judul.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ScrollView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View tampilan = LayoutInflater.from(temapatTampil).inflate(R.layout.itempager
                , container, false);
        TextView itemjudul = (TextView) tampilan.findViewById(R.id.txtpgnamahewan);
        TextView itemdeskripsi= (TextView) tampilan.findViewById(R.id.txtpgketerangan);
        ImageView itemgambar =  (ImageView) tampilan.findViewById(R.id.imgpghewan);

        itemjudul.setText(judul[position]);
        itemdeskripsi.setText(deskripsihewan[position]);
        itemgambar.setImageResource(gambarhewan[position]);

        ((ViewPager)container).addView(tampilan);
        return tampilan;

    }
    @Override
    public void destroyItem(ViewGroup container,int position, Object object){
        ((ViewPager)container).removeView((ScrollView) object);
}


}
