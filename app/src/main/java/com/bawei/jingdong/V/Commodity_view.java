package com.bawei.jingdong.V;

import com.bawei.jingdong.Bean.Addshopping_Bean;
import com.bawei.jingdong.Bean.Commodity_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/11/9.
 */

public interface Commodity_view {
    void getdata(Commodity_Bean commodity_bean);
    String pid();
    //添加购物车
    void getAddData(Addshopping_Bean addshopping_bean);
    String addpid();
    String addUid();
}
