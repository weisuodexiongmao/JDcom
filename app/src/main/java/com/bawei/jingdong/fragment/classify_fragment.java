package com.bawei.jingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.jingdong.Bean.Classify1;
import com.bawei.jingdong.Bean.Classify2;
import com.bawei.jingdong.Bean.LoginBean;
import com.bawei.jingdong.P.Presenter;
import com.bawei.jingdong.R;
import com.bawei.jingdong.V.MvpView;
import com.bawei.jingdong.adapter.Classify_Rlv2adapter;
import com.bawei.jingdong.adapter.Classify_Rlvadapter;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2017/11/6.
 */

public class classify_fragment extends Fragment implements MvpView{

    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private int cid;
    private Presenter presenter;
    private List<Classify2.DataBean.ListBean> list1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.classify_fragment, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.rlv1);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.rlv2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter = new Presenter(this);
        presenter.getData();
        return view;
    }

    @Override
    public void getdata(Classify1 bean) {
        final List<Classify1.DataBean> data = bean.getData();
        for (Classify1.DataBean list:data){
            System.out.println("********"+list.getName());
        }
        Classify_Rlvadapter classify_rlvadapter=new Classify_Rlvadapter(getActivity(),data);
        recyclerView.setAdapter(classify_rlvadapter);
        classify_rlvadapter.setOnitemclick(new Classify_Rlvadapter.OnitemclickListenter() {



            @Override
            public void onitemclick(View view, int position) {
                cid = data.get(position).getCid();
                System.out.println(">>>>>>>>>>>>>>>>>>>>"+cid);
                presenter.getData2();

            }
        });
    }

    @Override
    public void getData2(Classify2 bean) {
        List<Classify2.DataBean> data = bean.getData();
        Classify_Rlv2adapter rlv2adapter = new Classify_Rlv2adapter(getActivity(), data);
       recyclerView2.setAdapter(rlv2adapter);
    }

    @Override
    public String cid() {
        return cid+"";
    }

    @Override
    public void getData3(String s) {

    }



    @Override
    public String name() {
        return null;
    }

    @Override
    public String pass() {
        return null;
    }

    @Override
    public void getData4(LoginBean loginBean) {

    }

    @Override
    public String logn_name() {
        return null;
    }

    @Override
    public String logn_pass() {
        return null;
    }


}
