package com.recordlife.www.recordlife.base;

import android.app.Application;

import org.xutils.x;

/**
 * Created by SS on 17-1-9.
 */
public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
