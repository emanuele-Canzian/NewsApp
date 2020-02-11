package com.example.android.newsApp;

public class News {
    private String sectionName;
    private String webTitle;
    private String dateTime;
    private String webUrl;

    public String getSectionName() {
        return sectionName;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public News(String sectionName, String webTitle, String dateTime, String webUrl) {
        this.sectionName = sectionName;
        this.webTitle = webTitle;
        this.dateTime = dateTime;
        this.webUrl = webUrl;
    }

    public News(String sectionName, String webTitle, String dateTime) {
        this.sectionName = sectionName;
        this.webTitle = webTitle;
        this.dateTime = dateTime;
    }
}
