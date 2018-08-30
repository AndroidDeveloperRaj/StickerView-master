package com.xiaopo.flying.stickerview;

/**
 * Created by 2125 on 3/16/2018.
 */


public class Bean_Stickers {
    String title; int[] stickerArray;
    Bean_Stickers(String title, int[] stickerArray)
    {
        this.stickerArray=stickerArray;
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int[] getStickerArray() {
        return stickerArray;
    }

    public void setStickerArray(int[] stickerArray) {
        this.stickerArray = stickerArray;
    }
}
