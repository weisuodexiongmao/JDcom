package com.bawei.jingdong.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.jingdong.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by 猥琐的熊猫 on 2017/11/9.
 */

public class Commodity_vpadapter extends PagerAdapter{
    private Context context;
    private String[] a;

    public Commodity_vpadapter(Context context, String[] a) {
        this.context = context;
        this.a = a;
    }

    @Override
    public int getCount() {
        return a.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.vpitem, null);
        SimpleDraweeView simpleDraweeView= (SimpleDraweeView) view.findViewById(R.id.vp_Sdv);
        simpleDraweeView.setImageURI(a[position]);
        simpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      container.removeView((View) object);
    }
}
