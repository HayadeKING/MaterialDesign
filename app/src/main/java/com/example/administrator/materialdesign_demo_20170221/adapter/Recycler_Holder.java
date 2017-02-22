package com.example.administrator.materialdesign_demo_20170221.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.materialdesign_demo_20170221.R;

/**
 * Created by Administrator on 2017/2/22 0022.
 */
public class Recycler_Holder extends RecyclerView.ViewHolder{

    private ImageView imageView;

    private TextView textView;

    private View view;

    public Recycler_Holder(View itemView) {
        super(itemView);
        this.view = itemView;
    }

    public ImageView getImageView(){
        if (imageView == null){
            imageView = (ImageView) view.findViewById(R.id.item_image);
        }
        return imageView;
    }

    public TextView getTextView(){
        if (textView == null){
            textView = (TextView) view.findViewById(R.id.item_text);
        }
        return textView;
    }
}
