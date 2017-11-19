package com.bawei.jingdong.M;

import com.bawei.jingdong.Bean.Site_Bean;
import com.bawei.jingdong.utils.GsonObjectCallback;
import com.bawei.jingdong.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by 猥琐的熊猫 on 2017/11/16.
 *
 *
 */

public class Site_mod {
    public void siteData(final sitegetData data, String uid, String addr, String mobile, String name, String token){
        Map<String,String>map=new HashMap<>();
        map.put("uid",uid);
        map.put("addr",addr);
        map.put("mobile",mobile);
        map.put("name",name);
        map.put("token",token);
        OkHttp3Utils.doPost("https://www.zhaoapi.cn/user/addAddr", map, new GsonObjectCallback<Site_Bean>() {
            @Override
            public void onUi(Site_Bean site_bean) {
                data.data(site_bean);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
    public interface sitegetData{
        void data(Site_Bean site_bean);
    }
}
