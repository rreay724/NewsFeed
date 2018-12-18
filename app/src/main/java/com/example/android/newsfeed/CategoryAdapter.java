package com.example.android.newsfeed;



import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v13.app.FragmentPagerAdapter;


@SuppressWarnings("deprecation")
public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new TopHeadlinesFragment();
        } else {
            return new SearchHeadlinesFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return mContext.getString(R.string.top_headlines_fragment);
        }else{
            return mContext.getString(R.string.search_headlines_fragment);
        }
    }
}
