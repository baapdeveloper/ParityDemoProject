package com.android.com.paritydemoproject;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.com.paritydemoproject.fragment.FragmentForum;
import com.android.com.paritydemoproject.fragment.FragmentRecentPost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukesh.teckwani on 24-07-2016.
 */
public class ScreenActivity extends MainActivity {
    ViewPager pager;
    TabLayout tabLayout;
    Fragment fragmentForum, fragmentRecentPost;
    String[] pagerArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.content_main);
        initView();
        initActionBar();
        setPagerAdapter();
        createTab();
    }

    private void setPagerAdapter() {
        fragmentForum = new FragmentForum();
        fragmentRecentPost = new FragmentRecentPost();
        pagerArray = getResources().getStringArray(R.array.pager_array);
        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(getApplicationContext(), getSupportFragmentManager());
        pagerAdapter.addFragment(fragmentForum, pagerArray[0]);
        pagerAdapter.addFragment(fragmentRecentPost, pagerArray[1]);
        pager.setAdapter(pagerAdapter);
    }

    private void initActionBar() {

        android.support.v7.app.ActionBar action = getSupportActionBar();
        action.setDisplayShowHomeEnabled(false);
        action.setDisplayShowCustomEnabled(true);
        LayoutInflater li = LayoutInflater.from(this);
        View customView = li.inflate(R.layout.layout_toolbar, null);
        ((TextView) customView.findViewById(R.id.tv_title_main)).setText("Forums");
        action.setCustomView(customView);

    }

    private void createTab() {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setText(pagerArray[i]);
        }
        //tabLayout.addTab(new TabLayout.Tab().);
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.pager_screen);
        tabLayout = (TabLayout) findViewById(R.id.tab_screen);
    }

    class CustomPagerAdapter extends FragmentPagerAdapter {
        private Context mContext;

        private List<Fragment> mFragments = new ArrayList<>();
        private List<String> mFragmentTitles = new ArrayList<>();

        public CustomPagerAdapter(Context context, FragmentManager fm) {
            super(fm);
            this.mContext = context;
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = mFragments.get(position);

            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }

    }
}