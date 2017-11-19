package com.bawei.jingdong.M;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 猥琐的熊猫 on 2017/11/7.
 */

public class RegisterMod {
    public void runRegist(final getData data , final String name, final String pass) throws InterruptedException {
        //处理注册逻辑
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               OkHttpClient okhttpclient = new OkHttpClient();
                RequestBody formBody = new FormBody.Builder()
                        .add("mobile", name)
                        .add("password",pass)
                        .build();
                Request request = new Request.Builder()
                        .url("https://www.zhaoapi.cn/user/reg")
                        .post(formBody)
                        .build();
                try {
                    Response response = okhttpclient.newCall(request).execute();
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code " + response);
                    }
                    String result = response.body().string();
                   data.Data(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t1.join();
    }
    public interface getData{
        void Data(String string);
    }
}
