package com.zxn.fragmentheight.news.model;

import com.google.gson.Gson;
import com.zxn.fragmentheight.news.bean.ListInfo;

import org.xutils.common.Callback;

import java.util.List;

/**
 * Created by think on 2017/11/22.
 */

public class MyCallback implements Callback.CacheCallback<String>{



    public MyCallback() {

    }

    @Override
    public boolean onCache(String result) {
        return false;
    }

    @Override
    public void onSuccess(String result) {

    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }
}
