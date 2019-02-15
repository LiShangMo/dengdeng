package com.example.workzhou.fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.xlistviewlibrary.utils.NetWordUtils;
import com.bwie.xlistviewlibrary.view.XListView;
import com.example.workzhou.Dao;
import com.example.workzhou.R;
import com.example.workzhou.adapter.MyAdapter;
import com.example.workzhou.bean.Bean;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Fragmentone extends Fragment {

    private XListView xlist;
    private String urlString = "http://api.expoon.com/AppNews/getNewsList/type/1/p/1";
    private List<Bean.DataBean> list = new ArrayList<>();
    private MyAdapter adapter;
    private int page = 0;
    private Dao dao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentone, container, false);
        dao = new Dao(getActivity());
        xlist = view.findViewById(R.id.xlist);
        xlist.setPullLoadEnable(true);
        adapter = new MyAdapter(list, getActivity());
        xlist.setAdapter(adapter);
        initData(page);

        xlist.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                page=0;
                list.clear();
                initData(page);
            }

            @Override
            public void onLoadMore() {
                page++;
                initData(page);
            }
        });
        return view;
    }


    private void initData(int page) {
        //获取网络
        boolean connection = NetWordUtils.isConnection(getActivity());
        //判断网络
        if(connection==false){
            Toast.makeText(getActivity(),"网络不给力",Toast.LENGTH_SHORT).show();
            List<Bean.DataBean> dataBeans = dao.queryAll();
            adapter.setList(dataBeans);
        }else{
            String Murl = urlString + page;
            new MyAsyncTask().execute(Murl);
        }
    }

    private class MyAsyncTask extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            return NetWordUtils.getNetjson(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            Bean bean = gson.fromJson(s, Bean.class);
            List<Bean.DataBean> data = bean.getData();
            //将数据用For循环一个一个的添加到数据库
            for(int i=0;i<data.size();i++){
                String news_id = data.get(i).getNews_id();
                String news_title = data.get(i).getNews_title();
                String news_summary = data.get(i).getNews_summary();
                String url = data.get(i).getPic_url();
                Bean.DataBean dataBean = new Bean.DataBean(news_id, news_title, news_summary, url);
                dao.add(dataBean);
            }

            list.addAll(data);
            adapter.notifyDataSetChanged();
            uiComplete();
        }
    }
    private void uiComplete(){
        xlist.setRefreshTime("刚刚");
        xlist.stopRefresh();//隐藏刷新新头部
        xlist.stopLoadMore();//隐藏刷新新脚部
    }
}
