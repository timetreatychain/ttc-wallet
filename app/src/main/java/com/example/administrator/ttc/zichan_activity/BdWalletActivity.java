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
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class BdWalletActivity extends BaseActivity {

    private ImageView bd_wallet_back_img;
    private TextView bd_wallet_money;
    private TextView bd_wallet_yd_money;
    private ListView bd_wallet_listView;
    private AutoLinearLayout bd_wallet_out;
    private AutoLinearLayout bd_wallet_into;
    List<BdTestBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd_wallet);
        list.add(new BdTestBean("区块ID 456789转入", "2018-08-08 15:30", "1500.00", "0"));
        list.add(new BdTestBean("转出到区块ID 456789", "2018-08-18 22:15", "1000.00", "1"));
        list.add(new BdTestBean("活动空投糖果转入", "2018-08-08 23:15", "500.00", "0"));
        list.add(new BdTestBean("TTC-OTC退回", "2018-08-18 23:30", "250.00", "0"));
        list.add(new BdTestBean("蛋生的世界转入", "2018-08-18 23:45", "250.00", "0"));
        initView(savedInstanceState);
    }

    @Override
    protected void initView(Bundle bundle) {
        bd_wallet_back_img = findViewById(R.id.bd_wallet_back_img);
        bd_wallet_money = findViewById(R.id.bd_wallet_money);
        bd_wallet_yd_money = findViewById(R.id.bd_wallet_yd_money);
        bd_wallet_listView = findViewById(R.id.bd_wallet_listView);
        bd_wallet_out = findViewById(R.id.bd_wallet_out);
        bd_wallet_into = findViewById(R.id.bd_wallet_into);
        setListener();
        BdWalletAdapter bdWalletAdapter = new BdWalletAdapter(this, list);
        bd_wallet_listView.setAdapter(bdWalletAdapter);
        bd_wallet_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToActivityUtil.newInsance().toNextActivity(BdWalletActivity.this,JyDetailsActivity.class);
            }
        });
    }

    @Override
    protected void setListener() {
        bd_wallet_back_img.setOnClickListener(this);
        bd_wallet_out.setOnClickListener(this);
        bd_wallet_into.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.bd_wallet_back_img) {
            finish();
        } else if (id == R.id.bd_wallet_out) {
            ToActivityUtil.newInsance().toNextActivity(this, OutBidtActivity.class);
        } else if (id == R.id.bd_wallet_into) {
            ToActivityUtil.newInsance().toNextActivity(this, IntoBidtActivity.class);
        }
    }
}
