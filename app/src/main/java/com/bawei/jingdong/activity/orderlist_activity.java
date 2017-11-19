package com.bawei.jingdong.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.jingdong.Bean.Orderlist_Bean;
import com.bawei.jingdong.R;
import com.bawei.jingdong.adapter.OrderlistRlv_adapter;
import com.bawei.jingdong.utils.GsonObjectCallback;
import com.bawei.jingdong.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by 猥琐的熊猫 on 2017/11/17.
 */

public class orderlist_activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SharedPreferences sp;
    private String name;
    private String image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.orderlist);
        sp = getSharedPreferences("user", MODE_PRIVATE);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        image = intent.getStringExtra("image");
        okhttp();
        recyclerView = (RecyclerView) findViewById(R.id.orderlist_Rlv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    public void okhttp(){
        Map<String,String>map=new HashMap<>();
        map.put("uid",sp.getString("uid",""));
        map.put("token",sp.getString("token",""));
        OkHttp3Utils.doPost("https://www.zhaoapi.cn/product/getOrders", map, new GsonObjectCallback<Orderlist_Bean>() {
            @Override
            public void onUi(Orderlist_Bean orderlist_bean) {
                List<Orderlist_Bean.DataBean> data = orderlist_bean.getData();
                recyclerView.setAdapter(new OrderlistRlv_adapter(data,orderlist_activity.this,name,image));
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
