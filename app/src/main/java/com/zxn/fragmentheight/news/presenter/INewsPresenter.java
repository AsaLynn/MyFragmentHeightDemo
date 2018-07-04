package com.zxn.fragmentheight.news.presenter;

public interface INewsPresenter<T> {

    void loadData(boolean isDropDown);

    void onLoadData(T data);

}
