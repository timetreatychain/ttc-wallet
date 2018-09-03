package com.example.administrator.ttc.zichan_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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

public class EggWalletActivity extends BaseActivity {

    private ImageView egg_wallet_back_img;
    private TextView egg_wallet_money;
    private TextView egg_wallet_yd_money;
    private ListView egg_wallet_listView;
    private Button egg_wallet_tibi_btn;
    List<BdTestBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg_wallet);
        list.add(new BdTestBean("提币至币达钱包", "2018-08-18 15:30", "250.00", "1"));
        initView(savedInstanceState);
    }


    @Override
    protected void initView(Bundle bundle) {
        egg_wallet_back_img = findViewById(R.id.egg_wallet_back_img);
        egg_wallet_money = findViewById(R.id.egg_wallet_money);
        egg_wallet_yd_money = findViewById(R.id.egg_wallet_yd_money);
        egg_wallet_listView = findViewById(R.id.egg_wallet_listView);
        egg_wallet_tibi_btn = findViewById(R.id.egg_wallet_tibi_btn);
        setListener();
        BdWalletAdapter bdWalletAdapter = new BdWalletAdapter(this, list);
        egg_wallet_listView.setAdapter(bdWalletAdapter);
        egg_wallet_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToActivityUtil.newInsance().toNextActivity(EggWalletActivity.this, JyDetailsActivity.class);
            }
        });
    }

    @Override
    protected void setListener() {
        egg_wallet_back_img.setOnClickListener(this);
        egg_wallet_tibi_btn.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.egg_wallet_back_img) {
            finish();
        } else if (id == R.id.egg_wallet_tibi_btn) {
            showShortToast("提币");
        }
    }
}
