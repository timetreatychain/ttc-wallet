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

public class ResetPwdActivity extends BaseActivity implements View.OnClickListener {

    private ImageView resetPwd_back_img;
    private TextView resetPwd_phone_text;
    private TextView resetPwd_getCode_text;
    private EditText resetPwd_code_edit;
    private EditText resetPwd_newPwd_text;
    private EditText resetPwd_surePwd_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pwd);
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
        resetPwd_back_img = findViewById(R.id.resetPwd_back_img);
        resetPwd_phone_text = findViewById(R.id.resetPwd_phone_text);
        resetPwd_getCode_text = findViewById(R.id.resetPwd_getCode_text);
        resetPwd_code_edit = findViewById(R.id.resetPwd_code_edit);
        resetPwd_newPwd_text = findViewById(R.id.resetPwd_newPwd_text);
        resetPwd_surePwd_text = findViewById(R.id.resetPwd_surePwd_text);
        Button resetPwd_button = findViewById(R.id.resetPwd_button);
        resetPwd_back_img.setOnClickListener(this);
        resetPwd_getCode_text.setOnClickListener(this);
        resetPwd_button.setOnClickListener(this);
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
        if (id == R.id.resetPwd_back_img) {
            //返回
            finish();
        } else if (id == R.id.resetPwd_getCode_text) {
            //获取验证码
            showShortToast("获取验证码");
        } else if (id == R.id.resetPwd_button) {
            //确认修改
            String code = resetPwd_code_edit.getText().toString();
            String newPwd = resetPwd_newPwd_text.getText().toString();
            String surePwd = resetPwd_surePwd_text.getText().toString();
            if (code.equals("")) {
                showShortToast("验证码不能为空");
            } else if (newPwd.equals("") || surePwd.equals("")) {
                showShortToast("密码不能为空");
            } else if (!newPwd.equals(surePwd)) {
                showShortToast("两次输入的密码不一致");
            } else {
                finish();
            }
        }
    }
}
