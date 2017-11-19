package com.bawei.jingdong.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.jingdong.Bean.Site_Bean;
import com.bawei.jingdong.P.Site_presenter;
import com.bawei.jingdong.R;
import com.bawei.jingdong.V.Site_view;

/**
 * Created by 猥琐的熊猫 on 2017/11/16.
 */

public class Newsite extends AppCompatActivity implements Site_view{

    private EditText nametext,phonetext,dizhitext;
    private String uid;
    private String token;
    private String name;
    private String phone;
    private String dizhi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           setContentView(R.layout.newsite);
        nametext = (EditText) findViewById(R.id.site_edit);
        phonetext= (EditText) findViewById(R.id.site_edit2);
        dizhitext= (EditText) findViewById(R.id.site_edit3);
    }
    public void save(View v){

        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
        uid = sp.getString("uid", "");
        token = sp.getString("token", "");
        name = nametext.getText().toString();
        phone = phonetext.getText().toString();
        dizhi = dizhitext.getText().toString();
        Site_presenter site_presenter = new Site_presenter(this);
        site_presenter.getData();
        startActivity(new Intent(this,Receiving_activity.class));
         finish();
    }

    @Override
    public void getsiteData(Site_Bean site_bean) {
        String code = site_bean.getCode();
        String msg = site_bean.getMsg();
        if (code.equals("0")){
            Toast.makeText(Newsite.this,msg,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(Newsite.this,msg,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public String Site_uid() {
        return uid;
    }

    @Override
    public String Site_addr() {
        return dizhi;
    }

    @Override
    public String Site_mobile() {
        return phone;
    }

    @Override
    public String Site_name() {
        return name;
    }

    @Override
    public String Site_token() {
        return token;
    }
}
