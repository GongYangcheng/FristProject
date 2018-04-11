package com.example.sunny.fragment.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sunny.fragment.R;
import com.example.sunny.fragment.fragment.NewsContentfragment;

public class NewsContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content_fragment);
        String newTitle = getIntent().getStringExtra("new_title");
        String newContent = getIntent().getStringExtra("new_content");
        NewsContentfragment newsContentfragment = (NewsContentfragment) getSupportFragmentManager().findFragmentById(R.id.news_content);
        newsContentfragment.refresh(newTitle,newContent);
    }

    public static void actionStart(Context context, String data1, String data2){
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("new_title",data1);
        intent.putExtra("new_content",data2);
        context.startActivity(intent);
    }
}
