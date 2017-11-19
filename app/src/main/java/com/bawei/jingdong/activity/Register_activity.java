package com.bawei.jingdong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.jingdong.Bean.Classify1;
import com.bawei.jingdong.Bean.Classify2;
import com.bawei.jingdong.Bean.LoginBean;
import com.bawei.jingdong.Bean.Register_Bean;
import com.bawei.jingdong.P.Presenter;
import com.bawei.jingdong.R;
import com.bawei.jingdong.V.MvpView;
import com.google.gson.Gson;

/**
 * Created by 猥琐的熊猫 on 2017/11/7.
 */

public class Register_activity extends AppCompatActivity implements MvpView {

    private EditText editText,editText2;
    private String name;
    private String pass;
    private String name1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.register_activity);
        editText = (EditText) findViewById(R.id.registereditText1);
        editText2 = (EditText) findViewById(R.id.registereditText2);

    }
    public void zhuce(View v) throws InterruptedException {
        name = editText.getText().toString();
        pass = editText2.getText().toString();
        Presenter presenter = new Presenter(this);
        presenter.getData3();
        Toast.makeText(Register_activity.this, name1,Toast.LENGTH_LONG).show();

    }
   public void fanhui(View v){
       finish();
   }
    @Override
    public void getdata(Classify1 bean) {

    }

    @Override
    public void getData2(Classify2 bean) {

    }

    @Override
    public String cid() {
        return null;
    }

    @Override
    public void getData3(String s) {
        Gson gson=new Gson();
        Register_Bean register_bean = gson.fromJson(s, Register_Bean.class);
        name1 = register_bean.getMsg();
        System.out.println("////*****"+ name1);
        if (register_bean.getCode().equals("0")){
            startActivity(new Intent(Register_activity.this,Logn_activity.class));
              finish();
        }
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String pass() {
        return pass;
    }

    @Override
    public void getData4(LoginBean loginBean) {

    }

    @Override
    public String logn_name() {
        return null;
    }

    @Override
    public String logn_pass() {
        return null;
    }
}
