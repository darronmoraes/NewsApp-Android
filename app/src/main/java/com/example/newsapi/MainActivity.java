package com.example.newsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.newsapi.Models.NewsApiResponse;
import com.example.newsapi.Models.Articles;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // objects views and adapter
    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setTitle("getting latest headlines...");
        dialog.show();

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener,"general",null);
    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<Articles> list, String message) {
            showNews(list);
            dialog.dismiss();
        }
        @Override
        public void onError(String message) {
        }
    };

    private void showNews(List<Articles> list) {
        recyclerView = findViewById(R.id.recyclerView_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        customAdapter = new CustomAdapter(this, list);
        recyclerView.setAdapter(customAdapter);
    }
}