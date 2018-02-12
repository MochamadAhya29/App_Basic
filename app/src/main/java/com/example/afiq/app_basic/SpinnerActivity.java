package com.example.afiq.app_basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView txtspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner = (Spinner) findViewById(R.id.spinner);
        txtspinner = (TextView) findViewById(R.id.textspinner);

        // aksi ketika item spinner di klik
        // megubah txtnama
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] keterangan = {
                        "kamu memilih Apel "
                                ,"ceri buah yang kecil"
                                ,"Raja buah adal Durian"
                                ,"Jambu Air segar Rasanya"
                                ,"Jambu Biji banyak hasiatnya"
                };

                txtspinner.setText(keterangan[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
