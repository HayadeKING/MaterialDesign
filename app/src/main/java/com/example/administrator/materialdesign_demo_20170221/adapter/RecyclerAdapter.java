package com.example.administrator.materialdesign_demo_20170221.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.materialdesign_demo_20170221.R;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22 0022.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<Recycler_Holder> {

    private List<String> list;

    private Context context;

    public RecyclerAdapter(Context context, List<String> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public Recycler_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        Recycler_Holder holder = new Recycler_Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Recycler_Holder holder, int position) {
        ImageView imageView = holder.getImageView();
        Glide.with(context).load(list.get(position)).into(imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
