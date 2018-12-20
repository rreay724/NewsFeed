package com.example.android.newsfeed;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class TopHeadlinesFragment extends Fragment
        implements LoaderManager.LoaderCallbacks<List<News>> {

    public static final String NEWS_FEED_URL =
            "https://newsapi.org/v2/top-headlines?country=us&apiKey=a3f791903c1a4163b223dd033563084b";

    private static final int NEWS_LOADER_ID = 1;
    private NewsAdapter mNewsAdapter;
    private NewsAdapterListing mNewsAdapterListing;


    public TopHeadlinesFragment(){
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.news_list, container, false);

        mNewsAdapter = new NewsAdapter(getActivity(), new ArrayList<News>());

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(mNewsAdapter);

        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(NEWS_LOADER_ID, null, this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newsArticleDisplayIntent = new Intent(getActivity(), FullArticleListing.class);
                startActivity(newsArticleDisplayIntent);

            }
        });

        return rootView;
    }


    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        return new NewsLoader(getActivity(), NEWS_FEED_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> data) {
        mNewsAdapter.clear();

        if (data != null && !data.isEmpty()){
            mNewsAdapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        mNewsAdapter.clear();
    }

    public static class NewsLoader extends AsyncTaskLoader<List<News>> {
        private String[] mUrl;

        public NewsLoader(Context context, String... url) {
            super(context);
            mUrl = url;
        }

        @Override
        protected void onStartLoading() {
            forceLoad();
        }

        @Override
        public List<News> loadInBackground() {
            if (mUrl.length < 1 || mUrl[0] == null) {
                return null;
            }
            return JsonQueryUtils.fetchNewsData(mUrl[0]);
        }
    }
}
