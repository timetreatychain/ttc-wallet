package com.example.administrator.ttc.login_acitivty;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ttc.R;
import com.wb.baselib.base.activity.BaseActivity;
import com.wb.baselib.utils.ToActivityUtil;

public class SetPwdActivity extends BaseActivity implements View.OnClickListener {

    private ImageView setPwd_back_img;
    private TextView setPwd_id_text;
    private EditText setPwd_set_edit;
    private EditText setPwd_againSet_edit;
    private Button setPwd_sure_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pwd);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        initView(savedInstanceState);
    }

    @Override
    protected void initView(Bundle bundle) {
        setPwd_back_img = findViewById(R.id.setPwd_back_img);
        setPwd_id_text = findViewById(R.id.setPwd_id_text);
        setPwd_set_edit = findViewById(R.id.setPwd_set_edit);
        setPwd_againSet_edit = findViewById(R.id.setPwd_againSet_edit);
        setPwd_sure_button = findViewById(R.id.setPwd_sure_button);
        setPwd_back_img.setOnClickListener(this);
        setPwd_sure_button.setOnClickListener(this);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.setPwd_back_img) {
            //返回
            finish();
        } else if (id == R.id.setPwd_sure_button) {
            //确认
            String newPwd = setPwd_set_edit.getText().toString();
            String surePwd = setPwd_againSet_edit.getText().toString();
            if (newPwd.equals("") || surePwd.equals("")) {
                showShortToast("密码不能为空");
            } else if (!newPwd.equals(surePwd)) {
                showShortToast("两次输入的密码不一致");
            } else {
                finish();
            }
        }
    }
}
