package com.example.android.newsApp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private static final String LOG_TAG = NewsLoader.class.getName();

    private String mUrl;

    public NewsLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }


    @Override
    public ArrayList<News> loadInBackground(){
        if(mUrl == null){
            return null;
        }
        ArrayList<News> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }
}
