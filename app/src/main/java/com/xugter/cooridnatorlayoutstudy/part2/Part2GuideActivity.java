package com.xugter.cooridnatorlayoutstudy.part2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xugter.cooridnatorlayoutstudy.R;
import com.xugter.cooridnatorlayoutstudy.part2.move.MoveActivity;
import com.xugter.cooridnatorlayoutstudy.part2.layout.LayoutActivity;
import com.xugter.cooridnatorlayoutstudy.part2.scroll.ScrollActivity;

public class Part2GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2_guide);
    }

    public void move(View view) {
        startActivity(new Intent(this, MoveActivity.class));
    }

    public void scroll(View view) {
        startActivity(new Intent(this, ScrollActivity.class));
    }

    public void layout(View view) {
        startActivity(new Intent(this, LayoutActivity.class));
    }
}
