package com.example.administrator.ttc.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.ttc.MainActivity;
import com.example.administrator.ttc.R;
import com.example.administrator.ttc.RequestUtils;
import com.example.administrator.ttc.bean.PropertyBean;
import com.example.administrator.ttc.myself_activity.MessageActivity;
import com.example.administrator.ttc.zichan_activity.BdWalletActivity;
import com.example.administrator.ttc.zichan_activity.EggWalletActivity;
import com.example.administrator.ttc.zichan_activity.OtcWalletActivity;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.wb.baselib.utils.SharedPrefsUtil;
import com.wb.baselib.utils.ToActivityUtil;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by Administrator on 2018/8/18/018.
 */

public class MoneyFragment extends Fragment {

    String BASE_URL = "https://api.github.com/";

    private AutoLinearLayout ttc_linear;
    private AutoLinearLayout eth_linear;
    private TextView ttc_num_text;
    private TextView eth_num_text;
    private TextView fragme_egg_money;
    private TextView egg_yd_money;
    private TextView money_num_text;
    private AutoLinearLayout frame_bidt;
    private AutoLinearLayout frame_eth;
    private AutoLinearLayout money_frame_bd;
    private AutoLinearLayout money_frame_egg;
    private AutoLinearLayout money_frame_otc;
    private TextView bidt_text;
    private TextView eth_text;
    private ImageView message_img;
    private String token;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_money, container, false);
        token = SharedPrefsUtil.getValue(getContext(), "token", "token", "");
        ttc_linear = view.findViewById(R.id.ttc_linear);
        eth_linear = view.findViewById(R.id.eth_linear);
        ttc_num_text = view.findViewById(R.id.ttc_num_text);
        money_num_text = view.findViewById(R.id.money_num_text);
        egg_yd_money = view.findViewById(R.id.egg_yd_money);
        eth_num_text = view.findViewById(R.id.eth_num_text);
        fragme_egg_money = view.findViewById(R.id.fragme_egg_money);
        frame_bidt = view.findViewById(R.id.frame_bidt);
        frame_eth = view.findViewById(R.id.frame_eth);
        money_frame_bd = view.findViewById(R.id.money_frame_bd);
        money_frame_egg = view.findViewById(R.id.money_frame_egg);
        money_frame_otc = view.findViewById(R.id.money_frame_otc);
        bidt_text = view.findViewById(R.id.bidt_text);
        eth_text = view.findViewById(R.id.eth_text);
        message_img = view.findViewById(R.id.message_img);
        ttc_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttc_num_text.setTextColor(Color.parseColor("#556CB4"));
                bidt_text.setTextColor(Color.parseColor("#333333"));
                ttc_linear.setBackgroundColor(Color.parseColor("#FFFFFF"));
                eth_num_text.setTextColor(Color.parseColor("#9C9C9C"));
                eth_text.setTextColor(Color.parseColor("#9C9C9C"));
                eth_linear.setBackgroundColor(Color.parseColor("#EFEFEF"));
                frame_eth.setVisibility(View.GONE);
                frame_bidt.setVisibility(View.VISIBLE);
            }
        });
        eth_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eth_num_text.setTextColor(Color.parseColor("#556CB4"));
                eth_text.setTextColor(Color.parseColor("#333333"));
                eth_linear.setBackgroundColor(Color.parseColor("#FFFFFF"));
                ttc_num_text.setTextColor(Color.parseColor("#9C9C9C"));
                bidt_text.setTextColor(Color.parseColor("#9C9C9C"));
                ttc_linear.setBackgroundColor(Color.parseColor("#EFEFEF"));
                frame_bidt.setVisibility(View.GONE);
                frame_eth.setVisibility(View.VISIBLE);
            }
        });
        money_frame_bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToActivityUtil.newInsance().toNextActivity(getActivity(), BdWalletActivity.class);
            }
        });
        money_frame_egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToActivityUtil.newInsance().toNextActivity(getActivity(), EggWalletActivity.class);
            }
        });
        money_frame_otc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToActivityUtil.newInsance().toNextActivity(getActivity(), OtcWalletActivity.class);
            }
        });
        message_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToActivityUtil.newInsance().toNextActivity(getActivity(), MessageActivity.class);
            }
        });
        getProperty();
        return view;
    }

    private void getProperty() {
        OkHttpUtils.post().url(RequestUtils.REQUEST_HEAD + RequestUtils.GET_PROPERTY)
                .addParams("token", token)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Log.e("失败：", e.toString());
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response) {
                        Log.e("获取资产成功", response);
                        Gson gson = new Gson();
                        PropertyBean propertyBean = gson.fromJson(response, PropertyBean.class);
                        if (propertyBean.getState().getCode().equals("20000")) {
                            //资产BIDT总数
                            String total = propertyBean.getData().getTotal();
                            //资产BIDT总数折合人民币
                            String totalCny = propertyBean.getData().getTotalCny();
                            money_num_text.setText("≈" + totalCny);
                            ttc_num_text.setText("≈¥" + totalCny);
                            //蛋生数据
                            String money = propertyBean.getData().getList().get(0).getMoney();
                            fragme_egg_money.setText(money);
                            String conversion = propertyBean.getData().getList().get(0).getConversion();
                            egg_yd_money.setText("≈¥" + conversion);

                        } else {
                            Toast.makeText(getContext(), propertyBean.getState().getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
