package com.example.afiq.app_basic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class CustumActivity extends AppCompatActivity {
    private ListView lvcustomhewan;

    private String [] namahewan = {
            "kuda"
            , "monyet"
            ,"panda"
            ,"sapi"
            ,"serigala"
            ,"singa"
            ,"ular"
    };

    private Integer [] gambarhewan = {
            R.drawable.kuda
            ,R.drawable.monyet
            ,R.drawable.panda
            ,R.drawable.sapi
            ,R.drawable.serigala
            ,R.drawable.singa
            ,R.drawable.ular
    };
    private Integer [] suaraHewan = {
            R.raw.kuda
            ,R.raw.monyet
            ,R.raw.panda
            ,R.raw.sapi
            ,R.raw.serigala
            ,R.raw.singa
            ,R.raw.ular
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custum);

        lvcustomhewan = (ListView) findViewById(R.id.lvcustomhewan);

        Adapterhewan adapter = new Adapterhewan(this, namahewan, gambarhewan);

        lvcustomhewan.setAdapter(adapter);

        final DetailHewan deskripsiHewan = new DetailHewan();

        lvcustomhewan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mbakIn = new Intent(CustumActivity.this, DetailHewanActivity.class);
                mbakIn.putExtra("namaHewan", namahewan[position]);
                mbakIn.putExtra("gambarhewan", gambarhewan[position]);
                mbakIn.putExtra("suaraHewan",suaraHewan[position]);
                mbakIn.putExtra("detailHewan",deskripsiHewan.detailhewan[position]);
                startActivity(mbakIn);
            }
        });
    }
}

