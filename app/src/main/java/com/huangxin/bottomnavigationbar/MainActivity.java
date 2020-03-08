package com.huangxin.bottomnavigationbar;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private int count=5;
    public Button button;
    private Handler handler=new Handler();
    private  boolean isLauncher=false;
    private Timer timer=new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        //点击跳过
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLauncherActivity();
            }
        });
        //等待时间一秒，停顿时间一秒
        timer.schedule(task,1000,1000);
        //多少秒之后执行操作
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               startLauncherActivity();
            }
        },5000);
    }

    private void startLauncherActivity() {
        if(!isLauncher){
            isLauncher=true;
            Intent intent=new Intent(MainActivity.this,LauncherActivity.class);
            startActivity(intent);
        }
        //退出当前的Activity
        finish();
    }
    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            //切换回Ui 线程
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    count--;
                    button.setText(count+"s|跳过");
                    if(count<=0){
                        //取消计时器
                        timer.cancel();
                        startLauncherActivity();
                    }

                }
            });
        }
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //将handler去除
        if(handler!=null){
            handler.removeCallbacks(null);
        }
        if(timer!=null){
            timer.cancel();
        }

    }
}
