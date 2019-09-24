package com.xugter.cooridnatorlayoutstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xugter.cooridnatorlayoutstudy.part1.Part1GuideActivity;
import com.xugter.cooridnatorlayoutstudy.part2.Part2GuideActivity;
import com.xugter.cooridnatorlayoutstudy.part3.RealXiamiActivity;
import com.xugter.cooridnatorlayoutstudy.part4.NestXiaMiActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void part1(View view) {
        startActivity(new Intent(this, Part1GuideActivity.class));
    }

    public void part2(View view) {
        startActivity(new Intent(this, Part2GuideActivity.class));
    }

    public void part3(View view) {
        startActivity(new Intent(this, RealXiamiActivity.class));
    }

    public void part4(View view) {
        startActivity(new Intent(this, NestXiaMiActivity.class));
    }
}
