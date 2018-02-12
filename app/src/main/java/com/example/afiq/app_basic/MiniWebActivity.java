package com.example.afiq.app_basic;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MiniWebActivity extends AppCompatActivity {

    @BindView(R.id.pgweb)
    ProgressBar pgweb;
    @BindView(R.id.txturlweb)
    EditText txturlweb;
    @BindView(R.id.btncari)
    ImageButton btncari;
    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_web);
        ButterKnife.bind(this);
        pengaturanwebview();

        String google = "http://google.com";
        webview.loadUrl(google);
        webview.setWebViewClient(new ClientKu());
    }

    private void pengaturanwebview() {
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setSupportZoom(true);
        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                pgweb.setVisibility(View.VISIBLE);
                pgweb.setProgress(newProgress);
                if (newProgress ==100){
                    pgweb.setVisibility(view.INVISIBLE);
                }
            }
        });
    }

    public void cariweb(View view) {
        String url = txturlweb.getText().toString();
        webview.loadUrl(url);
    }

    private class ClientKu extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
    //agar kembali ke halaman sebelumnya

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        }else {
            new AlertDialog.Builder(MiniWebActivity.this)
            .setTitle("keluar")
                    .setMessage("Yakin mau keluar?")
                    .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MiniWebActivity.this, "kamu menekan tombol ya,",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                    })
                    .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MiniWebActivity.this, "kamu menekan tombol Tidak,", Toast.LENGTH_SHORT).show();
                        }
                    }).show();


        }
    }
}
