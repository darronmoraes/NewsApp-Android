package com.example.newsapi;

import android.content.Context;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapi.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<NewsHeadlines> headlines;

    public CustomAdapter(Context context, List<NewsHeadlines> headlines) {
        this.context = context;
        this.headlines = headlines;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {


        // set text
        holder.text_title.setText(headlines.get(position).getTitle()); //title
        holder.text_source.setText(headlines.get(position).getSource().getName()); //source

        //Image src validation
        if (headlines.get(position).getUrlToImage() != null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.src_img);


        }

    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
