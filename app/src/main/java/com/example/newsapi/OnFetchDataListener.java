package com.example.newsapi;

import com.example.newsapi.Models.Articles;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {
    void onFetchData(List<Articles> list, String message);
    void onError(String message);
}
