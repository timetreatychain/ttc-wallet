package com.example.administrator.ttc.weight;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.ttc.R;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * Created by Administrator on 2018/8/22/022.
 */

public class OutPopupWindow extends PopupWindow {

    private final View out_popupwindow;
    private final TextView out_popup_id;
    private final TextView out_popup_address;
    private final Button out_popup_next_button;
    private final ImageView out_popup_close_img;

    public OutPopupWindow(final Activity context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        out_popupwindow = inflater.inflate(R.layout.out_popupwindow, null);
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        this.setContentView(out_popupwindow);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.setBackgroundDrawable(new BitmapDrawable()); //这样设置才能点击屏幕外 dismiss窗口
        out_popup_close_img = out_popupwindow.findViewById(R.id.out_popup_close_img);
        out_popup_id = out_popupwindow.findViewById(R.id.out_popup_id);
        out_popup_address = out_popupwindow.findViewById(R.id.out_popup_address);
        out_popup_next_button = out_popupwindow.findViewById(R.id.out_popup_next_button);
        out_popup_close_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    /***********************以下部分回传View,供调用处方便使用*************************/
    //区块ID
    public TextView getIdView() {
        return out_popup_id;
    }

    //地址
    public TextView getPublishView() {
        return out_popup_address;
    }

    //确认按钮
    public Button getNextButton() {
        return out_popup_next_button;
    }

    /**
     * 按钮的点击事件
     */

    //确认按钮的监听
    public void setOnNextListener(View.OnClickListener listener) {
        out_popup_next_button.setOnClickListener(listener);
    }


    /**
     * 显示popupWindow
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        } else {
            this.dismiss();
        }
    }
}
