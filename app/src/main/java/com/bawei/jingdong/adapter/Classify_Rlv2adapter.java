package com.bawei.jingdong.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.jingdong.Bean.Classify2;
import com.bawei.jingdong.R;
import com.bawei.jingdong.activity.Productlist_activity;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2017/11/6.
 */

public class Classify_Rlv2adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
 private Context context;
private List<Classify2.DataBean>list;
    public Classify_Rlv2adapter(Context context, List<Classify2.DataBean> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.classify_rlv2item, parent, false);
        return new VHitem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    VHitem vHitem= (VHitem) holder;
        vHitem.textView.setText(list.get(position).getName());
        vHitem.recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        final List<Classify2.DataBean.ListBean> list = this.list.get(position).getList();
        Classify_Rlv3adapter classify_rlv3adapter = new Classify_Rlv3adapter(context, list);
        vHitem.recyclerView.setAdapter(classify_rlv3adapter);
        classify_rlv3adapter.setOnitemclick(new Classify_Rlv3adapter.OnitemclickListenter() {
            @Override
            public void onitemclick(Classify2.DataBean.ListBean bean) {
                String pscid=bean.getPscid()+"";
                Intent intent=new Intent(context,Productlist_activity.class);
                intent.putExtra("pscid",pscid);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class VHitem extends RecyclerView.ViewHolder{
         TextView textView;
        RecyclerView recyclerView;
        public VHitem(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.rlv2textView);
            recyclerView= (RecyclerView) itemView.findViewById(R.id.rlv3);
        }
    }
}
