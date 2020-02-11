package com.example.android.newsApp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String LOCATION_SEPARATOR = " of ";


    public NewsAdapter( Context context, List<News> objects) {
        super(context, 0, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent,false
            );
        }

        News currentNews = getItem(position);

        /*String originalCategory = currentNews.getSectionName();*/
        TextView categoryItem = (TextView) listItemView.findViewById(R.id.category_item);
        categoryItem.setText(currentNews.getSectionName());

        TextView titleItem = (TextView) listItemView.findViewById(R.id.title_item);
        titleItem.setText(currentNews.getWebTitle());

        String reformatDateTime = currentNews.getDateTime().substring(0,10);
        String[] dateArray = reformatDateTime.split("-");
        String orginalDateTime = dateArray[1] + "." + dateArray[2] +"."+ dateArray[0];
        TextView timeItem = (TextView) listItemView.findViewById(R.id.date_item);
        timeItem.setText(orginalDateTime);


        return listItemView;
    }
}
