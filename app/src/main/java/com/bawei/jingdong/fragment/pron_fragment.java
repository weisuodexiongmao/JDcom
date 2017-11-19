package com.bawei.jingdong.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.jingdong.R;
import com.bawei.jingdong.activity.Logn_activity;
import com.bawei.jingdong.activity.Receiving_activity;
import com.bawei.jingdong.activity.orderlist_activity;

/**
 * Created by 猥琐的熊猫 on 2017/11/7.
 */

public class pron_fragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.pron_fragment, null);
        ImageView imageView= (ImageView) view.findViewById(R.id.Receiving_image);
        TextView textView= (TextView) view.findViewById(R.id.logn_textview);
        ImageView imageView1= (ImageView) view.findViewById(R.id.dingdan);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), orderlist_activity.class));
            }
        });
        TextView textView1= (TextView) view.findViewById(R.id.username);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Receiving_activity.class));
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Logn_activity.class));
            }
        });
        SharedPreferences sp = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        boolean is = sp.getBoolean("is", false);
        String name = sp.getString("name", null);
        if (is){
            textView.setVisibility(View.GONE);
            textView1.setVisibility(View.VISIBLE);
            textView1.setText(name);
        }
        return view;

    }


}
