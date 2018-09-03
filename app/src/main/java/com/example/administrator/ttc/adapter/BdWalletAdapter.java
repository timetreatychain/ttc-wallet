package com.example.administrator.ttc.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.ttc.R;
import com.example.administrator.ttc.bean.BdTestBean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/22/022.
 */

public class BdWalletAdapter extends BaseAdapter {

    private Context context;
    private List<BdTestBean> list;

    public BdWalletAdapter(Context context, List<BdTestBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_bd_wallet, parent, false);
            holder = new ViewHolder();
            holder.bd_item_id = convertView.findViewById(R.id.bd_item_id);
            holder.bd_item_time = convertView.findViewById(R.id.bd_item_time);
            holder.bd_item_money = convertView.findViewById(R.id.bd_item_money);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String type = list.get(position).getType();
        //转入
        if (type.equals("0")) {
            holder.bd_item_id.setText(list.get(position).getId());
            holder.bd_item_time.setText(list.get(position).getTime());
            holder.bd_item_money.setText("+" + list.get(position).getMoney() + "BIDT");
            holder.bd_item_money.setTextColor(Color.parseColor("#6E86D3"));
        } else if (type.equals("1")) {
            holder.bd_item_id.setText(list.get(position).getId());
            holder.bd_item_time.setText(list.get(position).getTime());
            holder.bd_item_money.setText("-" + list.get(position).getMoney() + "BIDT");
            holder.bd_item_money.setTextColor(Color.parseColor("#FF3B32"));
        }
        return convertView;

    }

    class ViewHolder {
        TextView bd_item_id;
        TextView bd_item_time;
        TextView bd_item_money;
    }
}
