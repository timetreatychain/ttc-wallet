package com.example.administrator.ttc.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.ttc.R;
import com.example.administrator.ttc.myself_activity.MessageActivity;
import com.example.administrator.ttc.myself_activity.SettingActivity;
import com.wb.baselib.base.fragment.LazyFragment;
import com.wb.baselib.utils.ToActivityUtil;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * Created by Administrator on 2018/8/18/018.
 */

public class MyselfFragment extends Fragment implements View.OnClickListener {

    private ImageView myself_header_img;
    private ImageView myself_setting_img;
    private TextView myself_id_text;
    private AutoLinearLayout myself_jy;
    private AutoLinearLayout myself_message;
    private AutoLinearLayout myself_sf;
    private AutoLinearLayout myself_aq;
    private AutoLinearLayout myself_sq;
    private AutoLinearLayout myself_kf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myself, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        myself_header_img = view.findViewById(R.id.myself_header_img);
        myself_setting_img = view.findViewById(R.id.myself_setting_img);
        myself_setting_img.setOnClickListener(this);
        myself_id_text = view.findViewById(R.id.myself_id_text);
        //交易记录
        myself_jy = view.findViewById(R.id.myself_jy);
        myself_jy.setOnClickListener(this);
        //消息中心
        myself_message = view.findViewById(R.id.myself_message);
        myself_message.setOnClickListener(this);
        //身份认证
        myself_sf = view.findViewById(R.id.myself_sf);
        myself_sf.setOnClickListener(this);
        //安全中心
        myself_aq = view.findViewById(R.id.myself_aq);
        myself_aq.setOnClickListener(this);
        //加入社群
        myself_sq = view.findViewById(R.id.myself_sq);
        myself_sq.setOnClickListener(this);
        //在线客服
        myself_kf = view.findViewById(R.id.myself_kf);
        myself_kf.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.myself_setting_img) {
            ToActivityUtil.newInsance().toNextActivity(getActivity(), SettingActivity.class);
        } else if (id == R.id.myself_jy) {
            Toast.makeText(getContext(), "交易记录", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.myself_message) {
            ToActivityUtil.newInsance().toNextActivity(getActivity(), MessageActivity.class);
        } else if (id == R.id.myself_sf) {
            Toast.makeText(getContext(), "身份认证", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.myself_aq) {
            Toast.makeText(getContext(), "安全中心", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.myself_sq) {
            Toast.makeText(getContext(), "加入社群", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.myself_kf) {
            Toast.makeText(getContext(), "在线客服", Toast.LENGTH_SHORT).show();
        }
    }
}
