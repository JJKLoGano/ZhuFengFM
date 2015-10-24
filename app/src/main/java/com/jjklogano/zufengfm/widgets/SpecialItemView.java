package com.jjklogano.zufengfm.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jjklogano.zufengfm.R;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/22<br/>
 */

/**
 * 用于发现-》推荐-》精品听单 栏目使用的ITEM
 */
public class SpecialItemView extends RelativeLayout {

    private ImageView imageIcon;
    private TextView textTilte;
    private TextView subTilte;
    private TextView footNote;
    private ImageView arrowMore;
    private ImageView line;

    /**
     * new SpecialItemView（context）调用
     * @param context
     */
    public SpecialItemView(Context context) {
        super(context);
    }

    /**
     * 布局中使用时调用的构造
     * @param context
     * @param attrs
     */
    public SpecialItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SpecialItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs) {

        int px = convertDipOrPx(context, 64);
        //初始化
        imageIcon = new ImageView(context);

        //设置属性
        //layoutParams 代表 android:xxxxx这样的属性
        //应使用父容器所属的LayoutParams
        LayoutParams params = new LayoutParams(px, px);
        params.addRule(CENTER_VERTICAL);
        params.setMargins(0, 0, convertDipOrPx(context, 8), 0);

        imageIcon.setLayoutParams(params);
        //设置ID
        imageIcon.setId(R.id.special_item_icon);
        imageIcon.setImageResource(R.mipmap.album_cover_bg);
        addView(imageIcon);

        arrowMore = new ImageView(context);
        LayoutParams params4 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params4.addRule(CENTER_VERTICAL);
        params4.addRule(ALIGN_PARENT_RIGHT);

        arrowMore.setLayoutParams(params4);
        //设置ID
        arrowMore.setId(R.id.special_item_arrowmore);
        arrowMore.setImageResource(R.mipmap.arrow_right);

        addView(arrowMore);


        textTilte = new TextView(context);

        LayoutParams params1 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params1.addRule(RIGHT_OF, R.id.special_item_icon);

        textTilte.setLayoutParams(params1);
        textTilte.setText("hahahha");
        textTilte.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        textTilte.setSingleLine(true);
        textTilte.setEllipsize(TextUtils.TruncateAt.END);
        textTilte.setTextColor(Color.BLACK);
        textTilte.setId(R.id.special_item_title);

        addView(textTilte);

        subTilte = new TextView(context);

        LayoutParams params2 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params2.addRule(RIGHT_OF, R.id.special_item_icon);
        params2.addRule(CENTER_VERTICAL);

        subTilte.setLayoutParams(params2);
        subTilte.setText("subtitle");
        subTilte.setSingleLine(true);
        subTilte.setEllipsize(TextUtils.TruncateAt.END);
        subTilte.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        subTilte.setId(R.id.special_item_subtitle);

        addView(subTilte);

        footNote = new TextView(context);

        LayoutParams params3 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params3.addRule(RIGHT_OF, R.id.special_item_icon);
        params3.addRule(CENTER_VERTICAL);
        params3.addRule(BELOW, R.id.special_item_subtitle);

        footNote.setLayoutParams(params3);
        footNote.setText("subtitle");
        footNote.setSingleLine(true);
        footNote.setEllipsize(TextUtils.TruncateAt.END);
        footNote.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        Drawable drawable = getResources().getDrawable(R.mipmap.finding_album_img);
        drawable.setBounds(0, 0, 20, 20);
        footNote.setCompoundDrawables(drawable, null, null, null);
        footNote.setId(R.id.special_item_footnote);

        addView(footNote);

        line=new ImageView(context);

        LayoutParams params5 = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params5.addRule(RIGHT_OF,R.id.special_item_icon);
        params5.addRule(ALIGN_BOTTOM,R.id.special_item_icon);
        params5.addRule(BELOW,R.id.special_item_footnote);

        line.setLayoutParams(params5);
        line.setImageResource(R.mipmap.follow_item_selected);

        addView(line);

    }

    public static int convertPxOrDip(Context context, int px) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(px/scale + 0.5f*(px>=0?1:-1));
    }
    public static int convertDipOrPx(Context context, int dip) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dip*scale + 0.5f*(dip>=0?1:-1));
    }


    public void setTitle(String str){
        textTilte.setText(str);
    }



}
