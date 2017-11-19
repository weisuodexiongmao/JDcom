package com.bawei.jingdong.M;

import com.bawei.jingdong.Bean.bean_shopp;
import com.bawei.jingdong.utils.GsonObjectCallback;
import com.bawei.jingdong.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by 猥琐的熊猫 on 2017/11/10.
 */

public class shoppingcart_Mod {
    public void shoppingcartData(final shoppingData data, String uid,String token){
        Map<String,String>map=new HashMap<>();
        map.put("uid",uid);
        map.put("token",token);
        OkHttp3Utils.doPost("https://www.zhaoapi.cn/product/getCarts", map, new GsonObjectCallback<bean_shopp>() {
            @Override
            public void onUi(bean_shopp bean_shopp) {
                data.shopping(bean_shopp);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
    public interface shoppingData{
        void shopping(bean_shopp bean_shopp);
    }
}
