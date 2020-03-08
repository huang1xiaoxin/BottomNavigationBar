package com.huangxin.bottomnavigationbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class PagerThree extends BasePager {
    public TextView textView;

    public PagerThree(Context context) {
        super(context);

    }

    @Override
    public View initView() {
        View view= View.inflate(context,R.layout.pager_three,null);
        textView=view.findViewById(R.id.tv_pager);
        return view;
    }
    //初始化数据
    @Override
    public void initData() {
        super.initData();
        textView.setText("第三个页面");
    }
}
