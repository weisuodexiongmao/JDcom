package com.bawei.jingdong.M;

import com.bawei.jingdong.Bean.LoginBean;
import com.bawei.jingdong.utils.GsonObjectCallback;
import com.bawei.jingdong.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by 猥琐的熊猫 on 2017/11/8.
 */

public class LoginMod {

    public void Shuju(final getData4 data,String name,String pass){
        Map<String,String>map=new HashMap<>();
        map.put("mobile",name);
        map.put("password",pass);
        OkHttp3Utils.doPost("https://www.zhaoapi.cn/user/login", map, new GsonObjectCallback<LoginBean>() {
            @Override
            public void onUi(LoginBean loginBean) {
                data.data4(loginBean);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
    public interface getData4{
        void data4(LoginBean loginBean);
    }
}
