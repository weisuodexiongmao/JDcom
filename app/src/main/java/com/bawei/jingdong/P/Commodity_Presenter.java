package com.bawei.jingdong.P;

import com.bawei.jingdong.Bean.Addshopping_Bean;
import com.bawei.jingdong.Bean.Commodity_Bean;
import com.bawei.jingdong.M.Addshoppingcart_Mod;
import com.bawei.jingdong.M.Commoditydetails_Mod;
import com.bawei.jingdong.V.Commodity_view;

/**
 * Created by 猥琐的熊猫 on 2017/11/9.
 */

public class Commodity_Presenter {
    private Commodity_view commodity_view;
    private Commoditydetails_Mod mod;
    private Addshoppingcart_Mod addshoppingcart_mod;
    public Commodity_Presenter(Commodity_view commodity_view) {
        this.commodity_view = commodity_view;
        this.mod=new Commoditydetails_Mod();
        this.addshoppingcart_mod=new Addshoppingcart_Mod();
    }
    public void getData(){
        mod.commodity(new Commoditydetails_Mod.getData() {
            @Override
            public void commoditydata(Commodity_Bean commodity_bean) {
                  commodity_view.getdata(commodity_bean);
            }
        },commodity_view.pid());
    }
    public void addgetData(){
        addshoppingcart_mod.addgetData(new Addshoppingcart_Mod.addData() {
            @Override
            public void Data(Addshopping_Bean addshopping_bean) {
               commodity_view.getAddData(addshopping_bean);
            }
        },commodity_view.addUid(),commodity_view.addpid());
    }
}
