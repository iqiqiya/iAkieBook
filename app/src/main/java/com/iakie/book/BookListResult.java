package com.iakie.book;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Author: iqiqiya
 * Date: 2019/10/25
 * Time: 21:36
 * Blog: blog.77sec.cn
 * Github: github.com/iqiqiya
 */
public class BookListResult {
    //三种方法进行匹配，第一种名字必须与后端一致，第二种加上注解就行了，第三种直接使用GsonFormat插件进行生成
    /**
     * status : 1
     * data : [{"bookname":"幻兽少年","bookfile":"http://www.imooc.com/data/teacher/down/幻兽少年.txt"},{"bookname":"魔界的女婿","bookfile":"http://www.imooc.com/data/teacher/down/魔界的女婿.txt"},{"bookname":"盘龙","bookfile":"http://www.imooc.com/data/teacher/down/盘龙.txt"},{"bookname":"庆余年","bookfile":"http://www.imooc.com/data/teacher/down/庆余年.txt"},{"bookname":"武神空间","bookfile":"http://www.imooc.com/data/teacher/down/武神空间.txt"}]
     * msg : 成功
     */

    @SerializedName("status")
    private int mStatus;
    @SerializedName("msg")
    private String mMessage;
    @SerializedName("data")
    private List<Book> mData;

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public String getMsg() {
        return mMessage;
    }

    public void setMsg(String msg) {
        this.mMessage = msg;
    }

    public List<Book> getData() {
        return mData;
    }

    public void setData(List<Book> data) {
        this.mData = mData;
    }

    public static class Book {
        /**
         * bookname : 幻兽少年
         * bookfile : http://www.imooc.com/data/teacher/down/幻兽少年.txt
         */

        @SerializedName("bookname")
        private String bookname;
        @SerializedName("bookfile")
        private String bookfile;

        public String getBookname() {
            return bookname;
        }

        public void setBookname(String bookname) {
            this.bookname = bookname;
        }

        public String getBookfile() {
            return bookfile;
        }

        public void setBookfile(String bookfile) {
            this.bookfile = bookfile;
        }
    }




}
