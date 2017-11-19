package com.bawei.jingdong.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/9/8 12:33
 */

public class MyApp extends Application {
    public static MyApp mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Fresco.initialize(this);
    }
    public static MyApp getInstance() {
        return mInstance;
    }
}
