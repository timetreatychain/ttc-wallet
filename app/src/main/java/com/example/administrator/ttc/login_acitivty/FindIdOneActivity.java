package com.example.administrator.ttc.login_acitivty;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ttc.R;
import com.example.administrator.ttc.RequestUtils;
import com.example.administrator.ttc.bean.FindIdOneBean;
import com.example.administrator.ttc.utlis.MyCountDownTimer;
import com.example.administrator.ttc.utlis.PhoneFormatCheckUtils;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.wb.baselib.base.activity.BaseActivity;
import com.wb.baselib.utils.SharedPrefsUtil;
import com.wb.baselib.utils.ToActivityUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

public class FindIdOneActivity extends BaseActivity implements View.OnClickListener {

    private ImageView findIdOne_back_img;
    private EditText findIdOne_phone_edit;
    private EditText findIdOne_name_edit;
    private EditText findIdOne_num_edit;
    private EditText findIdOne_code_edit;
    private TextView findIdOne_getCode_text;
    private Button findIdOne_next_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id_one);
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
        findIdOne_back_img = findViewById(R.id.findIdOne_back_img);
        findIdOne_name_edit = findViewById(R.id.findIdOne_name_edit);
        findIdOne_num_edit = findViewById(R.id.findIdOne_num_edit);
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
                OkHttpUtils.post().url(RequestUtils.REQUEST_HEAD + RequestUtils.FIND_BLOCK_ID_CODE)
                        .addParams("phone", phone)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Request request, Exception e) {
                                Log.e("失败：", e.toString());
                                showShortToast(e.getMessage());
                            }

                            @Override
                            public void onResponse(String response) {
                                Log.e("找回ID获取验证码成功：", response);
                                showShortToast("已发送");
                                MyCountDownTimer myCountDownTimer = new MyCountDownTimer(60000, 1000, findIdOne_getCode_text);
                                myCountDownTimer.start();
                            }
                        });
            }
        } else if (id == R.id.findIdOne_next_button) {
            //下一步
            String code = findIdOne_code_edit.getText().toString();
            String name = findIdOne_name_edit.getText().toString();
            String card = findIdOne_num_edit.getText().toString();
            String phone = findIdOne_phone_edit.getText().toString();
            if (code.equals("") || name.equals("") || card.equals("") || phone.equals("")) {
                showShortToast("请完善信息!");
            } else {
                OkHttpUtils.post().url(RequestUtils.REQUEST_HEAD + RequestUtils.FIND_BLOCK_ID)
                        .addParams("code", code)
                        .addParams("userName", name)
                        .addParams("identityCard", card)
                        .addParams("phone", phone)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Request request, Exception e) {
                                Log.e("失败：", e.toString());
                                showShortToast(e.getMessage());
                            }

                            @Override
                            public void onResponse(String response) {
                                Log.e("找回ID验证成功：", response);
                                Gson gson = new Gson();
                                FindIdOneBean findIdOneBean = gson.fromJson(response, FindIdOneBean.class);
                                if (findIdOneBean.getState().getCode().equals("20000")) {
                                    String blockId = findIdOneBean.getData().getBlockId();
                                    String token = findIdOneBean.getData().getToken();
                                    SharedPrefsUtil.putValue(FindIdOneActivity.this, "blockId", "blockId", blockId);
                                    SharedPrefsUtil.putValue(FindIdOneActivity.this, "token", "token", token);
                                    ToActivityUtil.newInsance().toNextActivityAndFinish(FindIdOneActivity.this, FindIdTwoActivity.class);
                                } else {
                                    showShortToast(findIdOneBean.getState().getMsg());
                                }
                            }
                        });
            }
        }
    }
}
