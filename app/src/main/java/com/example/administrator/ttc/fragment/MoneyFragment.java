package com.example.administrator.ttc.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ttc.R;
import com.example.administrator.ttc.myself_activity.MessageActivity;
import com.example.administrator.ttc.zichan_activity.BdWalletActivity;
import com.example.administrator.ttc.zichan_activity.EggWalletActivity;
import com.example.administrator.ttc.zichan_activity.OtcWalletActivity;
import com.wb.baselib.utils.ToActivityUtil;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.http.okhttp.OkHttpUtils;

/**
 * Created by Administrator on 2018/8/18/018.
 */

public class MoneyFragment extends Fragment {

    String BASE_URL = "https://api.github.com/";

    private AutoLinearLayout ttc_linear;
    private AutoLinearLayout eth_linear;
    private TextView ttc_num_text;
    private TextView eth_num_text;
    private AutoLinearLayout frame_bidt;
    private AutoLinearLayout frame_eth;
    private AutoLinearLayout money_frame_bd;
    private AutoLinearLayout money_frame_egg;
    private AutoLinearLayout money_frame_otc;
    private TextView bidt_text;
    private TextView eth_text;
    private ImageView message_img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_money, container, false);
        ttc_linear = view.findViewById(R.id.ttc_linear);
        eth_linear = view.findViewById(R.id.eth_linear);
        ttc_num_text = view.findViewById(R.id.ttc_num_text);
        eth_num_text = view.findViewById(R.id.eth_num_text);
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
        return view;
    }

}
