package com.bawei.jingdong.P;

import com.bawei.jingdong.Bean.Sitelist_Bean;
import com.bawei.jingdong.M.Sitelist_Mod;
import com.bawei.jingdong.V.Sitilist_view;

/**
 * Created by 猥琐的熊猫 on 2017/11/16.
 */

public class Sitelist_presenter {
private Sitilist_view sitilist_view;
private Sitelist_Mod sitelist_mod;
    public Sitelist_presenter(Sitilist_view sitilist_view) {
        this.sitilist_view = sitilist_view;
        this.sitelist_mod=new Sitelist_Mod();
    }
    public void presen(){
        sitelist_mod.SitelistData(new Sitelist_Mod.getSitelist() {
            @Override
            public void getData(Sitelist_Bean sitelist_bean) {
                sitilist_view.getsitilistData(sitelist_bean);
            }
        },sitilist_view.Sitilist_uid(),sitilist_view.Sitilist_token());
    }
}
