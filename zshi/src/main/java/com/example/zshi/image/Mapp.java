package com.example.zshi.image;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Environment;

import com.example.zshi.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.io.File;

public class Mapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(build);
    }
}
