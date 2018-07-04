package com.zxn.fragmentheight.news.presenter;

import com.zxn.fragmentheight.news.bean.ListInfo;
import com.zxn.fragmentheight.news.model.NewsModelImpl;
import com.zxn.fragmentheight.news.view.INewsView;

import java.util.List;

public class NewsPresenterImpl implements INewsPresenter<List<ListInfo.DataBean>> {

    private INewsView mView;
    private final NewsModelImpl model;
    private int index = 0;;
    private boolean isDropDown;

    public NewsPresenterImpl(INewsView view) {
        mView = view;
        model = new NewsModelImpl(this);
    }

    @Override
    public void loadData(boolean isDropDown) {
        this.isDropDown = isDropDown;
        index++;
        model.loadData(index);
    }

    @Override
    public void onLoadData(List<ListInfo.DataBean> data) {
        mView.onLoadData(data,isDropDown);
    }
}
