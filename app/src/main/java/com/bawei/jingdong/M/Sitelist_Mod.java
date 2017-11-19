package com.bawei.jingdong.M;

import com.bawei.jingdong.Bean.Sitelist_Bean;
import com.bawei.jingdong.utils.GsonObjectCallback;
import com.bawei.jingdong.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by 猥琐的熊猫 on 2017/11/16.
 */

public class Sitelist_Mod {
    public void SitelistData(final getSitelist sitelist, String uid, String token){
        Map<String,String>map=new HashMap<>();
        map.put("uid",uid);
        map.put("token",token);
        OkHttp3Utils.doPost("https://www.zhaoapi.cn/user/getAddrs", map, new GsonObjectCallback<Sitelist_Bean>() {
            @Override
            public void onUi(Sitelist_Bean sitelist_bean) {
                sitelist.getData(sitelist_bean);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
    public interface getSitelist{
        void getData(Sitelist_Bean sitelist_bean);
    }
}


