package com.example.afiq.app_basic;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailHewanActivity extends AppCompatActivity {

    @BindView(R.id.imgdetail)
    ImageView imgdetail;
    @BindView(R.id.txtdetail)
    TextView txtdetail;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hewan);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tampilData();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void tampilData() {
        Intent masIn = getIntent();
        String nama = masIn.getStringExtra("namaHewan");
        Integer gambar = masIn.getIntExtra("gambarhewan", 0);
        final Integer suara = masIn.getIntExtra("suaraHewan", 0);
        String dekripsi = masIn.getStringExtra("detailHewan");

        setTitle(nama);
        imgdetail.setImageResource(gambar);
        txtdetail.setText(dekripsi);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "playing audio..... ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //mutar musik lah
                MediaPlayer mp =new MediaPlayer();
                Uri lokasiaudio = Uri.parse("android.resource://"+ getPackageName()
                + "/" + suara);
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mp.setDataSource(DetailHewanActivity.this, lokasiaudio);
                } catch (IOException e) {

                }
                try {
                    mp.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mp.start();

            }
        });
    }
}
