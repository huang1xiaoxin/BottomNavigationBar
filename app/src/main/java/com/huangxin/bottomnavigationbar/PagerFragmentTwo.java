package com.huangxin.bottomnavigationbar;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.security.auth.login.LoginException;

public class PagerFragmentTwo extends BasePagerFragment {

    private TextView textView;

    @Override
    protected void fragmentFirstLoadingData() {
        textView.setText("第二个页面");
        Log.e("第二页面", "第一次加载数据");
    }



    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.pager_four,container,false);
        textView=view.findViewById(R.id.tv_pager);
        return view;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("第二页面", "onCreateView: ");
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("第二页面", "onResume: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("第二页面", "onDestroyView: ");
    }
}
