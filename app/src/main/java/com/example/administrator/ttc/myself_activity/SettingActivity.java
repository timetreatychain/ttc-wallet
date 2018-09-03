package com.example.administrator.ttc.myself_activity;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.content.IntentCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.ttc.R;
import com.example.administrator.ttc.login_acitivty.LoginActivity;
import com.wb.baselib.base.activity.BaseActivity;
import com.zhy.autolayout.AutoLinearLayout;

public class SettingActivity extends BaseActivity {

    private ImageView setting_back_img;
    private AutoLinearLayout setting_update;
    private AutoLinearLayout setting_about_our;
    private Button setting_logout_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView(savedInstanceState);
    }

    @Override
    protected void initView(Bundle bundle) {
        setting_back_img = findViewById(R.id.setting_back_img);
        setting_update = findViewById(R.id.setting_update);
        setting_about_our = findViewById(R.id.setting_about_our);
        setting_logout_btn = findViewById(R.id.setting_logout_btn);
        setListener();
    }

    @Override
    protected void setListener() {
        setting_back_img.setOnClickListener(this);
        setting_update.setOnClickListener(this);
        setting_about_our.setOnClickListener(this);
        setting_logout_btn.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.setting_back_img) {
            finish();
        } else if (id == R.id.setting_update) {
            showShortToast("检查更新");
        } else if (id == R.id.setting_about_our) {
            showShortToast("关于我们");
        } else if (id == R.id.setting_logout_btn) {
            Intent intent = new Intent(this, LoginActivity.class);
            ComponentName cn = intent.getComponent();
            Intent mainIntent = IntentCompat.makeRestartActivityTask(cn);//ComponentInfo{包名+类名}
            startActivity(mainIntent);
        }
    }
}
