package com.example.administrator.ttc.login_acitivty;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.ttc.MainActivity;
import com.example.administrator.ttc.R;
import com.example.administrator.ttc.RequestUtils;
import com.example.administrator.ttc.bean.LoginBean;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.wb.baselib.base.activity.BaseActivity;
import com.wb.baselib.utils.SharedPrefsUtil;
import com.wb.baselib.utils.ToActivityUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText login_id_edit;
    private EditText login_password_edit;
    private TextView login_forget_password;
    private TextView login_register_text;
    private Button login_button;
    private String blockId;
    private String token;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        blockId = SharedPrefsUtil.getValue(this, "blockId", "blockId", "");
        token = SharedPrefsUtil.getValue(this, "token", "token", "");
        password = SharedPrefsUtil.getValue(this, "password", "password", "");
        if (!blockId.equals("") && !token.equals("")) {
            ToActivityUtil.newInsance().toNextActivityAndFinish(LoginActivity.this, MainActivity.class);
        }
//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }
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
            final String password = login_password_edit.getText().toString();
            if (login_id.equals("") || password.equals("")) {
                showShortToast("Id或密码不能为空");
            } else {
                OkHttpUtils.post().url(RequestUtils.REQUEST_HEAD + RequestUtils.REQUEST_LOGIN)
                        .addParams("username", login_id)
                        .addParams("pwd", password)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Request request, Exception e) {
                                Log.e("失败", e.toString());
                            }

                            @Override
                            public void onResponse(String response) {
                                Log.e("登录：", response);
                                Gson gson = new Gson();
                                LoginBean loginBean = gson.fromJson(response, LoginBean.class);
                                if (loginBean.getState().getCode().equals("20000")) {
                                    String blockId = loginBean.getData().getId();
                                    String token =  loginBean.getData().getToken();
                                    SharedPrefsUtil.putValue(LoginActivity.this, "blockId", "blockId", blockId);
                                    SharedPrefsUtil.putValue(LoginActivity.this, "token", "token", token);
                                    SharedPrefsUtil.putValue(LoginActivity.this, "password", "password", password);
                                    ToActivityUtil.newInsance().toNextActivityAndFinish(LoginActivity.this, MainActivity.class);
                                } else {
                                    showShortToast(loginBean.getState().getMsg());
                                }

                            }
                        });
            }
        }
    }
}