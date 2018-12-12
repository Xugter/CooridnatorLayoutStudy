package com.xugter.cooridnatorlayoutstudy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.xugter.cooridnatorlayoutstudy.R;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity2 extends AppCompatActivity {

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    private VpAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base2);
        adapter = new VpAdapter(getSupportFragmentManager());
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("Toolbar");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    private void initView() {
        fragments.clear();
        titles.clear();
        for (int i = 0; i < 3; i++) {
            fragments.add(new BaseFragment());
            titles.add("页面" + i);
        }
        adapter.setFragments(fragments);
        adapter.setTitles(titles);
        viewPager.setAdapter(adapter);
    }
}