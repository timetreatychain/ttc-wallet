package com.example.administrator.ttc.zichan_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ttc.R;
import com.example.administrator.ttc.weight.OutPopupWindow;
import com.wb.baselib.base.activity.BaseActivity;
import com.wb.baselib.utils.ToActivityUtil;

public class OutBidtActivity extends BaseActivity {

    private ImageView out_back_img;
    private EditText out_id_edit;
    private EditText out_num_edit;
    private EditText out_name_edit;
    private Button out_next_button;
    private TextView out_kg_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_bidt);
        initView(savedInstanceState);
    }

    @Override
    protected void initView(Bundle bundle) {
        out_back_img = findViewById(R.id.out_back_img);
        out_id_edit = findViewById(R.id.out_id_edit);
        out_num_edit = findViewById(R.id.out_num_edit);
        out_name_edit = findViewById(R.id.out_name_edit);
        out_next_button = findViewById(R.id.out_next_button);
        out_kg_num = findViewById(R.id.out_kg_num);
        setListener();
    }

    @Override
    protected void setListener() {
        out_back_img.setOnClickListener(this);
        out_next_button.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.out_back_img) {
            finish();
        } else if (id == R.id.out_next_button) {
            OutPopupWindow outPopupWindow = new OutPopupWindow(this);
            View view = LayoutInflater.from(this).inflate(R.layout.activity_out_bidt, null);
            outPopupWindow.showPopupWindow(view);
            outPopupWindow.setOnNextListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OutBidtActivity.this.finish();
                }
            });
        }
    }
}
