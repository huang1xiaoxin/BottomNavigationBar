package com.huangxin.bottomnavigationbar;

import android.content.Context;
import android.view.View;

/**
 * 实现一个基类，让每个页面去继承
 */
public abstract class BasePager {
    public  Context context;
    //获取一个视图
    public View rootView;
    //是否已经初始化数据
    public boolean isInitData=false;
    public BasePager(Context context){
        this.context=context;
       rootView=initView();//调用子类的方法
        isInitData=false;
    }
    //强制让每个子类去实现这个方法初始化视图
    public abstract View initView();

    //初始化数据的方法，子类可以有选择性重写
    public void  initData(){

    }
}
