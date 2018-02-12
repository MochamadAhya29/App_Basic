package com.example.afiq.app_basic;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class pagerActivity extends AppCompatActivity {

    @BindView(R.id.pagerhewan)
    ViewPager pagerhewan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        ButterKnife.bind(this);
          DetailHewan detailHewan = new DetailHewan();
        String []judul = detailHewan.namahewan;
                String [] detail = detailHewan.detailhewan;
                Integer [] gambar =  detailHewan.gambarhewan;


        HewanpagerAdapter hewandipagerin = new  HewanpagerAdapter(this,detail,judul,gambar,detailHewan);
        pagerhewan.setAdapter(hewandipagerin);
    }
}
