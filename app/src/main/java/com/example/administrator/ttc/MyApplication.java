package com.example.administrator.ttc;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.view.View;

import com.wb.baselib.http.HttpConfig;

/**
 * Created by Administrator on 2018/8/14/014.
 */

public class MyApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpConfig httpConfig = new HttpConfig.HttpConfigBuilder()

                .setmBaseUrl("请求地址的域名（域名、域名、域名，重要的事情说三遍）")

                .setUseCustGson(true).build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}