package com.example.android.newsApp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    private News news;

    @Before
    public void setUp(){
        news = new News("test","test","test","test");
    }


    @Test
    public void getSectionName() {

        assertEquals("test",news.getSectionName());
        assertEquals("test",news.getWebUrl());
        assertEquals("test",news.getDateTime());
        assertEquals("test",news.getWebTitle());
    }
}