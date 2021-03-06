package com.bawei.jingdong.M;

import com.bawei.jingdong.Bean.Classify1;
import com.bawei.jingdong.interceptor.LoggingInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2017/11/6.
 */

public class Classify1Mod {
    public void getNoParams(final Data d){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();

        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.BASE_PATH).addConverterFactory(GsonConverterFactory.create())
                //支持Rxjava
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        Api_classify api_classify = retrofit.create(Api_classify.class);
        //得到Observable被观察者      生产时间 得到数据源
        Observable<Classify1> classify1 = api_classify.classify1();
        //被观察者订阅观察者  默认在同一个线程
        classify1
                //指定io线程做耗时操作
                .subscribeOn(Schedulers.io())
                //指定更新UI在主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Classify1>() {
                    @Override
                    public void onCompleted() {//完成

                    }

                    @Override
                    public void onError(Throwable e) {//失败

                    }

                    @Override
                    public void onNext(Classify1 classify1) {
                        d.shuju(classify1);
                    }


                });

    }
    public interface Data{
        void shuju(Classify1 bean);
    }
}
