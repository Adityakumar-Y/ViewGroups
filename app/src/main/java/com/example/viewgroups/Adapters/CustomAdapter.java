package com.example.viewgroups.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.viewgroups.R;

public class CustomAdapter extends BaseAdapter {

    Context context;
    int logo[];

    public CustomAdapter(Context context, int[] logo) {
        this.context = context;
        this.logo = logo;
    }

    @Override
    public int getCount() {
        return logo.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.custom_grid, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.grid_logo);
        imageView.setImageResource(logo[i]);
        return view;
    }
}
