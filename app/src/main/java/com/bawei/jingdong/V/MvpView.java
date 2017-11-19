package com.bawei.jingdong.V;

import com.bawei.jingdong.Bean.Classify1;
import com.bawei.jingdong.Bean.Classify2;
import com.bawei.jingdong.Bean.LoginBean;
import com.bawei.jingdong.Bean.Register_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/11/6.
 */

public interface MvpView {
    void getdata(Classify1 bean);
    void getData2(Classify2 bean);
   String cid();
    //注册
    void getData3(String s);
    String name();
    String pass();
    //登录
    void getData4(LoginBean loginBean);
    String logn_name();
    String logn_pass();

}
