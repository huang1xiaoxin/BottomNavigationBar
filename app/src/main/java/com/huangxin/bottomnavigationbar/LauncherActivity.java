package com.huangxin.bottomnavigationbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.annotation.RequiresPermission;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class LauncherActivity extends FragmentActivity {
    private  ArrayList<BasePager> pagerList;
    private RadioGroup radioGroup;
    private  int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
         radioGroup=findViewById(R.id.rg_button);
         pagerList = new ArrayList<>();
         pagerList.add(new PagerOne(this));
         pagerList.add(new PagerTwo(this));
         pagerList.add(new PagerThree(this));
         pagerList.add(new PagerFour(this));
         //设置RadioGroup的监听事件
         radioGroup.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
         //默认是第一个
        radioGroup.check(R.id.rb_page1);
    }

    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i){
                default:
                    //点击第一按钮
                    index=0;
                    break;

                case R.id.rb_page2:
                    index=1;
                    //点击第二按钮
                    break;
                case R.id.rb_page3:
                    index=2;
                    //点击第三按钮
                    break;
                case R.id.rb_page4:
                    index=3;
                    //点击第四按钮
                    break;
            }
            setPagerView();
        }
    }

    /**
     * 设置视图
     * Caused by: java.lang.IllegalStateException: Fragment
     * null must be a public static class to be
     * properly recreated from instance state.
     * 出现这个异常的原因是不可以在ft.replace(R.id.fr_page,new Fragment())自己创建
     * 不可以通过匿名内部类的方式创建，要将其单独创建继承Fragment
     * https://blog.csdn.net/zfqsmn1126/article/details/80430059
     */
    public void setPagerView(){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fr_page,new ReplaceFragment(getPager()));
        //提交
        ft.commit();

    }
    //获取相对应的视图
    private BasePager getPager() {
        BasePager basePager=pagerList.get(index);
        if(basePager!=null&&!basePager.isInitData){
            basePager.isInitData=true;
            basePager.initData();
        }
        return basePager;
    }
}
