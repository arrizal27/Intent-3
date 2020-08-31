package com.jar.latihanintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    private TextView textTitle,textDesc;
    private ImageView imageView;
    public static String EXTRA_TITLE = "extra title";
    public static String EXTRA_DESC = "extra desc";
    public static String EXTRA_IMAGE = "Extra image";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textTitle = findViewById(R.id.detailTitle);
        textDesc = findViewById(R.id.detailDesc);
        imageView = findViewById(R.id.imageDetail);

        Intent intent = getIntent();
        String title = intent.getStringExtra(EXTRA_TITLE);
        textTitle.setText(title);
        String desc = intent.getStringExtra(EXTRA_DESC);
        textDesc.setText(desc);
        int image = intent.getIntExtra(EXTRA_IMAGE,0);
        imageView.setImageResource(image);
    }
}
