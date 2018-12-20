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

public class NewsAdapterListing extends ArrayAdapter<News> {

    public NewsAdapterListing (Context context, List<News> news){
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.article_listing, parent, false  );
        }

        News currentNews = getItem(position);

        TextView titleView = listItemView.findViewById(R.id.articleTitleTextView);
        titleView.setText(currentNews.getTitle());

        TextView authorView = listItemView.findViewById(R.id.articleSourceTextView);
        authorView.setText(currentNews.getSource());

        ImageView newsImage = listItemView.findViewById(R.id.articleImageView);
        newsImage.setImageBitmap(currentNews.getNewsImage());

        TextView articleTextView = listItemView.findViewById(R.id.articleSummaryTextView);
        articleTextView.setText(currentNews.getNewsArticle());

        return listItemView;
    }
}

