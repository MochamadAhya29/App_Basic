package com.example.afiq.app_basic;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuutama);
    }

    public void btntoastclikc(View tampilan){ 
        //perintah ketika tombol toast di klik

        Toast.makeText(this, "Ini Toast ya", Toast.LENGTH_SHORT).show();
    }

    public void btnalert_dialogclick(View view) {
        new AlertDialog.Builder(this)
                .setTitle(getResources().getText(R.string.titleAlert))
                .setMessage(getResources().getText(R.string.pesanalert))
                .setPositiveButton(getResources().getText(R.string.alertya), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"kamu menekan tombol YA Gaktau",Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton(getResources().getText(R.string.alertTidak), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"kamu memilih Yang mana Gaktau",Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    public void btnspiner(View view) {
        startActivity(new Intent(MainActivity.this, SpinnerActivity.class));
    }

    public void btnlist_view(View view) {
        startActivity(new Intent(MainActivity.this,ListviewActivity.class));
    }

    public void btncustom_listview(View view) {
        startActivity(new Intent(MainActivity.this,CustumActivity.class));
    }

    public void btnwebview(View view) {
        startActivity(new Intent(MainActivity.this,MiniWebActivity.class));
    }

    public void btnview_rager(View view) {
        startActivity(new Intent(MainActivity.this, pagerActivity.class));
    }

    public void btnnavigation_drawer(View view) {
    }

    public void btninput_user(View view) {
        startActivity(new Intent(MainActivity.this, Input_userActivity.class));
    }

    public void btndialog(View view) {
        // membuat clone dialaog dengan nama dialogku
        Dialog dialogku = new Dialog(MainActivity.this);
        dialogku.setContentView(R.layout.rofilexml);
        dialogku.show();
    }
}
