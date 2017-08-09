package com.recordlife.www.recordlife.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.recordlife.www.recordlife.R;

/**
 * Created by SS on 17-1-5.
 */
public class SharedPreferencesUtil {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private static SharedPreferencesUtil mSharedPreferencesUtil;//因为获取对象的方法时静态的，只能操作静态成员。
    private Context mContext;
    private SharedPreferencesUtil(Context mContext){
        this.mContext = mContext;
        //获取SharedPreferences时，有三种方法，这里使用的是context，填入的第一个参数是存储的文件名，其实可以自己随意定义
        //这里定义成了软件的名称，第二个参数是模式选择，表示只有当前的应用程序才可以对这个SharedPreferences文件进行读写
        mSharedPreferences = mContext.getSharedPreferences(mContext.getString(R.string.app_name),Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }
    public static SharedPreferencesUtil getInstance(Context c){
        //这里要特别注意，需要两次判定单例是否为空。可以防止多次判定锁的情况，详细请看笔记
        if(mSharedPreferencesUtil==null){
            synchronized (SharedPreferencesUtil.class){
                if(mSharedPreferencesUtil==null)
                    mSharedPreferencesUtil = new SharedPreferencesUtil(c.getApplicationContext());
            }
        }
        return mSharedPreferencesUtil;
    }
    public void writeBoolean(String key,boolean value){
        mEditor.putBoolean(key,value);
        mEditor.commit();
    }
    public boolean readBoolean(String key,boolean defValue){
        return mSharedPreferences.getBoolean(key,defValue);
    }
    public void writeString(String key,String value){
        mEditor.putString(key,value);
        mEditor.commit();
    }
    public String readString(String key,String value){
        return mSharedPreferences.getString(key,value);
    }
}
