package com.alafighting.swipelayout.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alafighting.swipelayout.OnLoadMoreListener;
import com.alafighting.swipelayout.OnRefreshListener;
import com.alafighting.swipelayout.SwipeRefreshExpandLayout;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements OnRefreshListener, OnLoadMoreListener {

    SwipeRefreshExpandLayout swipeToLoadLayout;

    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        swipeToLoadLayout = (SwipeRefreshExpandLayout) findViewById(R.id.swipeToLoadLayout);

        ListView listView = (ListView) findViewById(R.id.lv);

        swipeToLoadLayout.setOnRefreshListener(this);

        swipeToLoadLayout.setOnLoadMoreListener(this);

        mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1);

        listView.setAdapter(mAdapter);

        autoRefresh();
    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);
                mAdapter.add("REFRESH:\n" + new Date());
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
                mAdapter.add("LOAD MORE:\n" + new Date());
            }
        }, 2000);
    }

    private void autoRefresh() {
        swipeToLoadLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(true);
            }
        });
    }
}

