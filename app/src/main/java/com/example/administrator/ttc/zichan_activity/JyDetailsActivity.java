package com.example.administrator.ttc.zichan_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.ttc.R;
import com.wb.baselib.base.activity.BaseActivity;

public class JyDetailsActivity extends BaseActivity {

    private ImageView jyDetails_back_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jy_details);
        initView(savedInstanceState);
    }

    @Override
    protected void initView(Bundle bundle) {
        jyDetails_back_img = findViewById(R.id.jyDetails_back_img);
        setListener();
    }

    @Override
    protected void setListener() {
        jyDetails_back_img.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle bundle) {

    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.jyDetails_back_img) {
            finish();
        }
    }
}
