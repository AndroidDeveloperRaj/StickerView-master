package com.xiaopo.flying.stickerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import static com.xiaopo.flying.stickerview.R.id.textbgImg;

/**
 * Created by 2125 on 3/15/2018.
 */

public class Adapter_Stickers extends  RecyclerView.Adapter<Adapter_Stickers.StickerViewHolder>{
    Context context;
    int[] stickers;
    int width;
    int height;
    ImageLoader_Object imageLoader_object;
    Adapter_Stickers(Context context,int[] stickers,int width,int height)
    {
        this.context=context;
        this.stickers=stickers;
        this.width=width;
        this.height=height;
        imageLoader_object=new ImageLoader_Object(context);
    }
    @Override
    public StickerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adapter_stickers,null);
        return new StickerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StickerViewHolder holder, int position) {
        imageLoader_object.imageLoader.displayImage("drawable://" + stickers[position], holder.stickerImg, null, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return stickers.length;
    }

    public class StickerViewHolder extends RecyclerView.ViewHolder
    {
ImageView stickerImg;
        public StickerViewHolder(View itemView) {
            super(itemView);
            stickerImg=(ImageView)itemView.findViewById(R.id.stickerImg);
            stickerImg.getLayoutParams().width=width/5;
            stickerImg.getLayoutParams().height=width/7;
        }
    }

}
