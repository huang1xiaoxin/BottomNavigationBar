package com.huangxin.bottomnavigationbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PagerFragmentOne extends BasePagerFragment {
    public TextView textView;


    @Override
    protected void fragmentFirstLoadingData() {
        textView.setText("第一个页面");
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.pager_four,container,false);
        textView=view.findViewById(R.id.tv_pager);
        return view;
    }
}
