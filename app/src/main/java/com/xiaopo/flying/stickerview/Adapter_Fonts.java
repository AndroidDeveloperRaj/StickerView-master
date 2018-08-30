package com.xiaopo.flying.stickerview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by 2125 on 3/15/2018.
 */

public class Adapter_Fonts extends BaseAdapter {
Context context;
        String[] fontstyles;


        public Adapter_Fonts() {
            fontstyles = null;
        }

        public Adapter_Fonts(Context context,String[] fontstyles) {
            this.fontstyles = fontstyles;
         this.context=   context;
        }

        @Override
        public int getCount() {
            return fontstyles.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            FontsviewHolder fontsviewHolder;
if(view==null)
{fontsviewHolder=new FontsviewHolder();
    view=LayoutInflater.from(context).inflate(R.layout.list,null);
fontsviewHolder.text=(TextView)view.findViewById(R.id.listTextView);
    view.setTag(fontsviewHolder);
}else
{
    fontsviewHolder=(FontsviewHolder)view.getTag();
}

            fontsviewHolder. text.setText(context.getString(R.string.appbasic));
         Typeface   tf1 = Typeface.createFromAsset(context.getAssets(), fontstyles[position]);
fontsviewHolder.text.setTypeface(tf1);
            /*switch (position) {
                case 0:
                    text.setTypeface(tf1);
                    break;

                case 1:
                    text.setTypeface(tf2);
                    break;
                case 2:
                    text.setTypeface(tf3);
                    break;
                case 3:
                    text.setTypeface(tf4);
                    break;
                case 4:
                    text.setTypeface(tf5);
                    break;
                case 5:
                    text.setTypeface(tf6);
                    break;
                case 6:
                    text.setTypeface(tf7);
                    break;
                case 7:
                    text.setTypeface(tf8);
                    break;
                case 8:
                    text.setTypeface(tf9);
                    break;
                case 9:
                    text.setTypeface(tf10);
                    break;
                case 10:
                    text.setTypeface(tf11);
                    break;
                case 11:
                    text.setTypeface(tf12);
                    break;
                case 12:
                    text.setTypeface(tf13);
                    break;
                case 13:
                    text.setTypeface(tf14);
                    break;
                case 14:
                    text.setTypeface(tf15);
                    break;
                case 15:
                    text.setTypeface(tf16);
                    break;
                case 16:
                    text.setTypeface(tf17);
                    break;
                case 17:
                    text.setTypeface(tf18);
                    break;
                case 18:
                    text.setTypeface(tf19);
                    break;

                default:
                    break;*/

            // util.typface = text.getTypeface();
            return view;
        }
public class FontsviewHolder
{
    TextView text;

}

}
