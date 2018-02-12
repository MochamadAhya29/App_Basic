package com.example.afiq.app_basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListviewActivity extends AppCompatActivity {

    private ListView lvbuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lvbuah = (ListView) findViewById(R.id.lvbuah);


        lvbuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListviewActivity.this,"kamu memilih buah ke" + position,Toast.LENGTH_SHORT).show();

            }
        });
    }
}