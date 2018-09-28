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
import com.example.administrator.ttc.bean.FindPwdBean;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.wb.baselib.base.activity.BaseActivity;
import com.wb.baselib.utils.ToActivityUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

public class FindPwdActivity extends BaseActivity implements View.OnClickListener {

    private ImageView findPwd_back_img;
    private EditText findPwd_id_edit;
    private Button findPwd_next_button;
    private TextView findPwd_forgetId_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pwd);
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
        findPwd_back_img = findViewById(R.id.findPwd_back_img);
        findPwd_id_edit = findViewById(R.id.findPwd_id_edit);
        findPwd_next_button = findViewById(R.id.findPwd_next_button);
        findPwd_forgetId_text = findViewById(R.id.findPwd_forgetId_text);
        findPwd_back_img.setOnClickListener(this);
        findPwd_next_button.setOnClickListener(this);
        findPwd_forgetId_text.setOnClickListener(this);
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
        if (id == R.id.findPwd_back_img) {
            //返回
            finish();
        } else if (id == R.id.findPwd_forgetId_text) {
            //忘记ID
            ToActivityUtil.newInsance().toNextActivityAndFinish(this, FindIdOneActivity.class);
        } else if (id == R.id.findPwd_next_button) {
            //下一步
            final String find_id = findPwd_id_edit.getText().toString();
            if (find_id.equals("")) {
                showShortToast("区块ID不能为空");
            } else {
                OkHttpUtils.post().url(RequestUtils.REQUEST_HEAD + RequestUtils.JUDGE_BLOCK_ID)
                        .addParams("blockId", find_id)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Request request, Exception e) {
                                Log.e("失败：", e.toString());
                                showShortToast(e.getMessage());
                            }

                            @Override
                            public void onResponse(String response) {
                                Log.e("提交成功", response);
                                Gson gson = new Gson();
                                FindPwdBean findPwdBean = gson.fromJson(response, FindPwdBean.class);
                                if (findPwdBean.getState().getCode().equals("20000")) {
                                    String phone = findPwdBean.getData();
                                    ToActivityUtil.newInsance().toNextActivityAndFinish(FindPwdActivity.this, ResetPwdActivity.class, new String[]{"phone","blockId"}, new String[]{phone,find_id});
                                } else {
                                    showShortToast(findPwdBean.getState().getMsg());
                                }
                            }
                        });
            }

       }
    }
}
