package com.bawei.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jingdong.Bean.Address_Bean;
import com.bawei.jingdong.Bean.Sitelist_Bean;
import com.bawei.jingdong.R;
import com.bawei.jingdong.utils.GsonObjectCallback;
import com.bawei.jingdong.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by 猥琐的熊猫 on 2017/11/16.
 */

public class Sitelist_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Sitelist_Bean.DataBean>list;
    private Context context;

    public Sitelist_Adapter(List<Sitelist_Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.receiving_item, parent, false);
        return new VHitem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
     VHitem vHitem= (VHitem) holder;
        vHitem.textView1.setText(list.get(position).getName());
        vHitem.textView2.setText(list.get(position).getMobile()+"");
        vHitem.textView3.setText(list.get(position).getAddr());
        vHitem.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                    Map<String,String>map=new HashMap<String, String>();
                    map.put("uid",list.get(position).getUid()+"");
                    map.put("addrid",list.get(position).getAddrid()+"");
                    OkHttp3Utils.doPost("https://www.zhaoapi.cn/user/setAddr", map, new GsonObjectCallback<Address_Bean>() {
                        @Override
                        public void onUi(Address_Bean address_bean) {
                            Toast.makeText(context,"设置成功",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailed(Call call, IOException e) {

                        }
                    });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class VHitem extends RecyclerView.ViewHolder{
        TextView textView1,textView2,textView3;
        CheckBox checkBox;
        public VHitem(View itemView) {
            super(itemView);
            textView1= (TextView) itemView.findViewById(R.id.receivingitem_text);
            textView2= (TextView) itemView.findViewById(R.id.receivingitem_text2);
            textView3= (TextView) itemView.findViewById(R.id.receivingitem_text3);
            checkBox= (CheckBox) itemView.findViewById(R.id.checkBox11);
        }
    }
}
