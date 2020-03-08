package com.huangxin.bottomnavigationbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class PagerFour extends BasePager {
    public TextView textView;
    public PagerFour(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view=View.inflate(context,R.layout.pager_four,null);
        textView=view.findViewById(R.id.tv_pager);
        return view;
    }
    //初始化数据
    @Override
    public void initData() {
        super.initData();
        textView.setText("第四个页面");
    }
}
