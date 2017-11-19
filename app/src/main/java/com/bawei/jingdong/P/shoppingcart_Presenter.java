package com.bawei.jingdong.P;

import com.bawei.jingdong.Bean.bean_shopp;
import com.bawei.jingdong.M.shoppingcart_Mod;
import com.bawei.jingdong.V.shoppingcart_view;

/**
 * Created by 猥琐的熊猫 on 2017/11/10.
 */

public class shoppingcart_Presenter {
    private shoppingcart_view shoppingcart_view;
    private shoppingcart_Mod mod;
    public shoppingcart_Presenter(com.bawei.jingdong.V.shoppingcart_view shoppingcart_view) {
        this.shoppingcart_view = shoppingcart_view;
        this.mod=new shoppingcart_Mod();
    }
    public void getshoppingcartData(){
        mod.shoppingcartData(new shoppingcart_Mod.shoppingData() {
            @Override
            public void shopping(bean_shopp bean_shopp) {
                shoppingcart_view.getshoppingcartData(bean_shopp);
            }
        },shoppingcart_view.Uid(),shoppingcart_view.token());
    }
}
