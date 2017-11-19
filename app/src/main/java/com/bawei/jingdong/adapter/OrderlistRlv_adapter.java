package com.bawei.jingdong.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.jingdong.Bean.Orderlist_Bean;
import com.bawei.jingdong.R;
import com.bawei.jingdong.zhifubao.PayDemoActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2017/11/17.
 */

public class OrderlistRlv_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
private List<Orderlist_Bean.DataBean>list;
    private Context context;
    private String name;
    private String image;

    public OrderlistRlv_adapter(List<Orderlist_Bean.DataBean> list, Context context, String name, String image) {
        this.list = list;
        this.context = context;
        this.name = name;
        this.image = image;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.orderlistrlv_item,parent,false);
        return new VHitem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VHitem vHitem= (VHitem) holder;
        vHitem.simpleDraweeView.setImageURI(image);
        vHitem.title.setText(name);
        vHitem.price.setText("共"+1+"件商品 需付款：¥"+list.get(position).getPrice());
        vHitem.zhifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        context.startActivity(new Intent(context, PayDemoActivity.class));



            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class VHitem extends RecyclerView.ViewHolder{
        SimpleDraweeView simpleDraweeView;
        TextView title,price,zhifu;
        public VHitem(View itemView) {
            super(itemView);
            simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.orderlist_sdv);
            title= (TextView) itemView.findViewById(R.id.orderlist_title);
            price= (TextView) itemView.findViewById(R.id.orderlist_price);
            zhifu= (TextView) itemView.findViewById(R.id.orderlist_zhifu);
        }
    }
}
