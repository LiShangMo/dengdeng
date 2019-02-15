package com.example.zhangshilong20190115.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.zhangshilong20190115.R;
import com.example.zhangshilong20190115.adapter.MyPagerimageAdapter;
import com.example.zhangshilong20190115.base.BaseFragment;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FragmentTwo extends BaseFragment {



    private MyPagerimageAdapter pagerimageAdapter;
    private Banner viewpage;
    private ImageLoader instance;



       String[] picUrl={
               "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513679323820&di=d33523977cd2b8c0e831513baa205965&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fa686c9177f3e67092b94a19231c79f3df9dc55c3.jpg",
       "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513679323820&di=9d535a4011922065fc36e1d0cb3790fa&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fac4bd11373f082024ba9705241fbfbedab641ba7.jpg",
       "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513679323820&di=7d77f15e8f8556eb72fee9b0962ef985&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fc75c10385343fbf25fb0ff46ba7eca8065388f33.jpg"

};


    @Override
    protected void initDate() {

    }

    @Override
    protected void initView(View view) {

        viewpage = (Banner) view.findViewById(R.id.viewpage);
        instance = ImageLoader.getInstance();

        viewpage.setImageLoader(new com.youth.banner.loader.ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                instance.displayImage((String)path,imageView);

            }
        });
        viewpage.setImages(Arrays.asList(picUrl));
        viewpage.start();
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_two;
    }
}
