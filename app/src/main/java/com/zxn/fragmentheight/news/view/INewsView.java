package com.zxn.fragmentheight.news.view;

import com.zxn.fragmentheight.news.bean.ListInfo;

import java.util.List;

public interface INewsView {
    void onLoadData(List<ListInfo.DataBean> data,boolean isDropDown);
}
