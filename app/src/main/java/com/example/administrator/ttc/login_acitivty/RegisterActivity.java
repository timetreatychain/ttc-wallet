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

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private ImageView register_back_img;
    private EditText register_phone_edit;
    private EditText register_code_edit;
    private TextView register_getCode_text;
    private Button register_next_button;
    private TextView register_login_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
        register_back_img = findViewById(R.id.register_back_img);
        register_phone_edit = findViewById(R.id.register_phone_edit);
        register_code_edit = findViewById(R.id.register_code_edit);
        register_getCode_text = findViewById(R.id.register_getCode_text);
        register_next_button = findViewById(R.id.register_next_button);
        register_login_text = findViewById(R.id.register_login_text);
        register_back_img.setOnClickListener(this);
        register_getCode_text.setOnClickListener(this);
        register_next_button.setOnClickListener(this);
        register_login_text.setOnClickListener(this);
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
        if (id == R.id.register_back_img) {
            //返回
            finish();
        } else if (id == R.id.register_getCode_text) {
            //获取短信验证码
            String phone = register_phone_edit.getText().toString();
            if (phone.equals("")) {
                showShortToast("手机号码不能为空");
            } else if (!PhoneFormatCheckUtils.isPhoneLegal(phone)) {
                showShortToast("手机号码不合法");
            } else {
                showShortToast("获取短信验证码");
            }
        } else if (id == R.id.register_login_text) {
            //立即登录
            finish();
        } else if (id == R.id.register_next_button) {
            //下一步
            String code = register_code_edit.getText().toString();
            String phone = register_phone_edit.getText().toString();
            if (code.equals("") || phone.equals("")) {
                showShortToast("手机号或验证码不能为空");
            } else {
                ToActivityUtil.newInsance().toNextActivityAndFinish(this, AttestationActivity.class);
            }
        }
    }
}
