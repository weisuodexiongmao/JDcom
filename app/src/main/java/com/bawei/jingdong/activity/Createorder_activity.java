package com.bawei.jingdong.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jingdong.Bean.Createsucceed_Bean;
import com.bawei.jingdong.Bean.Getdefaultaddress_Bean;
import com.bawei.jingdong.R;
import com.bawei.jingdong.utils.GsonObjectCallback;
import com.bawei.jingdong.utils.OkHttp3Utils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by 猥琐的熊猫 on 2017/11/17.
 */

public class Createorder_activity extends AppCompatActivity {

    private TextView textview,textView2,textView3,textView4;
    private SimpleDraweeView simpleDraweeView;
    private SharedPreferences sp;
    private TextView name,phone,site;
    private String price;
    private String subhead;
    private String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.createorder);
        sp = getSharedPreferences("user", MODE_PRIVATE);
        textview = (TextView) findViewById(R.id.createorder_texttitle);
        textView2= (TextView) findViewById(R.id.createorder_textprice);
        textView3= (TextView) findViewById(R.id.createorder_textprice2);
        textView4= (TextView) findViewById(R.id.createorder_textprice3);
        name = (TextView) findViewById(R.id.createorder_textname);
        phone= (TextView) findViewById(R.id.createorder_textphone);
        site= (TextView) findViewById(R.id.createorder_dizhi);
        simpleDraweeView = (SimpleDraweeView) findViewById(R.id.createorder_sdv);
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        subhead = intent.getStringExtra("split");
        price = intent.getStringExtra("price");
        textview.setText(title);
        textView2.setText("¥"+ price);
        textView3.setText(price);
        textView4.setText("实付款：¥"+ price);
        simpleDraweeView.setImageURI(subhead);
        okhhtp();

    }

public void okhhtp(){
    Map<String,String>map=new HashMap<>();
    map.put("uid",sp.getString("uid",""));
    map.put("token",sp.getString("token",""));
    OkHttp3Utils.doPost("https://www.zhaoapi.cn/user/getDefaultAddr", map, new GsonObjectCallback<Getdefaultaddress_Bean>() {
        @Override
        public void onUi(Getdefaultaddress_Bean getdefaultaddress_bean) {
            Getdefaultaddress_Bean.DataBean data = getdefaultaddress_bean.getData();
               name.setText(data.getName());
               phone.setText(data.getMobile()+"");
               site.setText(data.getAddr());
        }

        @Override
        public void onFailed(Call call, IOException e) {

        }
    });
}
public void placeanorder(View v){
    Map<String,String>map=new HashMap<>();
    map.put("uid",sp.getString("uid",""));
    map.put("price",price);
OkHttp3Utils.doPost("https://www.zhaoapi.cn/product/createOrder", map, new GsonObjectCallback<Createsucceed_Bean>() {
    @Override
    public void onUi(Createsucceed_Bean createsucceed_bean) {
        if (createsucceed_bean.getCode().equals("0")){
            Toast.makeText(Createorder_activity.this,createsucceed_bean.getMsg(),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Createorder_activity.this, orderlist_activity.class);
            intent.putExtra("image",subhead);
            intent.putExtra("name",title);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(Createorder_activity.this,createsucceed_bean.getMsg(),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFailed(Call call, IOException e) {

    }
});
}
}
