package com.example.sunny.fragment.broadcastReceive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class ListernNet extends BroadcastReceiver {

    private static final String ACTION_BOOT = "android.intent.action.BOOT_COMPLETED";
    @Override
    public void onReceive(Context context, Intent intent) {
//        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//        if(activeNetworkInfo != null&&activeNetworkInfo.isAvailable()){
//            Toast.makeText(context,"网络连接",Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(context,"网络断开",Toast.LENGTH_SHORT).show();
//        }
//        Toast.makeText(context,"123",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "进来="+intent.getAction());
        if(intent.getAction().equals(ACTION_BOOT)){
            Log.d(TAG, "onReceive: "+"进来");
            Toast.makeText(context,"开机",Toast.LENGTH_SHORT).show();
        }
    }
}
