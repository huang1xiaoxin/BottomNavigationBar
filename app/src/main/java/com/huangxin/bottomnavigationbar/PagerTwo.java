package com.huangxin.bottomnavigationbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class PagerTwo extends BasePager{

    private TextView textView;
    public PagerTwo(Context context) {
        super(context);

    }

    @Override
    public View initView() {
        //这个context调用的是父类的，无需定义
        View view= View.inflate(context,R.layout.pager_two,null);
        textView=view.findViewById(R.id.tv_pager);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("第二个页面");
    }
}
