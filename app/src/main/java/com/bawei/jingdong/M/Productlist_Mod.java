package com.bawei.jingdong.M;

import com.bawei.jingdong.Bean.Productlist_Bean;
import com.bawei.jingdong.utils.GsonObjectCallback;
import com.bawei.jingdong.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by 猥琐的熊猫 on 2017/11/9.
 */

public class Productlist_Mod {
    public void getData(final ProductData data, String pscid){
        Map<String,String>map=new HashMap<>();
        map.put("pscid",pscid);
        OkHttp3Utils.doPost("https://www.zhaoapi.cn/product/getProducts", map, new GsonObjectCallback<Productlist_Bean>() {
            @Override
            public void onUi(Productlist_Bean productlist_bean) {
                data.getdata(productlist_bean);

            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
    public interface ProductData {
        void getdata(Productlist_Bean productlist_bean);
    }
}
