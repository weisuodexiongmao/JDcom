package com.bawei.jingdong.P;

import com.bawei.jingdong.Bean.Classify1;
import com.bawei.jingdong.Bean.Classify2;
import com.bawei.jingdong.Bean.LoginBean;
import com.bawei.jingdong.M.Classify1Mod;
import com.bawei.jingdong.M.Classify2Mod;
import com.bawei.jingdong.M.LoginMod;
import com.bawei.jingdong.M.RegisterMod;
import com.bawei.jingdong.V.MvpView;

/**
 * Created by 猥琐的熊猫 on 2017/11/6.
 */

public class Presenter {
    private MvpView mvpView;
    private Classify1Mod mod;
    private Classify2Mod mod2;
    private RegisterMod registerMod;
    private LoginMod loginMod;
    public Presenter(MvpView mvpView) {
        this.mvpView = mvpView;
        this.mod=new Classify1Mod();
        this.mod2=new Classify2Mod();
        this.registerMod=new RegisterMod();
        this.loginMod=new LoginMod();
    }


    public void getData(){
        mod.getNoParams(new Classify1Mod.Data() {
            @Override
            public void shuju(Classify1 bean) {
                mvpView.getdata(bean);
            }
        });
    }
    public void getData2(){
        mod2.getNoParams(new Classify2Mod.Data() {
            @Override
            public void shuju(Classify2 bean) {
                mvpView.getData2(bean);
            }
        },mvpView.cid());
    }
        //注册
    public void getData3() throws InterruptedException {
        registerMod.runRegist(new RegisterMod.getData() {
            @Override
            public void Data(String string) {
                mvpView.getData3(string);
            }
        },mvpView.name(),mvpView.pass());
    }


    //登录
    public void getData4(){
        loginMod.Shuju(new LoginMod.getData4() {
            @Override
            public void data4(LoginBean loginBean) {
                mvpView.getData4(loginBean);
            }
        },mvpView.logn_name(),mvpView.logn_pass());
    }
}
