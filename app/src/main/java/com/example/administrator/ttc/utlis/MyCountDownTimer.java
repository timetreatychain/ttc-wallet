package com.example.administrator.ttc.utlis;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/9/4/004.
 */

public class MyCountDownTimer extends CountDownTimer {

    private TextView button;

    public MyCountDownTimer(long millisInFuture, long countDownInterval, TextView button) {
        super(millisInFuture, countDownInterval);
        this.button = button;
    }

    //计时过程
    @Override
    public void onTick(long l) {
        //防止计时过程中重复点击
        button.setClickable(false);
        button.setText(l / 1000 + "秒");

    }

    //计时完毕的方法
    @Override
    public void onFinish() {
        //重新给Button设置文字
        button.setText("重新获取");
        //设置可点击
        button.setClickable(true);
    }
}

