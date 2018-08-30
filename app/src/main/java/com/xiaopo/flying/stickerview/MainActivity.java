package com.xiaopo.flying.stickerview;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.appbasic.colorseekbar.ColorSeekBar;
import com.xiaopo.flying.stickerview.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
static RelativeLayout dialog_text1;
ArrayList<Bean_Stickers> bean_stickerses_list;
   int[] stickers={R.drawable.sticker1,R.drawable.sticker2,R.drawable.sticker3,R.drawable.sticker4,R.drawable.sticker5,R.drawable.sticker6,R.drawable.sticker7,R.drawable.sticker8,R.drawable.sticker9,R.drawable.sticker10,
           R.drawable.sticker11,R.drawable.sticker12,R.drawable.sticker13,R.drawable.sticker14,R.drawable.sticker15,R.drawable.sticker16,R.drawable.sticker17,R.drawable.sticker18,R.drawable.sticker19,R.drawable.sticker20,
           R.drawable.sticker21,R.drawable.sticker22,R.drawable.sticker23,R.drawable.sticker24,R.drawable.sticker25,R.drawable.sticker26,R.drawable.sticker27,R.drawable.sticker28,R.drawable.sticker29,R.drawable.sticker30,
           R.drawable.sticker31,R.drawable.sticker32,R.drawable.sticker33,R.drawable.sticker34,R.drawable.sticker35,R.drawable.sticker36,R.drawable.sticker37,R.drawable.sticker38,R.drawable.sticker39,R.drawable.sticker40,
           R.drawable.sticker41,R.drawable.sticker42,R.drawable.sticker43,R.drawable.sticker44,R.drawable.sticker45,R.drawable.sticker46,R.drawable.sticker47,R.drawable.sticker48,R.drawable.sticker49,R.drawable.sticker50,
           R.drawable.sticker51,R.drawable.sticker52,R.drawable.sticker53,R.drawable.sticker54,R.drawable.sticker55,R.drawable.sticker56,R.drawable.sticker57,R.drawable.sticker58,R.drawable.sticker59,R.drawable.sticker60,
           R.drawable.sticker61,R.drawable.sticker62,R.drawable.sticker63,R.drawable.sticker64,R.drawable.sticker65,R.drawable.sticker66,R.drawable.sticker67,R.drawable.sticker68,R.drawable.sticker69,R.drawable.sticker70,
           R.drawable.sticker71,R.drawable.sticker72,R.drawable.sticker73,R.drawable.sticker74,R.drawable.sticker75};

    int[] Wishes={R.drawable.sticker1,R.drawable.sticker2,R.drawable.sticker3,R.drawable.sticker4,R.drawable.sticker5,R.drawable.sticker6,R.drawable.sticker7,R.drawable.sticker8};
    int[] Loves={R.drawable.sticker1,R.drawable.sticker2,R.drawable.sticker3,R.drawable.sticker4,R.drawable.sticker5,R.drawable.sticker6,R.drawable.sticker7,R.drawable.sticker8};
    int[] Words={R.drawable.sticker9,R.drawable.sticker10,
            R.drawable.sticker11,R.drawable.sticker12,R.drawable.sticker13,R.drawable.sticker14,R.drawable.sticker15,R.drawable.sticker16,R.drawable.sticker17,R.drawable.sticker18};
    int[] Mask={R.drawable.sticker19,R.drawable.sticker20,
            R.drawable.sticker21,R.drawable.sticker22,R.drawable.sticker23,R.drawable.sticker24,R.drawable.sticker25,R.drawable.sticker26,R.drawable.sticker27};
    int[] Birthday={R.drawable.sticker28,R.drawable.sticker29,R.drawable.sticker30,
            R.drawable.sticker31,R.drawable.sticker32,R.drawable.sticker33,R.drawable.sticker34,R.drawable.sticker35,R.drawable.sticker36};
    int[] Cat={R.drawable.sticker37,R.drawable.sticker38,R.drawable.sticker39,R.drawable.sticker40,
            R.drawable.sticker41,R.drawable.sticker42,R.drawable.sticker43,R.drawable.sticker44,R.drawable.sticker45};
    int[] Cute={R.drawable.sticker46,R.drawable.sticker47,R.drawable.sticker48,R.drawable.sticker49,R.drawable.sticker50,
            R.drawable.sticker51,R.drawable.sticker52,R.drawable.sticker53,R.drawable.sticker54};
    int[] Caps={R.drawable.sticker55,R.drawable.sticker56,R.drawable.sticker57,R.drawable.sticker58,R.drawable.sticker59,R.drawable.sticker60,
            R.drawable.sticker61,R.drawable.sticker62,R.drawable.sticker63};
    int[] Glasses={R.drawable.sticker64,R.drawable.sticker65,R.drawable.sticker66,R.drawable.sticker67,R.drawable.sticker68,R.drawable.sticker69,R.drawable.sticker70,
            R.drawable.sticker71,R.drawable.sticker72};
    int[] Animals={R.drawable.sticker73,R.drawable.sticker74,R.drawable.sticker75,R.drawable.sticker33,R.drawable.sticker34,R.drawable.sticker35,R.drawable.sticker36};

    int[] testBgs = {R.drawable.b0, R.drawable.bg1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6, R.drawable.b7, R.drawable.b8, R.drawable.b9, R.drawable.b10, R.drawable.b11, R.drawable.b12, R.drawable.b13, R.drawable.b14, R.drawable.b15};
    static EditText editing;
    private static final String TAG = MainActivity.class.getSimpleName();
    private StickerView stickerView;
    static int selectpos;
  //  private TextSticker sticker;
    static Context context;
    static ArrayList<Boolean> bb = new ArrayList<>();
    static BitmapStickerIcon deleteIcon, zoomIcon, flipIcon, heartIcon;
    static ArrayList<Boolean> booleandd = new ArrayList<Boolean>();
    static TextSticker textsticker;
    RecyclerView text_recyclerview,sticker_recyclerview,sticker_title_recyclerview;
    Adapter_TestBgs adapter_testBgs;
    Adapter_Stickers adapter_stickers;
    Adapter_Sticker_Titles adapter_sticker_titles;
    int width, height;
    LinearLayout colorslayout;
    Button btn_style;
    Button btn_font;
    Button btn_keyboard;
    ColorSeekBar colorSeekBar;
CheckBox alphabarCheck;
ListView listview_fontStyles;
    ImageView txtimg_done;
    ImageView text_img_cancel;
    ArrayAdapter<String> adapter_styles;
    String[] font_styles = {
            "fonts/Beyond Wonderland.ttf", "fonts/BrushScriptStd.otf", "fonts/FancyPantsNF.otf", "fonts/Fiddums Family.ttf",
            "fonts/Fortunaschwein_complete.ttf", "fonts/FUNDR__.TTF", "fonts/HoboStd.otf", "fonts/hotpizza.ttf",
            "fonts/micross.ttf", "fonts/NuevaStd-Bold.otf", "fonts/NuevaStd-BoldCond.otf", "fonts/NuevaStd-BoldCondItalic.otf",
            "fonts/NuevaStd-Cond.otf", "fonts/NuevaStd-CondItalic.otf", "fonts/NuevaStd-Italic.otf",
            "fonts/Road_Rage.otf", "fonts/Scratch X.ttf", "fonts/segoepr.ttf",
            "fonts/segoeprb.ttf", "fonts/TEXAT BOLD PERSONAL USE__.otf", "fonts/Trumpit.otf"
    };

    @Override
    public boolean moveTaskToBack(boolean nonRoot) {
        return super.moveTaskToBack(nonRoot);
    }

    LinearLayout sticker_linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics mertics = this.getResources().getDisplayMetrics();
        width = mertics.widthPixels;
        height = mertics.heightPixels;
        context = this;

        iconsSetting();

        bean_stickerses_list=new ArrayList<>();
        bean_stickerses_list.clear();

        bean_stickerses_list.add(new Bean_Stickers("Wishes",Wishes));
        bean_stickerses_list.add(new Bean_Stickers("Love",Loves));
        bean_stickerses_list.add(new Bean_Stickers("Words",Words));
        bean_stickerses_list.add(new Bean_Stickers("Mask",Mask));
        bean_stickerses_list.add(new Bean_Stickers("Birthday",Birthday));
        bean_stickerses_list.add(new Bean_Stickers("Cat",Cat));
        bean_stickerses_list.add(new Bean_Stickers("Cute",Cute));
        bean_stickerses_list.add(new Bean_Stickers("Caps",Caps));
        bean_stickerses_list.add(new Bean_Stickers("Glasses",Glasses));
        bean_stickerses_list.add(new Bean_Stickers("Animals",Animals));


        sticker_linear=(LinearLayout)findViewById(R.id.sticker_linear) ;
        dialog_text1=(RelativeLayout)findViewById(R.id.dialog_text1);
        dialog_text1.getLayoutParams().height=(int)(height/2.5);
        stickerView = (StickerView) findViewById(R.id.sticker_view);
        stickerView.setBackgroundColor(Color.WHITE);
        stickerView.setLocked(false);
        stickerView.setConstrained(true);


        editing = (EditText) findViewById(R.id.editing);

        stickerView.setOnStickerOperationListener(new StickerView.OnStickerOperationListener() {
            @Override
            public void onStickerClicked(Sticker sticker) {
                if (stickerView.getCurrentSticker() instanceof TextSticker) {
                    stickerView.setIcons(Arrays.asList(deleteIcon, zoomIcon, flipIcon, heartIcon));
                } else {
                    stickerView.setIcons(Arrays.asList(deleteIcon, zoomIcon, flipIcon));
                }
                Log.d(TAG, "onStickerClicked");
            }

            @Override
            public void onStickerDeleted(Sticker sticker) {
                Log.d(TAG, "onStickerDeleted");
            }

            @Override
            public void onStickerDragFinished(Sticker sticker) {
                Log.d(TAG, "onStickerDragFinished");
            }

            @Override
            public void onStickerZoomFinished(Sticker sticker) {
                Log.d(TAG, "onStickerZoomFinished");
            }

            @Override
            public void onStickerFlipped(Sticker sticker) {
                Log.d(TAG, "onStickerFlipped");
            }

            @Override
            public void onStickerDoubleTapped(Sticker sticker) {

                Log.e("  double tap "," double tap");
                if (sticker instanceof TextSticker) {
                    textsticker = (TextSticker)sticker;
                    editing.setText(textsticker.getText());
                    editing.setSelection(textsticker.getText().toString().length());

                    dialog_text1.setVisibility(View.VISIBLE);
                  keypadHideAndShow();
                editing.requestFocus();}
            }
        });
        text_recyclerview = (RecyclerView) findViewById(R.id.text_recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 1);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        text_recyclerview.setHasFixedSize(true);
        text_recyclerview.setLayoutManager(gridLayoutManager);
        text_recyclerview.setItemViewCacheSize(testBgs.length);
        adapter_testBgs = new Adapter_TestBgs(context, testBgs, width, height);
        text_recyclerview.setAdapter(adapter_testBgs);
        text_recyclerview.addOnItemTouchListener(new RecyclerTouchListener(context, text_recyclerview, new RecyclerTouchListener.RecyclerClick_Listener() {

            @Override
            public void onLongClick(View view, int position) {

            }

            @Override
            public void onClick(View view, int position) {

                try {
                    testAdd(position);
                    text_recyclerview.setVisibility(View.GONE);
                    editing.setText("Enter text");
                    editing.setCursorVisible(true);
                    editing.setSelection(editing.getText().length());

                    dialog_text1.setVisibility(View.VISIBLE);
                 keypadHideAndShow();
                    editing.setFocusable(true);
                    editing.requestFocus();
                    Toast.makeText(context, " Position " + position, Toast.LENGTH_SHORT).show();
                } catch (ClassCastException e) {

                } catch (Exception e) {

                }
            }
        }));


        sticker_recyclerview = (RecyclerView) findViewById(R.id.sticker_recyclerview);
        sticker_recyclerview.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(context, 1);
        gridLayoutManager1.setOrientation(GridLayoutManager.HORIZONTAL);
        sticker_recyclerview.setLayoutManager(gridLayoutManager1);
        sticker_recyclerview.setItemViewCacheSize(bean_stickerses_list.get(0).getStickerArray().length);
        adapter_stickers = new Adapter_Stickers(context, bean_stickerses_list.get(0).getStickerArray(), width, height);
        sticker_recyclerview.setAdapter(adapter_stickers);
        sticker_recyclerview.addOnItemTouchListener(new RecyclerTouchListener(context, text_recyclerview, new RecyclerTouchListener.RecyclerClick_Listener() {

            @Override
            public void onLongClick(View view, int position) {

            }

            @Override
            public void onClick(View view, int position) {

                try {dialog_text1.setVisibility(View.GONE);
                    loadSticker(position);
                    Toast.makeText(context, " Position " + position, Toast.LENGTH_SHORT).show();
                } catch (ClassCastException e) {

                } catch (Exception e) {

                }
            }
        }));

        sticker_title_recyclerview = (RecyclerView) findViewById(R.id.sticker_title_recyclerview);
        sticker_title_recyclerview.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(context, 1);
        gridLayoutManager2.setOrientation(GridLayoutManager.HORIZONTAL);
        sticker_title_recyclerview.setLayoutManager(gridLayoutManager2);
        sticker_title_recyclerview.setItemViewCacheSize(bean_stickerses_list.size());
        adapter_sticker_titles = new Adapter_Sticker_Titles(context, bean_stickerses_list, width, height);
        sticker_title_recyclerview.setAdapter(adapter_sticker_titles);
        sticker_title_recyclerview.addOnItemTouchListener(new RecyclerTouchListener(context, sticker_title_recyclerview, new RecyclerTouchListener.RecyclerClick_Listener() {

            @Override
            public void onLongClick(View view, int position) {

            }

            @Override
            public void onClick(View view, int position) {

                try { selectpos=position;
                    adapter_stickers = new Adapter_Stickers(context, bean_stickerses_list.get(position).getStickerArray(), width, height);

                    sticker_recyclerview.setAdapter(adapter_stickers);
                    adapter_sticker_titles.notifyDataSetChanged();
                    Toast.makeText(context, " Position " + position, Toast.LENGTH_SHORT).show();
                } catch (ClassCastException e) {

                } catch (Exception e) {

                }
            }
        }));
        editing.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                textsticker = (TextSticker) stickerView.getCurrentSticker();
                textsticker.setText(editing.getText().toString().trim());
                textsticker.setTextColor(Color.BLACK);
                textsticker.setTextAlign(Layout.Alignment.ALIGN_CENTER);
                textsticker.resizeText();
                stickerView.replace(textsticker);
                stickerView.invalidate();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        colorslayout=(LinearLayout)findViewById(R.id.colorslayout);

        alphabarCheck=(CheckBox)findViewById(R.id.alphabarCheck);
        colorSeekBar=(ColorSeekBar)findViewById(R.id.colorSlider);
        colorSeekBar.setMaxPosition(100);
        colorSeekBar.setShowAlphaBar(alphabarCheck.isChecked());
        colorSeekBar.setThumbHeight(30);

        alphabarCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean status) {
                colorSeekBar.setShowAlphaBar(status);
            }
        });
        colorSeekBar.setOnInitDoneListener(new ColorSeekBar.OnInitDoneListener() {
            @Override
            public void done() {

            }
        });
        colorSeekBar.setOnColorChangeListener(new ColorSeekBar.OnColorChangeListener() {
            @Override
            public void onColorChangeListener(int colorBarPosition, int alphaBarPosition, int color) {
                editing.setTextColor(color);
                textsticker = (TextSticker) stickerView.getCurrentSticker();
                 textsticker.setTextColor(color);
                stickerView.replace(textsticker);
                stickerView.invalidate();
            }
        });
        listview_fontStyles=(ListView)findViewById(R.id.listview_fontStyles);
        Adapter_Fonts adapter_fonts=new Adapter_Fonts(context,font_styles);
        listview_fontStyles.setAdapter(adapter_fonts);
        listview_fontStyles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Typeface   tf1 = Typeface.createFromAsset(context.getAssets(), font_styles[position]);
                editing.setTypeface(tf1);
                textsticker = (TextSticker) stickerView.getCurrentSticker();
                textsticker.setTypeface(tf1);
                stickerView.replace(textsticker);
                stickerView.invalidate();
            }
        });
        btn_style=(Button)findViewById(R.id.btn_style);
        btn_style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keypadHideAndShow();
                colorslayout.setVisibility(View.VISIBLE);
                listview_fontStyles.setVisibility(View.GONE);
            }
        });
        btn_font=(Button)findViewById(R.id.btn_font);
        btn_font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keypadHideAndShow();
                listview_fontStyles.setVisibility(View.VISIBLE);
                colorslayout.setVisibility(View.GONE);
            }
        });

        btn_keyboard=(Button)findViewById(R.id.btn_keyboard);
        btn_keyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keypadHideAndShow();
                editing.requestFocus();
            }
        });
        txtimg_done=(ImageView)findViewById(R.id.txtimg_done);
        txtimg_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_text1.setVisibility(View.GONE);
            }
        });
        text_img_cancel=(ImageView)findViewById(R.id.text_img_cancel);
        text_img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editing.setText("");


            }
        });



   /* if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(this,
          new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE,  Manifest.permission.READ_EXTERNAL_STORAGE}, 110);
    } else {
      loadSticker();
    }*/
    }
    public void iconsSetting()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //currently you can config your own icons and icon event
        //the event you can custom
        deleteIcon = new BitmapStickerIcon(ContextCompat.getDrawable(this,
                R.drawable.sticker_ic_close_white_18dp),
                BitmapStickerIcon.LEFT_TOP);
        deleteIcon.setIconEvent(new DeleteIconEvent());

        zoomIcon = new BitmapStickerIcon(ContextCompat.getDrawable(this,
                R.drawable.sticker_ic_scale_white_18dp),
                BitmapStickerIcon.RIGHT_BOTOM);
        zoomIcon.setIconEvent(new ZoomIconEvent());

        flipIcon = new BitmapStickerIcon(ContextCompat.getDrawable(this,
                R.drawable.sticker_ic_flip_white_18dp),
                BitmapStickerIcon.RIGHT_TOP);
        flipIcon.setIconEvent(new FlipHorizontallyEvent());

        heartIcon =
                new BitmapStickerIcon(ContextCompat.getDrawable(this, R.drawable.sticker_ic_mode_edit_white_24dp),
                        BitmapStickerIcon.LEFT_BOTTOM);
        heartIcon.setIconEvent(new HelloIconEvent());

        //default icon layout
        //stickerView.configDefaultIcons();



        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            toolbar.inflateMenu(R.menu.menu_save);
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == R.id.item_save) {
                        File file = FileUtil.getNewFile(MainActivity.this, "Sticker");
                        if (file != null) {
                            stickerView.save(file);
                            Toast.makeText(MainActivity.this, "saved in " + file.getAbsolutePath(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "the file is null", Toast.LENGTH_SHORT).show();
                        }
                    }
                    //                    stickerView.replace(new DrawableSticker(
                    //                            ContextCompat.getDrawable(MainActivity.this, R.drawable.haizewang_90)
                    //                    ));
                    return false;
                }
            }); }
    }
public void keypadHideAndShow()
{  InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);}

    private void loadSticker(int position) {

        Drawable drawable1 =
                ContextCompat.getDrawable(getApplicationContext(),stickers[position]);
        stickerView.setIcons(Arrays.asList(deleteIcon, zoomIcon, flipIcon));
        booleandd.add(true);
        stickerView.addSticker(new DrawableSticker(drawable1));


    }



    public void testReplace(View view) {
        if (stickerView.replace(textsticker)) {
            Toast.makeText(MainActivity.this, "Replace Sticker successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Replace Sticker failed!", Toast.LENGTH_SHORT).show();
        }
    }

    public void testLock(View view) {
        stickerView.setLocked(!stickerView.isLocked());
    }

    public void testRemove(View view) {
        if (stickerView.removeCurrentSticker()) {
            Toast.makeText(MainActivity.this, "Remove current Sticker successfully!", Toast.LENGTH_SHORT)
                    .show();
        } else {
            Toast.makeText(MainActivity.this, "Remove current Sticker failed!", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void testRemoveAll(View view) {
        stickerView.removeAllStickers();
    }

    public void sticker(View view) {
        if(sticker_linear.getVisibility()==View.VISIBLE)
        {
            sticker_linear.setVisibility(View.GONE);
        }else
        {
            sticker_linear.setVisibility(View.VISIBLE);
        }
        text_recyclerview.setVisibility(View.GONE);

    }
    public void text(View view)
    {
        if(text_recyclerview.getVisibility()==View.VISIBLE)
        {
            text_recyclerview.setVisibility(View.GONE);
        }else
        {
            text_recyclerview.setVisibility(View.VISIBLE);
        }
        sticker_linear.setVisibility(View.GONE);
    }

    public void testAdd(int position) {

        Drawable drawable = null;
        if (position == 0) {
            drawable =
                    ContextCompat.getDrawable(getApplicationContext(), R.drawable.sticker_transparent_background);
        } else {
            drawable =
                    ContextCompat.getDrawable(getApplicationContext(), testBgs[position]);
        }
        textsticker = new TextSticker(this, drawable);


        textsticker.setText("Enter text");
        textsticker.setTextColor(Color.RED);
        textsticker.setTextAlign(Layout.Alignment.ALIGN_CENTER);
        textsticker.resizeText();
        booleandd.add(false);
        stickerView.setIcons(Arrays.asList(deleteIcon, zoomIcon, flipIcon, heartIcon));
        stickerView.addSticker(textsticker);
    }
   /* public static void booleanValues(int pos)
    {boolean check=booleandd.get(pos);
        if(check)
        {
            stickerView.setIcons(Arrays.asList(deleteIcon, zoomIcon, flipIcon, heartIcon));
        }else
        {
            stickerView.setIcons(Arrays.asList(deleteIcon, zoomIcon, flipIcon,heartIcon));
        }
    }*/


    public static class HelloIconEvent implements StickerIconEvent {
        @Override
        public void onActionDown(StickerView stickerView, MotionEvent event) {

        }

        @Override
        public void onActionMove(StickerView stickerView, MotionEvent event) {

        }

        @Override
        public void onActionUp(StickerView stickerView, MotionEvent event) {
            dialog_text1.setVisibility(View.GONE);
            textsticker = (TextSticker) stickerView.getCurrentSticker();

            editing.setText(textsticker.getText());
            editing.setSelection(textsticker.getText().toString().length());
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            Toast.makeText(stickerView.getContext(), "Hello World! " + textsticker.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
