package com.example.sunny.fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sunny.fragment.R;

/**
 * Created by sunny on 2017/12/21.
 */

public class NewsContentfragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.news_content_flag,container,false);

        return view;

    }

    public void refresh(String title,String content){
       View visible_layout = view.findViewById(R.id.visible_layout);
        visible_layout.setVisibility(View.VISIBLE);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_news_title);
        TextView tv_content = (TextView) view.findViewById(R.id.tv_news_content);
        tv_title.setText(title);
        tv_content.setText(content);
    }
}
