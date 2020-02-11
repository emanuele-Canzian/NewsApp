package com.example.android.newsApp;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

public class PoliticsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    private static final String LOG_TAG = PoliticsActivity.class.getName();
    private String worldNewsUrl = "http://content.guardianapis.com/politics?q=debates&api-key=89fe5b56-d2e6-4331-80c7-2ffa7f12c776";
    private static final int NEWS_LOADER_ID = 1;
    private NewsAdapter newsAdapter;
    private TextView mEmptyStateTextView;


    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_politics);


        ListView politicsNewsListView = (ListView) findViewById(R.id.politic_news);
        this.mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);

        politicsNewsListView.setEmptyView(mEmptyStateTextView);

        newsAdapter = new NewsAdapter(this, new ArrayList<News>());
        politicsNewsListView.setAdapter(newsAdapter);



        politicsNewsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                News currentNews = newsAdapter.getItem(position);


                Uri worldUrl = Uri.parse(currentNews.getWebUrl());


                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, worldUrl);


                startActivity(websiteIntent);
            }
        });



        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            LoaderManager loaderManager = getLoaderManager();


            loaderManager.initLoader(NEWS_LOADER_ID, null, this);
        } else {

            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);


            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }

    }

    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle){

        return new NewsLoader(this,worldNewsUrl);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> newses){

        mEmptyStateTextView.setText("no Internet connection");

        if (newses !=  null && !newses.isEmpty()){
            newsAdapter.addAll(newses);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<News>> newses){
        this.newsAdapter.clear();
    }
}
