package com.bawei.jingdong.V;

import com.bawei.jingdong.Bean.Site_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/11/16.
 *
 *           uid
 addr
 mobile
 name
 token

 *
 */

public interface Site_view {
    void getsiteData(Site_Bean site_bean);
    String Site_uid();
    String Site_addr();
    String Site_mobile();
    String Site_name();
    String Site_token();

}
