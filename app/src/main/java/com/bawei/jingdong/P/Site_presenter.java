package com.bawei.jingdong.P;

import com.bawei.jingdong.Bean.Site_Bean;
import com.bawei.jingdong.M.Site_mod;
import com.bawei.jingdong.V.Site_view;

/**
 * Created by 猥琐的熊猫 on 2017/11/16.
 */

public class Site_presenter {
private Site_view site_view;
private Site_mod site_mod;
    public Site_presenter(Site_view site_view) {
        this.site_view = site_view;
        this.site_mod=new Site_mod();
    }
    public void getData(){
        site_mod.siteData(new Site_mod.sitegetData() {
            @Override
            public void data(Site_Bean site_bean) {
                site_view.getsiteData(site_bean);
            }
        },site_view.Site_uid(),site_view.Site_addr(),site_view.Site_mobile(),site_view.Site_name(),site_view.Site_token());
    }
}
