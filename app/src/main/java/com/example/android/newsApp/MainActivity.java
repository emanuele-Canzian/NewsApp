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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        WorldNewsActivity worldNewsActivity = new WorldNewsActivity();
        TextView world_news = (TextView) findViewById(R.id.world_news);

        world_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent worldNewsIntent = new Intent(MainActivity.this,WorldNewsActivity.class);
                startActivity(worldNewsIntent);
            }
        });

        SportActivity sportActivity = new SportActivity();
        TextView sport_news = (TextView) findViewById(R.id.sport_news);

        sport_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sportNewsIntent = new Intent(MainActivity.this,SportActivity.class);
                startActivity(sportNewsIntent);
            }
        });


        PoliticsActivity politicsActivity= new PoliticsActivity();
        TextView politic_news = (TextView) findViewById(R.id.politic_news);

        politic_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent politicNewsIntent = new Intent(MainActivity.this,PoliticsActivity.class);
                startActivity(politicNewsIntent);
            }
        });

        BusinessActivity businessActivity= new BusinessActivity();
        TextView business_news = (TextView) findViewById(R.id.business_news);

        business_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent businessNewsIntent = new Intent(MainActivity.this,BusinessActivity.class);
                startActivity(businessNewsIntent);
            }
        });
        ScienceActivity scienceActivity = new ScienceActivity();
        TextView science_news = (TextView) findViewById(R.id.science_news);

        science_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scienceIntent = new Intent(MainActivity.this,ScienceActivity.class);
                startActivity(scienceIntent);
            }
        });
        GamesActivity gamesActivity = new GamesActivity();
        TextView games_news = (TextView) findViewById(R.id.games_news);

        games_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gamesIntent = new Intent(MainActivity.this,GamesActivity.class);
                startActivity(gamesIntent);
            }
        });
        MusicActivity musicActivity = new MusicActivity();
        TextView music_view = (TextView) findViewById(R.id.music_news);

        music_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent musicIntent = new Intent(MainActivity.this,MusicActivity.class);
                startActivity(musicIntent);
            }
        });


    }
}

