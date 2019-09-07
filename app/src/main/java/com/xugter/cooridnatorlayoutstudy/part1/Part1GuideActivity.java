package com.xugter.cooridnatorlayoutstudy.part1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xugter.cooridnatorlayoutstudy.R;

public class Part1GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1_guide);
    }

    public void base1(View view) {
        startActivity(new Intent(this, BaseActivity1.class));
    }

    public void base2(View view) {
        startActivity(new Intent(this, BaseActivity2.class));
    }

    public void base3(View view) {
        startActivity(new Intent(this, BaseActivity3.class));
    }
}