package com.bawei.jingdong.V;

import com.bawei.jingdong.Bean.bean_shopp;

/**
 * Created by 猥琐的熊猫 on 2017/11/10.
 */

public interface shoppingcart_view {
    void getshoppingcartData(bean_shopp bean_shopp);
    String Uid();
    String token();
}
