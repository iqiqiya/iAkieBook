package com.iakie.book;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;

/**
 * Author: iqiqiya
 * Date: 2019/10/25
 * Time: 20:48
 * Blog: blog.77sec.cn
 * Github: github.com/iqiqiya
 */
public class BookListActivity extends AppCompatActivity {

    private static final String TAG = "BookListActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        String url = "http://www.imooc.com/api/teacher?type=10";

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                final String result = new String(responseBody);

                Gson gson = new Gson();
                BookListResult bookListResult = gson.fromJson(result, BookListResult.class);

                List<BookListResult.Book> books = bookListResult.getData();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }

            @Override
            public void onFinish() {
                super.onFinish();
            }
        });
    }

    public static void start(Context context){
        Intent intent = new Intent(context, BookListActivity.class);
        context.startActivity(intent);
    }
}
