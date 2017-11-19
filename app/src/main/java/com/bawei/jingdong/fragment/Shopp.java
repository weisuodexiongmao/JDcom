package com.bawei.jingdong.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jingdong.Bean.bean_shopp;
import com.bawei.jingdong.P.shoppingcart_Presenter;
import com.bawei.jingdong.R;
import com.bawei.jingdong.V.shoppingcart_view;
import com.bawei.jingdong.activity.Createorder_activity;
import com.bawei.jingdong.activity.Logn_activity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


public class Shopp extends Fragment implements shoppingcart_view {
    ExpandableListView expandableListView;
    CheckBox tv_shopcart_addselect;
    ExpandableAdapter exd;
    String uid;
    List<bean_shopp.DataBean> shopplist;
    TextView goodssize,tv_shopcart_totalprice,tv_shopcart_totalnum,tv_shopcart_submit;
    private SharedPreferences sp;
    private String token;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //加载布局
        View view=  View.inflate(getContext(), R.layout.shoppfragment,null);
        TextView textView= (TextView) view.findViewById(R.id.tv_shopcart_submit);
        sp = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);

        //总价
        tv_shopcart_totalprice= (TextView) view.findViewById(R.id.tv_shopcart_totalprice);
        //总商品量
        tv_shopcart_totalnum= (TextView) view.findViewById(R.id.tv_shopcart_totalnum);
        expandableListView= (ExpandableListView) view.findViewById(R.id.els);

        //全选
        tv_shopcart_addselect = (CheckBox) view.findViewById(R.id.tv_shopcart_addselect);
        //判断登陆
       uid = sp.getString("uid", "");
        if(uid.equals("")){
            Toast.makeText(getActivity(),"请登陆",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getActivity(), Logn_activity.class));
        }
         uid = sp.getString("uid","");
        token = sp.getString("token","");
        //连接p层
        shoppingcart_Presenter shoppingcart_presenter=new shoppingcart_Presenter(this);
        shoppingcart_presenter.getshoppingcartData();


        tv_shopcart_addselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {

                    List<bean_shopp.DataBean> data = shopplist;

                    for (int i = 0; i < data.size(); i++) {
                        Log.i("xxx", data.get(i).isAllCheck() + "");
                        bean_shopp.DataBean groupDatas = shopplist.get(i);
                        groupDatas.setAllCheck(true);
                        List<bean_shopp.DataBean.ListBean> datas = shopplist.get(i).getList();
                        for (int j = 0; j < datas.size(); j++) {
                            Log.i("xxx", datas.get(j).isItemCheck() + "");
                            List<bean_shopp.DataBean.ListBean> childDatas = shopplist.get(i).getList();
                            for (bean_shopp.DataBean.ListBean childData : childDatas) {
                                childData.setItemCheck(true);
                            }
                        }
                    }
                    //刷新界面
                    notifyCheckAdapter();
                } else {

                    List<bean_shopp.DataBean> data = shopplist;
                    for (int i = 0; i < data.size(); i++) {
                        Log.i("xxx", data.get(i).isAllCheck() + "");
                        bean_shopp.DataBean groupDatas = shopplist.get(i);
                        groupDatas.setAllCheck(false);
                        List<bean_shopp.DataBean.ListBean> datas = shopplist.get(i).getList();
                        for (int j = 0; j < datas.size(); j++) {
                            Log.i("xxx", datas.get(j).isItemCheck() + "");
                            List<bean_shopp.DataBean.ListBean> childDatas = shopplist.get(i).getList();
                            for (bean_shopp.DataBean.ListBean childData : childDatas) {
                                childData.setItemCheck(false);
                            }
                        }
                    }
                    //刷新界面
                    notifyCheckAdapter();
                }
            }
        });


        return view;
    }

    @Override
    public void getshoppingcartData(bean_shopp beanShopp) {
        shopplist=  beanShopp.getData();
        exd=new ExpandableAdapter(getContext(),shopplist);
        expandableListView.setAdapter(exd);
        for (int i=0;i<shopplist.size();i++){
            expandableListView.expandGroup(i);
        }
    }

    @Override
    public String Uid() {
        return uid;
    }

    @Override
    public String token() {
        return token;
    }


    public class ExpandableAdapter extends BaseExpandableListAdapter{
        Context context;
        List<bean_shopp.DataBean> shopplist;
        public ExpandableAdapter(Context context, List<bean_shopp.DataBean> shopplist) {
            this.context=context;
            this.shopplist=shopplist;
        }

        @Override
        public int getGroupCount() {
            return shopplist.size();
        }

        @Override
        public int getChildrenCount(int i) {
            return shopplist.get(i).getList().size();
        }

        @Override
        public Object getGroup(int i) {
            return shopplist.get(i);
        }

        @Override
        public Object getChild(int i, int i1) {
            return shopplist.get(i).getList().get(i1);
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

            view=View.inflate(context, R.layout.item_shopping, null);
            CheckBox iv_item_shopcart_shopselect= (CheckBox) view.findViewById(R.id.iv_item_shopcart_shopselect);
            TextView tv_item_shopcart_shopname=(TextView) view.findViewById(R.id.tv_item_shopcart_shopname);

            tv_item_shopcart_shopname.setText(shopplist.get(i).getSellerName());

            if (shopplist.get(i).isAllCheck()) {
                iv_item_shopcart_shopselect.setChecked(true);
            } else {
                iv_item_shopcart_shopselect.setChecked(false);
            }
            //一级监听
            iv_item_shopcart_shopselect.setOnClickListener(new OnGroupClickListener(i, iv_item_shopcart_shopselect));


            return view;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            view=View.inflate(context, R.layout.item_shoppinggoods, null);

            TextView tv_item_shopcart_clothname=(TextView) view.findViewById(R.id.tv_item_shopcart_clothname);
            TextView tv_item_shopcart_cloth_price= (TextView) view.findViewById(R.id.tv_item_shopcart_cloth_price);
            TextView tv_item_shopcart_cloth_num= (TextView) view.findViewById(R.id.tv_item_shopcart_cloth_num);
            SimpleDraweeView iv_item_shopcart_cloth_pic=(SimpleDraweeView) view.findViewById(R.id.iv_item_shopcart_cloth_pic);
            ImageView iv_item_shopcart_cloth_delete= (ImageView) view.findViewById(R.id.iv_item_shopcart_cloth_delete);

            CheckBox tv_item_shopcart_clothselect= (CheckBox) view.findViewById(R.id.tv_item_shopcart_clothselect);



            tv_item_shopcart_clothname.setText(shopplist.get(i).getList().get(i1).getTitle());
            tv_item_shopcart_cloth_price.setText("¥"+shopplist.get(i).getList().get(i1).getPrice()+"");
            tv_item_shopcart_cloth_num.setText("数量："+shopplist.get(i).getList().get(i1).getNum()+"");

            String img=shopplist.get(i).getList().get(i1).getImages().toString();
            String [] temp = null;
            temp = img.split("\\|");
           Log.i("xxx3",temp[0]);
            iv_item_shopcart_cloth_pic.setImageURI(temp[0]);
            if (shopplist.get(i).getList().get(i1).isItemCheck()) {
                tv_item_shopcart_clothselect.setChecked(true);
            } else {
                tv_item_shopcart_clothselect.setChecked(false);
            }
            tv_item_shopcart_clothselect.setOnClickListener(new OnChildCheckListener(i, i1, tv_item_shopcart_clothselect));
            return view;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }


        //一级监听
        private class OnGroupClickListener implements View.OnClickListener {
            int groupPosition;
            CheckBox iv_item_shopcart_shopselect;

            public OnGroupClickListener(int groupPosition, CheckBox iv_item_shopcart_shopselect) {
                this.iv_item_shopcart_shopselect = iv_item_shopcart_shopselect;
                this.groupPosition = groupPosition;
            }


            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    //一级全选
                    setCheck(true);

                } else {
                    //取消全选
                    setCheck(false);
                    iv_item_shopcart_shopselect.setChecked(false);
                }
                notifyCheckAdapter();
            }

            public void setCheck(boolean checkFlag) {

                bean_shopp.DataBean groupDatas = shopplist.get(groupPosition);
                List<bean_shopp.DataBean> data= shopplist;

                //一级状态
                groupDatas.setAllCheck(checkFlag);

                //全选状态判断
                int num = 0;
                for (int i = 0; i < data.size(); i++) {
                    boolean allCheck = data.get(i).isAllCheck();
                    if (!allCheck) {
                        num++;
                    }
                }
                if (num == 0) {
                    iv_item_shopcart_shopselect.setChecked(true);
                } else {
                    iv_item_shopcart_shopselect.setChecked(false);
                }

                //二级状态
                List<bean_shopp.DataBean.ListBean> childDatas = groupDatas.getList();
                for (bean_shopp.DataBean.ListBean childData : childDatas) {
                    //二级状态
                    childData.setItemCheck(checkFlag);

                }

            }
        }


        //二级监听
        private class OnChildCheckListener implements View.OnClickListener {
            int groupPosition;
            int childPosition;
            CheckBox tv_item_shopcart_clothselect;

            public OnChildCheckListener(int groupPosition, int childPosition, CheckBox tv_item_shopcart_clothselect) {
                this.tv_item_shopcart_clothselect = tv_item_shopcart_clothselect;
                this.groupPosition = groupPosition;
                this.childPosition = childPosition;
            }

            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    //子选中
                    shopplist.get(groupPosition).getList().get(childPosition).setItemCheck(true);





                } else {
                    //子未选中
                    shopplist.get(groupPosition).getList().get(childPosition).setItemCheck(false);

                }
                //二级联动一级状态
                setParentCheckFlag();

                //检测状态 二级联动全选
                int num = 0;
                for (int i = 0; i < shopplist.size(); i++) {
                    boolean allCheck = shopplist.get(i).isAllCheck();
                    if (!allCheck) {
                        num++;
                    }

                }
                if (num == 0) {
                    tv_item_shopcart_clothselect.setChecked(true);
                } else {
                    tv_item_shopcart_clothselect.setChecked(false);
                }
            }

            //二级联动一级状态
            private void setParentCheckFlag() {
                bean_shopp.DataBean dataInfo = shopplist.get(groupPosition);
                List<bean_shopp.DataBean.ListBean> datasInfos= shopplist.get(groupPosition).getList();

                for (int i = 0; i < datasInfos.size(); i++) {
                    if (!datasInfos.get(i).isItemCheck()) {
                        //子未选中 父取消选中
                        dataInfo.setAllCheck(false);
                        notifyCheckAdapter();
                        return;
                    }
                    if (i == datasInfos.size() - 1) {
                        //子选中 父选中
                        dataInfo.setAllCheck(true);
                        notifyCheckAdapter();

                        return;
                    }


                }
//            没出现全选或者取消全选的时候执行的
                sum(datasInfos);
            }

        }



    }

    //统计数量和价格
    private void sum(List<bean_shopp.DataBean.ListBean> datasInfos) {
        int num = 0;
        int price = 0;

        List<bean_shopp.DataBean> data = shopplist;
        for (bean_shopp.DataBean parentData : data) {
            for (bean_shopp.DataBean.ListBean child :parentData.getList()) {
                if (child.isItemCheck()) {
                    num++;
                    price +=child.getPrice();
                }
            }
        }
        tv_shopcart_totalnum.setText("共"+num+"件商品");
        tv_shopcart_totalprice.setText("总价:"+price);
    }


    //刷新适配器界面
    private void notifyCheckAdapter() {
        sum(shopplist.get(0).getList());
        expandableListView.setAdapter(exd);
        int count = expandableListView.getCount();
        for (int i = 0; i < count; i++) {
            expandableListView.expandGroup(i);
        }
    }

}
