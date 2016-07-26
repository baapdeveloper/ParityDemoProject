package com.android.com.paritydemoproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mukesh.teckwani on 24-07-2016.
 */
public class DetailActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.layout_detail);
        initActionBar();
    }

    private void initActionBar() {

        android.support.v7.app.ActionBar action = getSupportActionBar();
        action.setDisplayShowHomeEnabled(false);
        action.setDisplayShowCustomEnabled(true);
        LayoutInflater li = LayoutInflater.from(this);
        View customView = li.inflate(R.layout.layout_toolbar, null);
        customView.findViewById(R.id.iv_navigation).setVisibility(View.GONE);
        customView.findViewById(R.id.iv_left_icon).setVisibility(View.VISIBLE);
        customView.findViewById(R.id.iv_notification).setVisibility(View.GONE);
        customView.findViewById(R.id.iv_liked).setVisibility(View.VISIBLE);
        ((TextView) customView.findViewById(R.id.tv_title_main)).setText("Detail Page");
        action.setCustomView(customView);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
