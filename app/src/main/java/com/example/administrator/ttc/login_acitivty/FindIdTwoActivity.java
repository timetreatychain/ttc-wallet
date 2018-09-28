package com.example.administrator.ttc.login_acitivty;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ttc.R;
import com.wb.baselib.base.activity.BaseActivity;
import com.wb.baselib.utils.SharedPrefsUtil;
import com.wb.baselib.utils.ToActivityUtil;

public class FindIdTwoActivity extends BaseActivity implements View.OnClickListener {

    private ImageView findIdTwo_back_img;
    private TextView findIdTwo_id_text;
    private Button findIdTwo_login_button;
    private Button findIdTwo_resetPwd_button;
    private String blockId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id_two);
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
        findIdTwo_back_img = findViewById(R.id.findIdTwo_back_img);
        findIdTwo_id_text = findViewById(R.id.findIdTwo_id_text);
        findIdTwo_login_button = findViewById(R.id.findIdTwo_login_button);
        findIdTwo_resetPwd_button = findViewById(R.id.findIdTwo_resetPwd_button);
        findIdTwo_back_img.setOnClickListener(this);
        findIdTwo_login_button.setOnClickListener(this);
        findIdTwo_resetPwd_button.setOnClickListener(this);
        findIdTwo_id_text.setText(blockId);
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
        if (id == R.id.findIdTwo_back_img) {
            //返回
            finish();
        } else if (id == R.id.findIdTwo_login_button) {
            //返回登录
            ToActivityUtil.newInsance().toNextActivityAndFinish(this, LoginActivity.class);
        } else if (id == R.id.findIdTwo_resetPwd_button) {
            //重置密码
            ToActivityUtil.newInsance().toNextActivityAndFinish(this, FindIdThreeActivity.class);
        }
    }
}
