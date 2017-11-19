package com.bawei.jingdong.M;

import com.bawei.jingdong.Bean.Commodity_Bean;
import com.bawei.jingdong.utils.GsonObjectCallback;
import com.bawei.jingdong.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by 猥琐的熊猫 on 2017/11/9.
 */

public class Commoditydetails_Mod {
    public void commodity(final getData  data, String pid){
        Map<String,String>map=new HashMap<>();
        map.put("pid",pid);
        OkHttp3Utils.doPost("https://www.zhaoapi.cn/product/getProductDetail", map, new GsonObjectCallback<Commodity_Bean>() {
            @Override
            public void onUi(Commodity_Bean commodity_bean) {
              data.commoditydata(commodity_bean);

            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
    public interface getData{
      void commoditydata(Commodity_Bean commodity_bean);
    }
}
