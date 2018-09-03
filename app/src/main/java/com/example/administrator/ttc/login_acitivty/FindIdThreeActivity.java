package com.example.administrator.ttc.login_acitivty;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.ttc.R;
import com.thefinestartist.Base;
import com.wb.baselib.base.activity.BaseActivity;
import com.wb.baselib.utils.ToActivityUtil;

public class FindIdThreeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView findIdThree_back_img;
    private EditText findIdThree_newPwd_text;
    private EditText findIdThree_surePwd_text;
    private Button findIdThree_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id_three);
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
        findIdThree_back_img = findViewById(R.id.findIdThree_back_img);
        findIdThree_newPwd_text = findViewById(R.id.findIdThree_newPwd_text);
        findIdThree_surePwd_text = findViewById(R.id.findIdThree_surePwd_text);
        findIdThree_button = findViewById(R.id.findIdThree_button);
        findIdThree_back_img.setOnClickListener(this);
        findIdThree_button.setOnClickListener(this);
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
        if (id == R.id.findIdThree_back_img) {
            //返回
            finish();
        } else if (id == R.id.findIdThree_button) {
            //确认修改
            String newPwd = findIdThree_newPwd_text.getText().toString();
            String surePwd = findIdThree_surePwd_text.getText().toString();
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
