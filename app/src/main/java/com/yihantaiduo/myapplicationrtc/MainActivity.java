package com.yihantaiduo.myapplicationrtc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;


import com.yihantaiduo.myapplicationrtc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfView = findViewById(R.id.pdf_view);
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.show();

// 设置当前显示页的前后缓存个数，效果类似 ViewPager 的这个属性
        pdfView.setOffscreenPageLimit(2);

// 是否支持缩放
        pdfView.isCanZoom(true);

// 设置最大缩放倍数,最大支持20倍
        pdfView.setMaxScale(10f);
// 设置当前页变化的回调监听
        pdfView.setOnPageChangedListener(new PDFView.OnPageChangedListener() {
            @Override
            public void onPageChanged(int i, int i1) {

            }
        });
// 从网络打开 pdf
        pdfView.showPdfFromUrl("https://github.com/wdeo3601/PDFView/raw/master/sample.pdf");
        pdfView.setshow(new PDFView.IsShow() {
            @Override
            public void show() {
                progressDialog.dismiss();
            }
        });
    }

}