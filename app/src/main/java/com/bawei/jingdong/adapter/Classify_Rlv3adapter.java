package com.bawei.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.jingdong.Bean.Classify2;
import com.bawei.jingdong.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2017/11/6.
 */

public class Classify_Rlv3adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private Context context;
    private List<Classify2.DataBean.ListBean>list;

    public Classify_Rlv3adapter(Context context, List<Classify2.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.classify_rlv3item, parent, false);
        return new VHItem(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
       VHItem vhItem= (VHItem) holder;
        final Classify2.DataBean.ListBean bean=list.get(position);
        vhItem.simpleDraweeView.setImageURI(list.get(position).getIcon());
        vhItem.textView.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到条目的位置
                int position1 = holder.getLayoutPosition();
                //将点击的事件回调
                onitemclickListenter.onitemclick(bean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class VHItem extends RecyclerView.ViewHolder{
        SimpleDraweeView simpleDraweeView;
        TextView textView;
        public VHItem(View itemView) {
            super(itemView);
          simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.sdv);
            textView= (TextView) itemView.findViewById(R.id.rlv3textView);
        }
    }
    //点击条目的接口
    public interface OnitemclickListenter{
        void onitemclick(Classify2.DataBean.ListBean bean);

    }
    private OnitemclickListenter onitemclickListenter;
    public void setOnitemclick(OnitemclickListenter onitemclickListenter){
        this.onitemclickListenter=onitemclickListenter;

    }
}
