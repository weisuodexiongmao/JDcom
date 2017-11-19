package com.bawei.jingdong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.jingdong.Bean.Productlist_Bean;
import com.bawei.jingdong.P.Product_Presenter;
import com.bawei.jingdong.R;
import com.bawei.jingdong.V.Product_view;
import com.bawei.jingdong.adapter.Product_Rlvadapter;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2017/11/9.
 */

public class Productlist_activity extends AppCompatActivity implements Product_view{


    private RecyclerView recyclerView;
    private String pscid;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.productlist);
        recyclerView = (RecyclerView) findViewById(R.id.productlist_Rlv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        pscid = intent.getStringExtra("pscid");
        Product_Presenter product_presenter=new Product_Presenter(this);
        product_presenter.presen();

    }

    @Override
    public void getData(Productlist_Bean productlist_bean) {
        List<Productlist_Bean.DataBean> data = productlist_bean.getData();
        Product_Rlvadapter product_rlvadapter = new Product_Rlvadapter(Productlist_activity.this, data);
        recyclerView.setAdapter(product_rlvadapter);
        product_rlvadapter.setOnitemclinck(new Product_Rlvadapter.Onitemclincklisenter() {
            @Override
            public void Onitemlisck(Productlist_Bean.DataBean dataBean) {
                int pid = dataBean.getPid();
                Intent intent=new Intent(Productlist_activity.this,Commoditydetails_activity.class);
                intent.putExtra("pid",pid+"");
                startActivity(intent);
            }
        });
    }

    @Override
    public String pscid() {
        return pscid;
    }
}
