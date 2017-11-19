package com.bawei.jingdong.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.jingdong.Bean.Sitelist_Bean;
import com.bawei.jingdong.P.Sitelist_presenter;
import com.bawei.jingdong.R;
import com.bawei.jingdong.V.Sitilist_view;
import com.bawei.jingdong.adapter.Sitelist_Adapter;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2017/11/16.
 */

public class Receiving_activity extends AppCompatActivity implements Sitilist_view{

    private String uid;
    private String token;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.receiving);
        recyclerView = (RecyclerView) findViewById(R.id.Receiving_Rlv);
        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
        uid = sp.getString("uid", "");
        token = sp.getString("token", "");
        Sitelist_presenter sitelist_presenter=new Sitelist_presenter(this);
        sitelist_presenter.presen();



    }
    public void xinjiandizhi(View v){
        startActivity(new Intent(Receiving_activity.this,Newsite.class));
        finish();
    }

    @Override
    public void getsitilistData(Sitelist_Bean sitelist_bean) {
        List<Sitelist_Bean.DataBean> data = sitelist_bean.getData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Sitelist_Adapter(data,Receiving_activity.this));
    }

    @Override
    public String Sitilist_uid() {
        return uid;
    }

    @Override
    public String Sitilist_token() {
        return token;
    }
}
