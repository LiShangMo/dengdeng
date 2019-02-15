package com.example.workzhou.image;

import android.app.Application;
import android.net.Uri;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class Mapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(build);
    }
}
