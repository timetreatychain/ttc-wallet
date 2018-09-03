package com.example.administrator.ttc.login_acitivty;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.ttc.MainActivity;
import com.example.administrator.ttc.R;
import com.wb.baselib.base.activity.BaseActivity;
import com.wb.baselib.utils.ToActivityUtil;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText login_id_edit;
    private EditText login_password_edit;
    private TextView login_forget_password;
    private TextView login_register_text;
    private Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        login_id_edit = findViewById(R.id.login_id_edit);
        login_password_edit = findViewById(R.id.login_password_edit);
        login_forget_password = findViewById(R.id.login_forget_password);
        login_register_text = findViewById(R.id.login_register_text);
        login_button = findViewById(R.id.login_button);
        login_forget_password.setOnClickListener(this);
        login_register_text.setOnClickListener(this);
        login_button.setOnClickListener(this);
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
        if (id == R.id.login_forget_password) {
            //忘记密码
            ToActivityUtil.newInsance().toNextActivity(this, FindPwdActivity.class);
        } else if (id == R.id.login_register_text) {
            //申请注册
            ToActivityUtil.newInsance().toNextActivity(this, RegisterActivity.class);
        } else if (id == R.id.login_button) {
            //登录
            String login_id = login_id_edit.getText().toString();
            String password = login_password_edit.getText().toString();
            if (login_id.equals("") || password.equals("")) {
                showShortToast("Id或密码不能为空");
            } else {
                ToActivityUtil.newInsance().toNextActivityAndFinish(this, MainActivity.class);
            }
        }
    }
}