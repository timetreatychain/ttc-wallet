package com.example.administrator.ttc.login_acitivty;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.ttc.R;
import com.example.administrator.ttc.RequestUtils;
import com.squareup.okhttp.Request;
import com.wb.baselib.base.activity.BaseActivity;
import com.wb.baselib.utils.SharedPrefsUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

public class FindIdThreeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView findIdThree_back_img;
    private EditText findIdThree_newPwd_text;
    private EditText findIdThree_surePwd_text;
    private Button findIdThree_button;
    private String token;
    private String blockId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id_three);
        token = SharedPrefsUtil.getValue(this, "token", "token", "");
        blockId = SharedPrefsUtil.getValue(this, "blockId", "blockId", "");
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
                OkHttpUtils.post().url(RequestUtils.REQUEST_HEAD + RequestUtils.FIND_UPDATE_PWD)
                        .addParams("pwd", newPwd)
                        .addParams("token", token)
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
                                Log.e("找回ID重置密码成功：", response);
                                showShortToast("重置密码成功");
                                finish();
                            }
                        });
            }
        }
    }
}
