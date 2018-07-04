package com.zxn.fragmentheight.news.model;

import com.google.gson.Gson;
import com.zxn.fragmentheight.news.bean.ListInfo;
import com.zxn.fragmentheight.news.presenter.INewsPresenter;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

public class NewsModelImpl implements INewsModel {

    private INewsPresenter mPresenter;
    private Gson gson;
    private MyCallback callback = new MyCallback() {

        @Override
        public void onSuccess(String result) {
            ListInfo listInfo = gson.fromJson(result, ListInfo.class);
            List<ListInfo.DataBean> data = listInfo.getData();
            mPresenter.onLoadData(data);
        }
    };
    private boolean isDropDown;
    ;

    public NewsModelImpl(INewsPresenter presenter) {
        gson = new Gson();
        mPresenter = presenter;
    }

    @Override
    public void loadData(final int index) {
        //      http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=10&page=1
        this.isDropDown = isDropDown;
        x.http().get(new RequestParams() {
            {
                setUri("http://www.qubaobei.com/ios/cf/dish_list.php");
                addParameter("stage_id", "1");
                addParameter("limit", "5");
                addParameter("page", index);
            }
        }, callback);
    }
}


//            @Override
//            public void onSuccess(String result) {
//                if (list.size() != 0) {
//                    list.clear();
//                }
//                list.addAll(data);
//                if (null == foodAdapter) {
//                    foodAdapter = new FoodAdapter(list, PullToRefreshListActivity.this);
//                    actualListView.setAdapter(foodAdapter);
//                } else {
//                    foodAdapter.notifyDataSetChanged();
//                }
//                mPullRefreshListView.onRefreshComplete();
//            }
