package com.example.administrator.ttc.zichan_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.ttc.R;
import com.example.administrator.ttc.adapter.BdWalletAdapter;
import com.example.administrator.ttc.bean.BdTestBean;
import com.wb.baselib.base.activity.BaseActivity;
import com.wb.baselib.utils.ToActivityUtil;

import java.util.ArrayList;
import java.util.List;

public class OtcWalletActivity extends BaseActivity {

    private ImageView otc_wallet_back_img;
    private TextView otc_wallet_money;
    private ListView otc_wallet_listView;
    List<BdTestBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otc_wallet);
        list.add(new BdTestBean("蛋生的世界提币至OTC交易", "2018-08-08 15:30", "2000.00", "0"));
        list.add(new BdTestBean("蛋生的世界提币至OTC交易", "2018-08-08 16:55", "500.00", "0"));
        initView(savedInstanceState);
    }

    @Override
    protected void initView(Bundle bundle) {

        otc_wallet_back_img = findViewById(R.id.otc_wallet_back_img);
        otc_wallet_money = findViewById(R.id.otc_wallet_money);
        otc_wallet_listView = findViewById(R.id.otc_wallet_listView);
        setListener();
        BdWalletAdapter bdWalletAdapter = new BdWalletAdapter(this, list);
        otc_wallet_listView.setAdapter(bdWalletAdapter);
        otc_wallet_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToActivityUtil.newInsance().toNextActivity(OtcWalletActivity.this, JyDetailsActivity.class);
            }
        });
    }

    @Override
    protected void setListener() {
        otc_wallet_back_img.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.otc_wallet_back_img) {
            finish();
        }
    }
}
