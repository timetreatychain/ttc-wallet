package com.example.administrator.ttc.zichan_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ttc.R;
import com.wb.baselib.base.activity.BaseActivity;

public class IntoBidtActivity extends BaseActivity {

    private ImageView into_back_img;
    private ImageView into_header_img;
    private TextView into_id_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_into_bidt);
        initView(savedInstanceState);
    }

    @Override
    protected void initView(Bundle bundle) {
        into_back_img = findViewById(R.id.into_back_img);
        into_header_img = findViewById(R.id.into_header_img);
        into_id_text = findViewById(R.id.into_id_text);
        setListener();
    }

    @Override
    protected void setListener() {
        into_back_img.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.into_back_img) {
            finish();
        }
    }
}
