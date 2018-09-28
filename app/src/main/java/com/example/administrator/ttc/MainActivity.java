package com.example.administrator.ttc;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.ttc.adapter.MainFragmentPageAdapter;
import com.example.administrator.ttc.fragment.JyFragment;
import com.example.administrator.ttc.fragment.MoneyFragment;
import com.example.administrator.ttc.fragment.MyselfFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private ViewPager main_viewpager;
    private RadioGroup main_radioGroup;
    private RadioButton main_tab_money;
    private Fragment moneyFragment;
    private Fragment jyFragment;
    private Fragment myselfFragment;
    private MainFragmentPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        initView();
        initViewPager();
    }

    protected void initView() {
        main_viewpager = findViewById(R.id.main_viewPager);
        main_radioGroup = findViewById(R.id.main_radioGroup);
        main_tab_money = findViewById(R.id.main_tab_money);
        main_radioGroup.setOnCheckedChangeListener(this);
    }

    private void initViewPager() {
        moneyFragment = new MoneyFragment();
        jyFragment = new JyFragment();
        myselfFragment = new MyselfFragment();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(moneyFragment);
        fragments.add(jyFragment);
        fragments.add(myselfFragment);
        //获取FragmentManager对象
        //获取FragmentPageAdapter对象
        adapter = new MainFragmentPageAdapter(getSupportFragmentManager(), fragments);
        //设置Adapter，使ViewPager 与 Adapter 进行绑定
        main_viewpager.setAdapter(adapter);
        //设置ViewPager默认显示第一个View
        main_viewpager.setCurrentItem(0);
        //ViewPager页面切换监听
        main_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        main_radioGroup.check(R.id.main_tab_money);
                        break;
                    case 1:
                        main_radioGroup.check(R.id.main_tab_jy);
                        break;
                    case 2:
                        main_radioGroup.check(R.id.main_tab_myself);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_tab_money: // 资产
                //显示第一个Fragment并关闭动画效果
                main_viewpager.setCurrentItem(0, false);
                break;
            case R.id.main_tab_jy: // 交易
                main_viewpager.setCurrentItem(1, false);
                break;
            case R.id.main_tab_myself: // 我的
                main_viewpager.setCurrentItem(2, false);
                break;
        }
    }

}
