package com.example.zhangshilong20190115.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhangshilong20190115.bean.Bean;
import com.example.zhangshilong20190115.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.util.List;

public class MyAdapter extends BaseAdapter {
   private Context context;
   private List<Bean.ResultBean> list;
    private final DisplayImageOptions imageOptions;
    private ImageLoader instance = ImageLoader.getInstance();;

    public MyAdapter(Context context, List<Bean.ResultBean> list) {
        this.context = context;
        this.list = list;
        imageOptions = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new CircleBitmapDisplayer())
                .build();

    }


    public void setList(List<Bean.ResultBean> list) {
        this.list = list;
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
        ViewHolder holder;
        if (convertView==null){
            holder = new ViewHolder();
            convertView=View.inflate(context, R.layout.item,null);
            holder.titlethree = convertView.findViewById(R.id.titlethree);
            holder.titletwo = convertView.findViewById(R.id.titletwo);
            holder.titleone = convertView.findViewById(R.id.titleone);
            holder.pimg = convertView.findViewById(R.id.pimg);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.titlethree.setText(list.get(position).getName());
        holder.titletwo.setText(list.get(position).getSummary());
        holder.titleone.setText(list.get(position).getReleaseTimeShow());
        String path = list.get(position).getImageUrl();

        instance.displayImage(path,holder.pimg,imageOptions);
        ImageLoader.getInstance().displayImage(list.get(position).getImageUrl(),holder.pimg);
        return convertView;
    }
    class ViewHolder{
        TextView titleone,titletwo,titlethree;
        ImageView pimg;
    }
}
