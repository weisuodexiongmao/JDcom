package com.bawei.jingdong.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.bawei.jingdong.R;
import com.bawei.jingdong.fragment.Shopp;
import com.bawei.jingdong.fragment.classify_fragment;
import com.bawei.jingdong.fragment.pron_fragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView1= (ImageView) findViewById(R.id.shouyeimage);
        ImageView imageView2= (ImageView) findViewById(R.id.fenleiimage);
        ImageView imageView3= (ImageView) findViewById(R.id.faxianimage);
        ImageView imageView4= (ImageView) findViewById(R.id.gouwucheimage);
        ImageView imageView5= (ImageView) findViewById(R.id.wodeimage);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
           switch (v.getId()){
               case R.id.shouyeimage:

                   break;
               case R.id.fenleiimage:
             add(new classify_fragment());
                   break;
               case R.id.faxianimage:

                   break;
               case R.id.gouwucheimage:
                   add(new Shopp());
                   break;
               case R.id.wodeimage:
              add(new pron_fragment());
                   break;

           }
    }
    public void add(Fragment f){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.replace(R.id.fra,f).commit();
    }
}
