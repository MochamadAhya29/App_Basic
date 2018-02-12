package com.example.afiq.app_basic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Input_userActivity extends AppCompatActivity {

    @BindView(R.id.txtLebar)
    EditText txtLebar;
    @BindView(R.id.txtPanjang)
    EditText txtPanjang;
    @BindView(R.id.btnhasil)
    Button btnhasil;
    @BindView(R.id.btnhitung)
    TextView btnhitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_user);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnhasil)
    public void onViewClicked() {
        Double panjang = Double.valueOf(txtPanjang.getText().toString());
        Double lebar = Double.valueOf(txtLebar.getText().toString());

        if (TextUtils.isEmpty(txtPanjang.getText().toString())){
            txtPanjang.setError("panjang masih kosong");
            txtPanjang.requestFocus();

        } else if (TextUtils.isEmpty(txtLebar.getText().toString())){
            txtLebar.setError("lebar masih Eror");
            txtLebar.requestFocus();

        }else {
            Double hasil = (panjang * lebar);
            btnhasil.setText(String.valueOf(hasil));
        }
    }

        }



