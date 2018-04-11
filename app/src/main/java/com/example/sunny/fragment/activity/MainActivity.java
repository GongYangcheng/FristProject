package com.example.sunny.fragment.activity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sunny.fragment.R;
import com.example.sunny.fragment.broadcastReceive.ListernNet;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private ListernNet mListernNet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");//网络改变广播
        mListernNet = new ListernNet();
        registerReceiver(mListernNet,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mListernNet);
    }
}
