package com.zrx.tt_client.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.zrx.tt_client.R;

import java.util.logging.Handler;

/**
 * Created by GN on 2017/2/3.
 */
public class WelcomeStartActivity extends Activity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeStartActivity.this,PagerActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
