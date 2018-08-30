package com.xiaopo.flying.stickerview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 2125 on 3/16/2018.
 */

public class Adapter_Sticker_Titles  extends RecyclerView.Adapter<Adapter_Sticker_Titles.AdapterSticker>{
    Context context;
    ArrayList<Bean_Stickers> stickerTitles;
    int width;
    int height;
    ImageLoader_Object imageLoader_object;
    Adapter_Sticker_Titles(Context context,ArrayList<Bean_Stickers> stickerTitles,int width,int height)
    {
        this.context=context;
        this.stickerTitles=stickerTitles;
        this.width=width;
        this.height=height;
        imageLoader_object=new ImageLoader_Object(context);
    }
    @Override
    public AdapterSticker onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adapter_sticker_titles,null);

        return new AdapterSticker(view);
    }

    @Override
    public void onBindViewHolder(AdapterSticker holder, int position) {
holder.stickerTitle.setText(""+stickerTitles.get(position).getTitle());
        if(position==MainActivity.selectpos)
        {
        holder.rel_title.setBackgroundResource(R.drawable.sticker_selected);}else
        {
            holder.rel_title.setBackgroundResource(R.drawable.imagebg);
        }
    }

    @Override
    public int getItemCount() {
        return stickerTitles.size();
    }

    public class AdapterSticker extends RecyclerView.ViewHolder
    {TextView stickerTitle;
LinearLayout rel_title;
        public AdapterSticker(View itemView) {
            super(itemView);
            stickerTitle=(TextView)itemView.findViewById(R.id.stickerTitle);
            rel_title=(LinearLayout)itemView.findViewById(R.id.rel_title);
        }
    }
}
