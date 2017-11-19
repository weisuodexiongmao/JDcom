package com.bawei.jingdong.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.jingdong.Bean.Classify1;
import com.bawei.jingdong.Bean.Classify2;
import com.bawei.jingdong.Bean.LoginBean;
import com.bawei.jingdong.P.Presenter;
import com.bawei.jingdong.R;
import com.bawei.jingdong.V.MvpView;

/**
 * Created by 猥琐的熊猫 on 2017/11/7.
 */

public class Logn_activity extends AppCompatActivity implements MvpView{

    private EditText editText,editText2;
    private String name;
    private String pass;
    private SharedPreferences sp;
    private String username;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logn_activity);

        editText = (EditText) findViewById(R.id.logneditText);
        editText2= (EditText) findViewById(R.id.logneditText2);
    }
    public void register(View v){
        startActivity(new Intent(Logn_activity.this,Register_activity.class));
    }
    public void denglu(View v){
        name = editText.getText().toString();
        pass = editText2.getText().toString();
        Presenter presenter = new Presenter(this);
        presenter.getData4();

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

    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String pass() {
        return null;
    }

    @Override
    public void getData4(LoginBean loginBean) {
        String code = loginBean.getCode();
        String msg = loginBean.getMsg();
        int uid = loginBean.getData().getUid();
        username = loginBean.getData().getUsername();
        String token = loginBean.getData().getToken();
        if (code.equals("0")){
            Toast.makeText(Logn_activity.this,msg,Toast.LENGTH_SHORT).show();
            sp=getSharedPreferences("user",MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putBoolean("is",true);
            edit.putString("name",username);
            edit.putString("uid",uid+"");
            edit.putString("token",token);
            edit.commit();
            startActivity(new Intent(Logn_activity.this,MainActivity.class));
        }else {
            Toast.makeText(Logn_activity.this,msg,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public String logn_name() {
        return name;
    }

    @Override
    public String logn_pass() {
        return pass;
    }
}
