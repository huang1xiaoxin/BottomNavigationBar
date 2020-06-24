package com.huangxin.bottomnavigationbar;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class LauncherActivity extends FragmentActivity {
    private List<BasePagerFragment> pagerList;
    private RadioGroup radioGroup;
    private ViewPager viewPager;
    private int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        radioGroup = findViewById(R.id.rg_button);
        viewPager = findViewById(R.id.fr_page);
        pagerList = new ArrayList<>();
        pagerList.add(new PagerFragmentOne());
        pagerList.add(new PagerFragmentTwo());
        pagerList.add(new PagerFragmentThree());
        pagerList.add(new PagerFragmentFour());
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,pagerList));
        //设置RadioGroup的监听事件
        radioGroup.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //默认是第一个
        radioGroup.check(R.id.rb_page1);
        //设置一个ViewPager的监听
        viewPager.addOnPageChangeListener(new ViewPagerChangeListener());
    }
    class ViewPagerChangeListener implements ViewPager.OnPageChangeListener {

        /**
         监听组件的滑动。position为当前页面的索引，positionOffset为当前页面偏移的百分比，positionOffsetPixels为当前页面偏移的像素位置。
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        /**
         监听组件的页面变化。position为当前页面的索引。
         */
        @Override
        public void onPageSelected(int position) {
            if (radioGroup.getChildAt(position) instanceof RadioButton){
                RadioButton radioButton= (RadioButton) radioGroup.getChildAt(position);
                radioButton.setChecked(true);
            }else {
            }
        }
        /**
         监听组件的滑动状态变化。state有3种取值：
         ViewPager.SCROLL_STATE_IDLE = 0; 空闲状态，也是初始状态，此时组件是静止的。
         ViewPager.SCROLL_STATE_DRAGGING = 1; 滑动状态，当手指在屏幕上滑动组件时的状态。
         ViewPager.SCROLL_STATE_SETTLING = 2; 滑动后自然沉降的状态，当手指离开屏幕后，组件继续滑动时的状态。
         */
        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }

    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                default:
                    //点击第一按钮
                    index = 0;

                    break;

                case R.id.rb_page2:
                    index = 1;
                    //点击第二按钮
                    break;
                case R.id.rb_page3:
                    index = 2;
                    //点击第三按钮
                    break;
                case R.id.rb_page4:
                    index = 3;
                    //点击第四按钮
                    break;
            }

                viewPager.setCurrentItem(index,false);

        }
    }

    /**  该方法不使用，为了可以左右滑动，将fragment改成ViewPager
     * 设置视图
     * Caused by: java.lang.IllegalStateException: Fragment
     * null must be a public static class to be
     * properly recreated from instance state.
     * 出现这个异常的原因是不可以在ft.replace(R.id.fr_page,new Fragment())自己创建
     * 不可以通过匿名内部类的方式创建，要将其单独创建继承Fragment
     * https://blog.csdn.net/zfqsmn1126/article/details/80430059
     */
//    public void setPagerView(){
//        FragmentManager fm=getSupportFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//        ft.replace(R.id.fr_page,new ReplaceFragment(getPager()));
//        //提交
//        ft.commit();
//
//    }

}
