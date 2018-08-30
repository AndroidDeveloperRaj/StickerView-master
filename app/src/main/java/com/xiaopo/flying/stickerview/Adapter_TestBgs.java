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

/**
 * Created by 2125 on 3/14/2018.
 */

public class Adapter_TestBgs extends  RecyclerView.Adapter<Adapter_TestBgs.BgViewHolder>{
    Context context;
    int[] testBgs;
    int width;
    int height;
    ImageLoader_Object imageLoader_object;
   Adapter_TestBgs(Context context,int[] testBgs,int width,int height)
   {
       this.context=context;
       this.testBgs=testBgs;
       this.width=width;
       this.height=height;
       imageLoader_object=new ImageLoader_Object(context);
   }

    @Override
    public BgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adapter_testbg,null);

        return new BgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BgViewHolder holder, int position) {
imageLoader_object.imageLoader.displayImage("drawable://" + testBgs[position], holder.textbgImg, null, new ImageLoadingListener() {
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
        return testBgs.length;
    }

    public class BgViewHolder extends RecyclerView.ViewHolder
    {
ImageView textbgImg;
        public BgViewHolder(View itemView) {
            super(itemView);
            textbgImg=(ImageView)itemView.findViewById(R.id.textbgImg);
            textbgImg.getLayoutParams().width=width/5;
            textbgImg.getLayoutParams().height=width/7;
        }
    }
}
