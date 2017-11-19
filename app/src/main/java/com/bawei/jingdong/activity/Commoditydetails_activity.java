package com.bawei.jingdong.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jingdong.Bean.Addshopping_Bean;
import com.bawei.jingdong.Bean.Commodity_Bean;
import com.bawei.jingdong.P.Commodity_Presenter;
import com.bawei.jingdong.R;
import com.bawei.jingdong.V.Commodity_view;
import com.bawei.jingdong.adapter.Commodity_vpadapter;

/**
 * Created by 猥琐的熊猫 on 2017/11/9.
 */

public class Commoditydetails_activity extends AppCompatActivity implements Commodity_view {

    private ViewPager vp;
    private TextView textView1,textView2,textView3,textView4,textView5;
    private String pid;
    private Commodity_Presenter commodity_presenter;
    private String uid;
    private int addpid;
    private SharedPreferences sp;
    private String title;
    private String subhead;
    private String price;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.commoditydetails);
        vp= (ViewPager) findViewById(R.id.vp);
        sp = getSharedPreferences("user", MODE_PRIVATE);
        textView1 = (TextView) findViewById(R.id.commodity_text1);
        textView2 = (TextView) findViewById(R.id.commodity_text2);
        textView3= (TextView) findViewById(R.id.commodity_text3);
        textView4= (TextView) findViewById(R.id.commodity_gouwuche);
        textView5= (TextView) findViewById(R.id.zhifu);

        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        commodity_presenter = new Commodity_Presenter(this);
        commodity_presenter.getData();
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delog();
            }
        });

    }
public void delog(){
    AlertDialog.Builder dialog=new AlertDialog.Builder(Commoditydetails_activity.this);
    dialog.setTitle("加入购物车");
    dialog.setNegativeButton("取消",null);
    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            uid = sp.getString("uid", null);
            commodity_presenter.addgetData();


        }
    });
    dialog.create();
     dialog.show();
}
    @Override
    public void getdata(Commodity_Bean commodity_bean) {
        String msg = commodity_bean.getData().getImages();
        addpid = commodity_bean.getData().getPid();
        final String[] split = msg.split("\\|");

        vp.setAdapter(new Commodity_vpadapter(Commoditydetails_activity.this,split));

        title = commodity_bean.getData().getTitle();
        subhead = commodity_bean.getData().getSubhead();
        price = commodity_bean.getData().getPrice() + "";
        textView1.setText(title);
        textView3.setText(price);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Commoditydetails_activity.this,Createorder_activity.class);
                intent.putExtra("title",title);
                intent.putExtra("price",price);
                intent.putExtra("split",split[0]);
                startActivity(intent);
            }
        });
    }

    @Override
    public String pid() {
        return pid;
    }

    @Override
    public void getAddData(Addshopping_Bean addshopping_bean) {
        String msg = addshopping_bean.getMsg();
        if (addshopping_bean.getCode().equals("0")){
            Toast.makeText(Commoditydetails_activity.this,msg,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(Commoditydetails_activity.this,msg,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public String addpid() {
        return addpid+"";
    }

    @Override
    public String addUid() {
        return uid;
    }
}
