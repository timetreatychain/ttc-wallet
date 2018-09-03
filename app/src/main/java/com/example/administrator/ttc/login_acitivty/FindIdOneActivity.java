package com.example.administrator.ttc.login_acitivty;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ttc.utlis.PhoneFormatCheckUtils;
import com.example.administrator.ttc.R;
import com.wb.baselib.base.activity.BaseActivity;
import com.wb.baselib.utils.ToActivityUtil;

public class FindIdOneActivity extends BaseActivity implements View.OnClickListener {

    private ImageView findIdOne_back_img;
    private EditText findIdOne_phone_edit;
    private EditText findIdOne_code_edit;
    private TextView findIdOne_getCode_text;
    private Button findIdOne_next_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id_one);
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
        findIdOne_back_img = findViewById(R.id.findIdOne_back_img);
        findIdOne_phone_edit = findViewById(R.id.findIdOne_phone_edit);
        findIdOne_code_edit = findViewById(R.id.findIdOne_code_edit);
        findIdOne_getCode_text = findViewById(R.id.findIdOne_getCode_text);
        findIdOne_next_button = findViewById(R.id.findIdOne_next_button);
        findIdOne_back_img.setOnClickListener(this);
        findIdOne_getCode_text.setOnClickListener(this);
        findIdOne_next_button.setOnClickListener(this);
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
        if (id == R.id.findIdOne_back_img) {
            //返回
            finish();
        } else if (id == R.id.findIdOne_getCode_text) {
            //获取验证码
            String phone = findIdOne_phone_edit.getText().toString();
            if (phone.equals("")) {
                showShortToast("手机号码不能为空");
            } else if (!PhoneFormatCheckUtils.isPhoneLegal(phone)) {
                showShortToast("手机号码不合法");
            } else {
                showShortToast("获取短信验证码");
            }
        } else if (id == R.id.findIdOne_next_button) {
            //下一步
            String code = findIdOne_code_edit.getText().toString();
            if (code.equals("")) {
                showShortToast("验证码不能为空");
            } else {
                ToActivityUtil.newInsance().toNextActivityAndFinish(this, FindIdTwoActivity.class);
            }
        }
    }
}
