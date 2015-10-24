package com.jjklogano.zufengfm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.jjklogano.zufengfm.R;
import com.jjklogano.zufengfm.bean.DiscoverCategory;
import com.jjklogano.zufengfm.utils.HttpTools;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created<br/>
 * Author : LoGano(贾璟琨)<br/>
 * Email : mengpangzhi@hotmial.com<br/>
 * Date : 2015/10/24<br/>
 */
public class DiscoverCategoryAdapter extends BaseAdapter {
    private List<DiscoverCategory> categories;
    private Context context;

    public DiscoverCategoryAdapter( Context context,List<DiscoverCategory> categories) {
        this.categories = categories;
        this.context = context;
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (categories != null) {
            ret = categories.size()/6;
            if(categories.size()%6!=0){
                ret+=1;
            }
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return categories.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView != null) {
            view = convertView;
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.discover_category_list_item, parent, false);
        }
        ViewHolder holder = (ViewHolder) view.getTag();

        if (holder == null) {
            holder = new ViewHolder();
            holder.texts = new TextView[6];
            holder.icons = new ImageView[6];

            for (int i = 0; i < 6; i++) {
                holder.texts[i] = (TextView) findView(view,"discover_category_list_item_text"+i);
                holder.icons[i] = (ImageView) findView(view,"discover_category_list_item_icon"+i);
            }
            view.setTag(holder);
        }

        //设置数据

        for (int i = 0; i < 6; i++) {
            int index =i + 6 * (position);
            if(index<categories.size()) {
                DiscoverCategory category = categories.get(index);
                holder.texts[i].setText(category.getTitle());
                HttpTools.loadImage(context, holder.icons[i], category.getCoverPath());
            }
        }

        return view;
    }
    public static View findView(View container,String fieldName){
        View ret = null;
        if (container != null && fieldName!=null) {
            Class<R.id> idClass = R.id.class;
            try {
                Field declaredField = idClass.getDeclaredField(fieldName);
                int id = declaredField.getInt(idClass);
                ret = container.findViewById(id);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return ret;
    }

    private static class ViewHolder {
        TextView[] texts;
        ImageView[] icons;
    }

}
