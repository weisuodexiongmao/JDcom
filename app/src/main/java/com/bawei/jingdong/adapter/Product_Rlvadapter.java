package com.bawei.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.jingdong.Bean.Productlist_Bean;
import com.bawei.jingdong.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2017/11/9.
 */

public class Product_Rlvadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private Context context;
    private List<Productlist_Bean.DataBean> list;

    public Product_Rlvadapter(Context context, List<Productlist_Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.productlist_item, parent, false);
        return new VHItem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
     VHItem vhItem= (VHItem) holder;
        final Productlist_Bean.DataBean dataBean = list.get(position);
        String images = list.get(position).getImages();
      String[] split = images.split("\\|");
     vhItem.simpleDraweeView.setImageURI(split[0]);
        vhItem.textView1.setText(list.get(position).getTitle());
     vhItem.textView2.setText("价格："+list.get(position).getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemclincklisenter.Onitemlisck(dataBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class VHItem extends RecyclerView.ViewHolder{
        SimpleDraweeView simpleDraweeView;
        TextView textView1,textView2;
        public VHItem(View itemView) {
            super(itemView);
            simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.product_sid);
            textView1= (TextView) itemView.findViewById(R.id.product_text1);
            textView2= (TextView) itemView.findViewById(R.id.product_text2);
        }
    }

   public interface Onitemclincklisenter{
       void Onitemlisck(Productlist_Bean.DataBean dataBean);
   }
   private Onitemclincklisenter onitemclincklisenter;
    public void setOnitemclinck(Onitemclincklisenter o){
        this.onitemclincklisenter=o;
    }
}
