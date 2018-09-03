package com.example.administrator.ttc.myself_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.ttc.R;
import com.example.administrator.ttc.adapter.MessageAdapter;
import com.example.administrator.ttc.bean.MessageTestBean;
import com.wb.baselib.base.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends BaseActivity {

    private List<MessageTestBean> list = new ArrayList<>();
    private ImageView message_back_img;
    private ListView message_listView;
    private MessageAdapter messageAdapter;
    private View message_gonggao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        list.add(new MessageTestBean("转入通知", "2018-08-22", "8000.00", "456789", "0", "0"));
        initView(savedInstanceState);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        messageAdapter.notifyDataSetChanged();
//    }

    @Override
    protected void initView(Bundle bundle) {
        message_back_img = findViewById(R.id.message_back_img);
        message_listView = findViewById(R.id.message_listView);
        setListener();
        messageAdapter = new MessageAdapter(this, list);
        message_listView.setAdapter(messageAdapter);
        message_gonggao = LayoutInflater.from(this).inflate(R.layout.layout_message_gonggao, null);
        message_listView.addHeaderView(message_gonggao);
        message_gonggao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShortToast("公告");
            }
        });
        message_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    list.get(position - 1).setIslook("1");
                }
                messageAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void setListener() {
        message_back_img.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle bundle) {

    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.message_back_img) {
            finish();
        }
    }
}
