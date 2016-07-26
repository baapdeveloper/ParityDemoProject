package com.android.com.paritydemoproject;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected FrameLayout contentMain;
    protected FloatingActionButton fab;
    public CoordinatorLayout clMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        intListener();
        setSupportActionBar(toolbar);
    }

    private void intListener() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        contentMain = (FrameLayout) findViewById(R.id.content_main);
        clMain = (CoordinatorLayout) findViewById(R.id.cl_main);
        fab = (FloatingActionButton) findViewById(R.id.fab);

    }

    protected void setLayout(int resource) {

        getLayoutInflater().inflate(resource, contentMain);
    }


}
