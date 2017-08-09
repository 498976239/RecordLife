package com.recordlife.www.recordlife;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.recordlife.www.recordlife.base.BaseActivity;

/**
 * Created by SS on 17-1-5.
 */
public class SplashActivity extends BaseActivity {
    private static final String FIRST_RUN_KEY = "first_run";
    private TextView version_Name;
    private RelativeLayout layout;
    //获取版本信息
    private String getVersionName() {
        //1.包管理者对象获取
        PackageManager packageManager = getPackageManager();
        //2.从包管理者对象中，获取指定包名的基本信息（版本信息，版本号），传入0代表获取基本信息
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            String versionName = packageInfo.versionName;
            return versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
          return null;
    }

    @Override
    protected void initDate() {
        setContentView(R.layout.activity_splash);
        version_Name = (TextView) findViewById(R.id.versionName);
    }

    @Override
    protected void initView() {
        version_Name.setText("版本"+getVersionName());
         // final boolean First =  SharedPreferencesUtil.getInstance(this).readBoolean(FIRST_RUN_KEY,true);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    /*if(First){
                        SharedPreferencesUtil.getInstance(SplashActivity.this).writeBoolean(FIRST_RUN_KEY,false);
                         Intent intent = new Intent(SplashActivity.this,ViewPagerActivity.class);
                         startActivity(intent);
                        SplashActivity.this.finish();
                    }else{
                        Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                         startActivity(intent);
                        SplashActivity.this.finish();
                    }*/
                    Intent intent = new Intent(SplashActivity.this,ViewPagerActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();
                }
            },3000);
        //实现淡入淡出的效果
       /*layout = (RelativeLayout) findViewById(R.id.splash_layout);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(3000);
        layout.startAnimation(alphaAnimation);*/
    }
}
