package com.bawei.jingdong.M;

import com.bawei.jingdong.Bean.Addshopping_Bean;
import com.bawei.jingdong.utils.GsonObjectCallback;
import com.bawei.jingdong.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by 猥琐的熊猫 on 2017/11/10.
 */

public class Addshoppingcart_Mod {
    public void addgetData(final addData data,String uid,String pid){
        Map<String,String>map=new HashMap<>();
        map.put("uid",uid);
        map.put("pid",pid);
        OkHttp3Utils.doPost("http://120.27.23.105/product/addCart", map, new GsonObjectCallback<Addshopping_Bean>() {
            @Override
            public void onUi(Addshopping_Bean addshopping_bean) {
                data.Data(addshopping_bean);

            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
    public interface addData{
        void Data(Addshopping_Bean addshopping_bean);
    }
}
