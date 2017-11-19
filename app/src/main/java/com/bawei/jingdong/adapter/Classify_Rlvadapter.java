package com.bawei.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.jingdong.Bean.Classify1;
import com.bawei.jingdong.R;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2017/11/6.
 */

public class Classify_Rlvadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private Context context;
  private List<Classify1.DataBean> list;

    public Classify_Rlvadapter(Context context, List<Classify1.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.classify_rlv1item, parent, false);
        return new VHItem(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
     VHItem vhItem= (VHItem) holder;
        vhItem.textView.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到条目的位置
                int position1 = holder.getLayoutPosition();
                //将点击的事件回调
                onitemclickListenter.onitemclick(holder.itemView,position1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class VHItem extends RecyclerView.ViewHolder{
           TextView textView;
        public VHItem(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.rlv1textView);
        }
    }
    //点击条目的接口
    public interface OnitemclickListenter{
        void onitemclick(View view,int position);

    }
    private OnitemclickListenter onitemclickListenter;
    public void setOnitemclick(OnitemclickListenter onitemclickListenter){
        this.onitemclickListenter=onitemclickListenter;

    }
}
