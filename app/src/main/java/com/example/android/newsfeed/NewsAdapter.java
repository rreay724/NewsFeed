package com.example.android.newsfeed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News>{

    public NewsAdapter (Context context, List<News> news){
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView titleView = listItemView.findViewById(R.id.titleTextView);
        titleView.setText(currentNews.getTitle());

        TextView authorView = listItemView.findViewById(R.id.sourceTextView);
        authorView.setText(currentNews.getAuthor());

        ImageView newsImage = listItemView.findViewById(R.id.newsImage);
        newsImage.setImageBitmap(currentNews.getNewsImage());

        return listItemView;
    }
}
