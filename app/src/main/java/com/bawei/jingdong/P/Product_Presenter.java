package com.bawei.jingdong.P;

import com.bawei.jingdong.Bean.Productlist_Bean;
import com.bawei.jingdong.M.Productlist_Mod;
import com.bawei.jingdong.V.Product_view;

/**
 * Created by 猥琐的熊猫 on 2017/11/9.
 */

public class Product_Presenter {
    private Product_view product_view;
    private Productlist_Mod mod;
    public Product_Presenter(Product_view product_view) {
        this.product_view = product_view;
        this.mod=new Productlist_Mod();
    }
    public void presen(){
        mod.getData(new Productlist_Mod.ProductData() {
            @Override
            public void getdata(Productlist_Bean productlist_bean) {
                product_view.getData(productlist_bean);
            }
        },product_view.pscid());
    }
}
