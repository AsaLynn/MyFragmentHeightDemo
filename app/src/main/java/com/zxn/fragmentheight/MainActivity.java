package com.zxn.fragmentheight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dinuscxj.refresh.RecyclerRefreshLayout;
import com.zxn.fragmentheight.news.adapter.NewsAdapter;
import com.zxn.fragmentheight.news.bean.ListInfo;
import com.zxn.fragmentheight.news.presenter.INewsPresenter;
import com.zxn.fragmentheight.news.presenter.NewsPresenterImpl;
import com.zxn.fragmentheight.news.view.INewsView;

import org.xutils.x;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements INewsView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    RecyclerRefreshLayout refreshLayout;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        x.Ext.init(getApplication());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter = new NewsAdapter();
        recyclerView.setAdapter(adapter);

        INewsPresenter presenter = new NewsPresenterImpl(this);
        int index = 1;
        presenter.loadData(index);
    }


    @Override
    public void onLoadData(List<ListInfo.DataBean> data) {
        adapter.addData(data);
    }
}
