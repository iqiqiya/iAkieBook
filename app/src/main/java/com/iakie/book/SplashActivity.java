package com.iakie.book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.ref.WeakReference;

public class SplashActivity extends AppCompatActivity {

    public static final int CODE = 1001;
    public static final int TOTAL_TIME = 3000;
    public static final int INTERVAL_TIME = 1000;
    private TextView mtextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        mtextView = findViewById(R.id.time_text_view);

        MyHandler handler = new MyHandler(this);

        Message message = Message.obtain();
        message.what = CODE;
        message.arg1 = TOTAL_TIME;
        handler.sendMessage(message);

        mtextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 点击跳过
            }
        });
    }

    public static class MyHandler extends Handler {

        public final WeakReference<SplashActivity> mWeakReference;

        public MyHandler(SplashActivity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SplashActivity activity = mWeakReference.get();
            if (msg.what == CODE){

                if (activity != null){
                    // 收到3000 设置textview，更新UI
                    int time = msg.arg1;
                    activity.mtextView.setText(time/INTERVAL_TIME+"秒,点击跳过");
                    // 发送倒计时

                    Message message = Message.obtain();
                    message.what = CODE;
                    message.arg1 = time - INTERVAL_TIME;

                    if (time > 0){
                        sendMessageDelayed(message, INTERVAL_TIME);
                    } else {
                        // TODO 跳转到主界面
                    }
                }
            }
        }
    }
}
