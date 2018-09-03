package com.example.administrator.ttc.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.ttc.R;
import com.example.administrator.ttc.bean.BdTestBean;
import com.example.administrator.ttc.bean.MessageTestBean;
import com.wb.baselib.cache.GlideCatchUtil;
import com.wb.baselib.cache.GlideConfiguration;
import com.wb.baselib.image.GlideManager;

import java.util.List;

/**
 * Created by Administrator on 2018/8/22/022.
 */

public class MessageAdapter extends BaseAdapter {

    private Context context;
    private List<MessageTestBean> list;

    public MessageAdapter(Context context, List<MessageTestBean> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_message, parent, false);
            holder = new ViewHolder();
            holder.message_iem_icon = convertView.findViewById(R.id.message_iem_icon);
            holder.message_item_title = convertView.findViewById(R.id.message_item_title);
            holder.message_item_time = convertView.findViewById(R.id.message_item_time);
            holder.message_item_content = convertView.findViewById(R.id.message_item_content);
            holder.message_item_id = convertView.findViewById(R.id.message_item_id);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String type = list.get(position).getType();
        String isLook = list.get(position).getIslook();
        //转入
        if (type.equals("0")) {
            //未查看
            if (isLook.equals("0")) {
                holder.message_iem_icon.setImageResource(R.drawable.gonggao_yes);
                holder.message_item_title.setTextColor(Color.parseColor("#FF7225"));
            } else if (isLook.equals("1")) {
                holder.message_iem_icon.setImageResource(R.drawable.gonggao_no);
                holder.message_item_title.setTextColor(Color.parseColor("#999999"));
            }
            holder.message_item_title.setText(list.get(position).getTitle());
            holder.message_item_time.setText(list.get(position).getTime());
            holder.message_item_content.setText(list.get(position).getContent() + " bidt转入接收成功");
            holder.message_item_id.setText("发送方-区块ID" + list.get(position).getId());
        } else if (type.equals("1")) {
            //未查看
            if (isLook.equals("0")) {
                holder.message_iem_icon.setImageResource(R.drawable.gonggao_yes);
                holder.message_item_title.setTextColor(Color.parseColor("#FF7225"));
            } else if (isLook.equals("1")) {
                holder.message_iem_icon.setImageResource(R.drawable.gonggao_no);
                holder.message_item_title.setTextColor(Color.parseColor("#999999"));
            }
            holder.message_item_title.setText(list.get(position).getTitle());
            holder.message_item_time.setText(list.get(position).getTime());
            holder.message_item_content.setText(list.get(position).getContent() + " bidt转出成功");
            holder.message_item_id.setText("发送方-区块ID" + list.get(position).getId());
        }
        return convertView;

    }

    class ViewHolder {
        ImageView message_iem_icon;
        TextView message_item_title;
        TextView message_item_time;
        TextView message_item_content;
        TextView message_item_id;
    }
}
