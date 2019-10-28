package com.iakie.book;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;
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
    private ListView mlistView;
    private List<BookListResult.Book> mBooks = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        mlistView = findViewById(R.id.book_list_view);
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

                mBooks = bookListResult.getData();
                mlistView.setAdapter(new BookListAdapter());

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

    private class BookListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mBooks.size();
        }

        @Override
        public Object getItem(int position) {
            return mBooks.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            BookListResult.Book book = mBooks.get(position);

            ViewHolder viewHolder = new ViewHolder();
            if (convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.item_book_list_view, null);

                viewHolder.mNameTextView = convertView.findViewById(R.id.name_text_view);
                viewHolder.mButton = convertView.findViewById(R.id.book_button);
                convertView.setTag(convertView);
            } else{
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.mNameTextView.setText(book.getBookname());
            return convertView;
        }
    }

    class ViewHolder{
        public TextView mNameTextView;
        public Button mButton;
    }
}
