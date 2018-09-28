package com.example.administrator.ttc.login_acitivty;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.ttc.R;
import com.example.administrator.ttc.RequestUtils;
import com.example.administrator.ttc.bean.AttestationBean;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.wb.baselib.base.activity.BaseActivity;
import com.wb.baselib.utils.SharedPrefsUtil;
import com.wb.baselib.utils.ToActivityUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

public class AttestationActivity extends BaseActivity implements View.OnClickListener {
    private ImageView attest_back_img;
    private EditText attest_name_edit;
    private EditText attest_num_edit;
    private Button attest_button;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attestation);
//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }
        initView(savedInstanceState);
        phone = SharedPrefsUtil.getValue(this, "phone", "phone", "");
    }

    @Override
    protected void initView(Bundle bundle) {
        attest_back_img = findViewById(R.id.attest_back_img);
        attest_name_edit = findViewById(R.id.attest_name_edit);
        attest_num_edit = findViewById(R.id.attest_num_edit);
        attest_button = findViewById(R.id.attest_button);
        attest_back_img.setOnClickListener(this);
        attest_button.setOnClickListener(this);
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
        if (id == R.id.attest_back_img) {
            //返回
            finish();
        } else if (id == R.id.attest_button) {
            //提交申请
            String name = attest_name_edit.getText().toString();
            String id_card = attest_num_edit.getText().toString();
            if (name.equals("") || id_card.equals("")) {
                showShortToast("姓名和证件号不能为空");
            } else {
                OkHttpUtils.post().url(RequestUtils.REQUEST_HEAD + RequestUtils.SAVE_IDENTITY_CARD)
                        .addParams("userName", name)
                        .addParams("identityCard", id_card)
                        .addParams("account", phone)
                        .addParams("project", "3")
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Request request, Exception e) {
                                Log.e("失败：", e.toString());
                                showShortToast(e.toString());
                            }

                            @Override
                            public void onResponse(String response) {
                                Log.e("成功：", response);
                                Gson gson = new Gson();
                                AttestationBean attestationBean = gson.fromJson(response, AttestationBean.class);
                                String blockId = attestationBean.getData().getBlockId();
                                String token = attestationBean.getData().getToken();
                                SharedPrefsUtil.putValue(AttestationActivity.this, "blockId", "blockId", blockId);
                                SharedPrefsUtil.putValue(AttestationActivity.this, "token", "token", token);
                                ToActivityUtil.newInsance().toNextActivityAndFinish(AttestationActivity.this, SetPwdActivity.class);
                            }
                        });
            }

        }
    }

}
