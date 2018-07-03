package com.zxn.fragmentheight.news.presenter;

public interface INewsPresenter<T> {

    void loadData(int index);

    void onLoadData(T data);

}
