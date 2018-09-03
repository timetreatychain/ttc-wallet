package com.example.administrator.ttc.login_acitivty;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.ttc.R;
import com.wb.baselib.base.activity.BaseActivity;
import com.wb.baselib.utils.ToActivityUtil;

public class AttestationActivity extends BaseActivity implements View.OnClickListener {
    private ImageView attest_back_img;
    private EditText attest_name_edit;
    private EditText attest_num_edit;
    private Button attest_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attestation);
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
            String num = attest_num_edit.getText().toString();
            if (name.equals("") || num.equals("")) {
                showShortToast("姓名和证件号不能为空");
            } else {
                ToActivityUtil.newInsance().toNextActivityAndFinish(this, SetPwdActivity.class);
            }

        }
    }

}
