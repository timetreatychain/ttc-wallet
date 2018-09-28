package com.example.administrator.ttc.login_acitivty;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ttc.R;
import com.example.administrator.ttc.RequestUtils;
import com.example.administrator.ttc.bean.RestPwdBean;
import com.example.administrator.ttc.utlis.MyCountDownTimer;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.wb.baselib.base.activity.BaseActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

public class ResetPwdActivity extends BaseActivity implements View.OnClickListener {

    private ImageView resetPwd_back_img;
    private TextView resetPwd_phone_text;
    private TextView resetPwd_getCode_text;
    private EditText resetPwd_code_edit;
    private EditText resetPwd_newPwd_text;
    private EditText resetPwd_surePwd_text;
    private String phone;
    private String blockId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pwd);
//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }
        initView(savedInstanceState);
        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");
        blockId = intent.getStringExtra("blockId");
        resetPwd_phone_text.setText(phone);
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
            OkHttpUtils.post().url(RequestUtils.REQUEST_HEAD + RequestUtils.BLOCK_ID_PHONE_CODE)
                    .addParams("blockId", blockId)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Request request, Exception e) {
                            Log.e("失败：", e.toString());
                            showShortToast(e.getMessage());
                        }

                        @Override
                        public void onResponse(String response) {
                            Log.e("找回密码发送验证码成功", response);
                            showShortToast("已发送");
                            MyCountDownTimer myCountDownTimer = new MyCountDownTimer(60000, 1000, resetPwd_getCode_text);
                            myCountDownTimer.start();
                        }
                    });
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
                OkHttpUtils.post().url(RequestUtils.REQUEST_HEAD + RequestUtils.FIND_PWD)
                        .addParams("code", code)
                        .addParams("pwd", newPwd)
                        .addParams("blockId", blockId)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Request request, Exception e) {
                                Log.e("失败：", e.toString());
                                showShortToast(e.getMessage());
                            }

                            @Override
                            public void onResponse(String response) {
                                Log.e("提交成功", response);
                                Gson gson = new Gson();
                                RestPwdBean restPwdBean = gson.fromJson(response, RestPwdBean.class);
                                if (restPwdBean.getState().getCode().equals("20000")) {
                                    finish();
                                } else {
                                    showShortToast(restPwdBean.getState().getMsg());
                                }
                            }
                        });
            }
        }
    }
}