package com.huangxin.bottomnavigationbar;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<BasePagerFragment> fragmentList;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior, List<BasePagerFragment> fragmentList) {
        super(fm, behavior);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList != null ? fragmentList.get(position) : null;
    }

    @Override
    public int getCount() {
        return fragmentList != null ? fragmentList.size() : 0;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //判断是否要复用Fragment的View
        if (!fragmentList.get(position).isReuseView()){
            super.destroyItem(container, position, object);
        }

    }
}
