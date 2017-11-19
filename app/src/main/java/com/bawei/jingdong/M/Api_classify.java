package com.bawei.jingdong.M;

import com.bawei.jingdong.Bean.Classify1;
import com.bawei.jingdong.Bean.Classify2;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 猥琐的熊猫 on 2017/11/6.
 */

public interface Api_classify {
    @GET
            ("getCatagory")
       Observable<Classify1> classify1();

    @GET("getProductCatagory")
    Observable<Classify2> classify2(@Query("cid")String str);


}
