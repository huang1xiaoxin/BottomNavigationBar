package com.huangxin.bottomnavigationbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 实现一个基类，让每个页面去继承
 * 支持ViewPager的复用机制，但是需要重写ViewPage适配器的destroyItem()的方法去除super
 * 支持在Fragment可见时加载数据
 * 支持第一次可见时加载数据，也支持每次可见时加载数据
 * 因为之前都是使用setUserVisibleHint()但是这个方法已经被遗弃，用setMaxLifecycle()代替的
 */
public abstract class BasePagerFragment extends Fragment {
    public Context context;
    //获取一个视图
    public View rootView;
    //是否已经初始化数据
    public boolean isFirstLoadData;
    public boolean isReuseView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        initValue();
        return initView(inflater, container, savedInstanceState);
    }

    /**
     * onViewCreated在onCreateView执行完后立即执行。
     * onCreateView返回的就是fragment要显示的view。
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = view;
        }
        super.onViewCreated(isReuseView ? rootView : view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isFirstLoadData) {
            fragmentFirstLoadingData();
            isFirstLoadData = false;
        }
        //提供给当需要每次显示都要更新数据的功能
        fragmentEveryLoadingData();
    }

    /**
     * 支持每次显示都刷新数据
     */

    private void fragmentEveryLoadingData() {
    }

    /**
     * 第一次Fragment显示时加载数据
     */
    protected abstract void fragmentFirstLoadingData();

    //强迫子类去实现，初始化界面的方法
    public abstract View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    public void initValue() {
        isFirstLoadData = true;
        isReuseView=false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isFirstLoadData = true;
        isReuseView=false;
    }

    /**
     * 设置是否复用View，默认为false,关闭
     * view 的复用是指，ViewPager 在销毁和重建 Fragment 时会不断调用 onCreateView() -> onDestroyView()
     *之间的生命函数，这样可能会出现重复创建 view 的情况，导致界面上显示多个相同的 Fragment
     * view 的复用其实就是指保存第一次创建的 view，后面再 onCreateView() 时直接返回第一次创建的 view
     *
     *
     * @param reuseView
     */

    public void setReuseView(boolean reuseView) {
        isReuseView = reuseView;
    }

    public boolean isReuseView() {
        return isReuseView;
    }
}
