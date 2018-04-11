package com.example.sunny.fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sunny.fragment.R;
import com.example.sunny.fragment.activity.NewsContentActivity;
import com.example.sunny.fragment.bean.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sunny on 2017/12/21.
 */

public class NewsTitleFragment extends Fragment {

    private static final String TAG = "NewsTitleFragment";
    private View view;
    private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_title_flag,container,false);
        RecyclerView recyclerview = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(linearLayoutManager);
        NewsAdapter newsAdapter = new NewsAdapter(getNews());
        recyclerview.setAdapter(newsAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout) != null) {
            isTwoPane = true;
        }else{
            isTwoPane = false;
        }
    }

    public List<News> getNews() {
        List<News> mLists = new ArrayList<>();
        for(int i = 0 ; i<50;i++){
            News news = new News();
            news.setTitle("新标题"+i);
            news.setContent(getRandomLengthContent("新内容吗")+i+"+");
            mLists.add(news);

        }
        return mLists;
    }

    private String getRandomLengthContent(String content) {
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder sb  = new StringBuilder();
        for (int i = 0 ;i<length;i++){
            sb.append(content);
        }

        return sb.toString();
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

        private List<News> mList;

        public NewsAdapter(List<News> list){
            this.mList =list;
        }


        public class ViewHolder extends RecyclerView.ViewHolder {

            private TextView tv_title;

            public ViewHolder(View itemView) {
                super(itemView);
                tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            }
        }

        @Override
        public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view,parent,false);
            final ViewHolder viewHolder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = mList.get(viewHolder.getAdapterPosition());
                    if (isTwoPane){
                        NewsContentfragment newsContentfragment = (NewsContentfragment) getFragmentManager().findFragmentById(R.id.news_content);
                        newsContentfragment.refresh(news.getTitle(),news.getContent());
                    }else{
                        NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
            News news = mList.get(position);
            holder.tv_title.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
    }
}
