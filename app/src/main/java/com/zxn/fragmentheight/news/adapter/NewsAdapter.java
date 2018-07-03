package com.zxn.fragmentheight.news.adapter;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zxn.fragmentheight.R;
import com.zxn.fragmentheight.news.bean.ListInfo;

public class NewsAdapter extends BaseQuickAdapter<ListInfo.DataBean,BaseViewHolder> {

    public NewsAdapter() {
        super(R.layout.item_food);
    }

    @Override
    protected void convert(BaseViewHolder helper, ListInfo.DataBean item) {
        helper.setText(R.id.title_tv, item.getTitle());
        helper.setText(R.id.food_str_tv, item.getFood_str());
    }
}
