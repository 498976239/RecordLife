package com.recordlife.www.recordlife.MyAdapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by SS on 17-1-8.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<View> viewList;

    public ViewPagerAdapter(Context mContext, List<View> viewList) {
        this.mContext = mContext;
        this.viewList = viewList;
    }

    @Override
    public int getCount() {
        if(viewList!=null){
            return viewList.size();
        }
        return 0;
    }

    /**判断是否有对象生成
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;//固定写法
    }

    /**初始化位置
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager)container).addView(viewList.get(position),0);
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView(viewList.get(position));
    }
}
