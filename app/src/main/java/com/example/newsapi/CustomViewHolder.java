package com.example.newsapi;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

TextView text_title,text_source;
ImageView src_img;
CardView cardView;


    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        text_title = itemView.findViewById(R.id.tv_title);
        text_source = itemView.findViewById(R.id.tv_source);
        src_img = itemView.findViewById(R.id.headline_img);
        cardView = itemView.findViewById(R.id.main_container);
    }
}
