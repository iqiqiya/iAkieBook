package com.iakie.book;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Author: iqiqiya
 * Date: 2019/10/25
 * Time: 20:48
 * Blog: blog.77sec.cn
 * Github: github.com/iqiqiya
 */
public class BookListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
    }

    public static void start(Context context){
        Intent intent = new Intent(context, BookListActivity.class);
        context.startActivity(intent);
    }
}
