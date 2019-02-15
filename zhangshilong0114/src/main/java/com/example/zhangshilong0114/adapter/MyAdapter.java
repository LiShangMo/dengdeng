package com.example.zhangshilong0114.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhangshilong0114.R;
import com.example.zhangshilong0114.bean.Bean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;
//设置适配器
public class MyAdapter extends BaseAdapter {
    private List<Bean.DataBean> list=new ArrayList<>();
    private Context context;
    private ImageLoader instance= ImageLoader.getInstance();
    private  DisplayImageOptions imageOp;

    public MyAdapter(List<Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;

        imageOp = new DisplayImageOptions.Builder()
        .showImageForEmptyUri(R.mipmap.ic_launcher)
        .cacheOnDisk(true)
        .cacheInMemory(true)
        .bitmapConfig(Bitmap.Config.RGB_565)
        .displayer(new CircleBitmapDisplayer())
        .build();


    }
    public void setList(List<Bean.DataBean>list){
        this.list=list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView==null){
            convertView=View.inflate(context, R.layout.item,null);
            holder.titleone=convertView.findViewById(R.id.titleone);
            holder.titletwo=convertView.findViewById(R.id.titletwo);
            holder.titlethree=convertView.findViewById(R.id.titlethree);
            holder.pimg=convertView.findViewById(R.id.pimg);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.titleone.setText(list.get(position).getNews_id());
        holder.titletwo.setText(list.get(position).getNews_summary());
        holder.titlethree.setText(list.get(position).getNews_title());
        String path = list.get(position).getPic_url();
        instance.displayImage(path,holder.pimg,imageOp);
        ImageLoader.getInstance().displayImage(list.get(position).getPic_url(),holder.pimg);


        return convertView;
    }
    class ViewHolder{
        TextView titleone,titletwo,titlethree;
        ImageView pimg;
    }
}
