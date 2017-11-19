package com.bawei.jingdong.Bean;

import java.util.List;


public class bean_shopp {


    /**
     * msg : 请求成功
     * code : 0
     * data : [{"list":[{"bargainPrice":11800,"createtime":"2017-10-10T17:33:37","detailUrl":"https://item.m.jd.com/product/4338107.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t6700/155/2098998076/156185/6cf95035/595dd5a5Nc3a7dab5.jpg!q70.jpg","num":1,"pid":57,"price":5199,"pscid":40,"selected":0,"sellerid":1,"subhead":"【i5 MX150 2G显存】全高清窄边框 8G内存 256固态硬盘 支持指纹识别 预装WIN10系统","title":"小米(MI)Air 13.3英寸全金属轻薄笔记本(i5-7200U 8G 256G PCle SSD MX150 2G独显 FHD 指纹识别 Win10）银\r\n"}],"sellerName":"商家1","sellerid":"1"},{"list":[{"bargainPrice":22.9,"createtime":"2017-10-03T23:53:28","detailUrl":"https://item.m.jd.com/product/2542855.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t1930/284/2865629620/390243/e3ade9c4/56f0a08fNbd3a1235.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t2137/336/2802996626/155915/e5e90d7a/56f0a09cN33e01bd0.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t1882/31/2772215910/389956/c8dbf370/56f0a0a2Na0c86ea6.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t2620/166/2703833710/312660/531aa913/57709035N33857877.jpg!q70.jpg","num":1,"pid":26,"price":88,"pscid":2,"selected":0,"sellerid":3,"subhead":"三只松鼠零食特惠，专区满99减50，满199减100，火速抢购》","title":"三只松鼠 坚果炒货 零食奶油味 碧根果225g/袋"}],"sellerName":"商家3","sellerid":"3"},{"list":[{"bargainPrice":22.9,"createtime":"2017-10-03T23:53:28","detailUrl":"https://item.m.jd.com/product/2542855.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t1930/284/2865629620/390243/e3ade9c4/56f0a08fNbd3a1235.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t2137/336/2802996626/155915/e5e90d7a/56f0a09cN33e01bd0.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t1882/31/2772215910/389956/c8dbf370/56f0a0a2Na0c86ea6.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t2620/166/2703833710/312660/531aa913/57709035N33857877.jpg!q70.jpg","num":2,"pid":44,"price":789,"pscid":2,"selected":0,"sellerid":21,"subhead":"三只松鼠零食特惠，专区满99减50，满199减100，火速抢购》","title":"三只松鼠 坚果炒货 零食奶油味 碧根果225g/袋"}],"sellerName":"商家21","sellerid":"21"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * list : [{"bargainPrice":11800,"createtime":"2017-10-10T17:33:37","detailUrl":"https://item.m.jd.com/product/4338107.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t6700/155/2098998076/156185/6cf95035/595dd5a5Nc3a7dab5.jpg!q70.jpg","num":1,"pid":57,"price":5199,"pscid":40,"selected":0,"sellerid":1,"subhead":"【i5 MX150 2G显存】全高清窄边框 8G内存 256固态硬盘 支持指纹识别 预装WIN10系统","title":"小米(MI)Air 13.3英寸全金属轻薄笔记本(i5-7200U 8G 256G PCle SSD MX150 2G独显 FHD 指纹识别 Win10）银\r\n"}]
         * sellerName : 商家1
         * sellerid : 1
         */

        private String sellerName;
        private String sellerid;
        private List<ListBean> list;

        public boolean allCheck = false;

        public boolean isAllCheck() {
            return allCheck;
        }

        public void setAllCheck(boolean allCheck) {
            this.allCheck = allCheck;
        }

        public String getSellerName() {
            return sellerName;
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

        public String getSellerid() {
            return sellerid;
        }

        public void setSellerid(String sellerid) {
            this.sellerid = sellerid;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * bargainPrice : 11800.0
             * createtime : 2017-10-10T17:33:37
             * detailUrl : https://item.m.jd.com/product/4338107.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends
             * images : https://m.360buyimg.com/n0/jfs/t6700/155/2098998076/156185/6cf95035/595dd5a5Nc3a7dab5.jpg!q70.jpg
             * num : 1
             * pid : 57
             * price : 5199.0
             * pscid : 40
             * selected : 0
             * sellerid : 1
             * subhead : 【i5 MX150 2G显存】全高清窄边框 8G内存 256固态硬盘 支持指纹识别 预装WIN10系统
             * title : 小米(MI)Air 13.3英寸全金属轻薄笔记本(i5-7200U 8G 256G PCle SSD MX150 2G独显 FHD 指纹识别 Win10）银

             */

            private double bargainPrice;
            private String createtime;
            private String detailUrl;
            private String images;
            private int num;
            private int pid;
            private double price;
            private int pscid;
            private int selected;
            private int sellerid;
            private String subhead;
            private String title;
            public boolean itemCheck = false;
            public boolean isItemCheck() {
                return itemCheck;
            }

            public void setItemCheck(boolean itemCheck) {
                this.itemCheck = itemCheck;
            }
            public double getBargainPrice() {
                return bargainPrice;
            }

            public void setBargainPrice(double bargainPrice) {
                this.bargainPrice = bargainPrice;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getDetailUrl() {
                return detailUrl;
            }

            public void setDetailUrl(String detailUrl) {
                this.detailUrl = detailUrl;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getPscid() {
                return pscid;
            }

            public void setPscid(int pscid) {
                this.pscid = pscid;
            }

            public int getSelected() {
                return selected;
            }

            public void setSelected(int selected) {
                this.selected = selected;
            }

            public int getSellerid() {
                return sellerid;
            }

            public void setSellerid(int sellerid) {
                this.sellerid = sellerid;
            }

            public String getSubhead() {
                return subhead;
            }

            public void setSubhead(String subhead) {
                this.subhead = subhead;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
