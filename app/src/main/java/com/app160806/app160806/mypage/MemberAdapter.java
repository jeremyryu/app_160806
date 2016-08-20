package com.app160806.app160806.mypage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app160806.app160806.R;
import com.app160806.app160806.member.MemberBean;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-08-20.
 */
public class MemberAdapter extends BaseAdapter {
    ArrayList<MemberBean>list;
    LayoutInflater inflater;
    int[] imgs = {
            R.drawable.cupcake,
            R.drawable.donut,
            R.drawable.eclair,
            R.drawable.froyo,
            R.drawable.gingerbread,
            R.drawable.honeycomb,
            R.drawable.icecream,
            R.drawable.jellybean,
            R.drawable.kitkat,
            R.drawable.lollipop
    };

    public MemberAdapter(Context context, ArrayList<MemberBean>list) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View v, ViewGroup g) {
        ViewHolder holder;
        if (v== null) {
            v = inflater.inflate(0, null);
            holder = new ViewHolder();

            holder.ivPhoto = (ImageView) v.findViewById(0);
            holder.tvName = (TextView) v.findViewById(0);
            holder.tvPhone = (TextView) v.findViewById(0);

            v.setTag(holder);
        }
        else {
            holder = (ViewHolder) v.getTag();
        }

        holder.ivPhoto.setImageResource(0);
        holder.tvName.setText(null);
        holder.tvPhone.setText(null);

        return v;
    }
    static class ViewHolder {
        ImageView ivPhoto;
        TextView  tvName;
        TextView  tvPhone;
    }
}
