package com.xiaopo.flying.stickerview;

import android.content.Context;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by 2125 on 2/26/2018.
 */

public class ImageLoader_Object {

ImageLoader imageLoader;



    public ImageLoader_Object(Context context) {
        imageLoader = ImageLoader.getInstance();
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.ic_stub)
                .showImageOnFail(R.drawable.ic_launcher)
                .showImageOnLoading(R.drawable.ic_stub)
                .cacheInMemory(true).cacheOnDisk(true).build();

        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(
                context)
                .defaultDisplayImageOptions(displayImageOptions)
                .memoryCacheSize(50 * 1024 * 1024)
                .diskCacheSize(50 * 1024 * 1024).threadPoolSize(5)
                .writeDebugLogs().build();
        imageLoader.init(imageLoaderConfiguration);
        imageLoader.getInstance().clearMemoryCache();
        imageLoader.getInstance().clearDiskCache();
    }
}
