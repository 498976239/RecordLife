package com.recordlife.www.recordlife;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.recordlife.www.recordlife.MyAdapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private Button mButton;
    private ViewGroup mViewGroup;//这里定义成LinearLayout也可以，存放布局的容器，用来存放圆点
    //图片资源数组
    private int[] mImageIdArray;
    //图片集合
    private List<View> mViewList;
    //实例化圆点，需要new一个imageview来装
    private ImageView mImageView;
    //圆点对象数组
    private ImageView[] mImageViewArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mViewPager = (ViewPager) findViewById(R.id.first_pager);
        mViewGroup = (ViewGroup) findViewById(R.id.viewpager_group);
        mButton = (Button) findViewById(R.id.pager_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewPagerActivity.this,LoginActivity.class);
                startActivity(intent);
                ViewPagerActivity.this.finish();
            }
        });
        //加载Viewpager
        initViewPager();//初始化viewpager
        initViewPagerTag();//加载圆点标记，用来显示滚动到ViewPager哪一张图了
    }
    //加载圆点标记，用来显示滚动到ViewPager哪一张图了
    private void initViewPagerTag() {
        //根据viewpager里view的数量来实例化一个数组，存放圆点的个数
        mImageViewArray = new ImageView[mViewList.size()];
        for (int i = 0; i <mViewList.size() ; i++) {
            mImageView = new ImageView(this);
            mImageView.setLayoutParams(new ViewGroup.LayoutParams(40,40));//给一个尺寸
            mImageView.setPadding(30,0,30,0);
            mImageViewArray[i] = mImageView;
            //第一个的话默认选中状态
            if(i==0){
                mImageView.setBackgroundResource(R.mipmap.btn_radio_on_holo_dark);
            }else{
                mImageView.setBackgroundResource(R.mipmap.btn_radio_on_disabled_holo_dark);
            }
            mViewGroup.addView(mImageViewArray[i]);
        }
    }
 //初始化viewpager
    private void initViewPager() {
        //实例化图片资源
        mImageIdArray = new int[]{R.mipmap.earth,R.mipmap.gear,R.mipmap.qwe};
        //将图片变成一个layout放入容器，首先实例化一个放View的容器
        mViewList = new ArrayList<>();
        //获取layout参数,设置为match
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        //循环创建view，加入到集合中
        for (int i = 0; i <mImageIdArray.length ; i++) {
            //new一个ImageView，用params作为参数
           ImageView iv = new ImageView(this);
            //动态的将图片资源转成了view
            iv.setLayoutParams(params);
            //将数组资源图片放入到imageView中
            iv.setBackgroundResource(mImageIdArray[i]);
            //将创建出来的imageview加入到集合中
            mViewList.add(iv);
        }
        //为viewpager设置适配器
        mViewPager.setAdapter(new ViewPagerAdapter(this,mViewList));
        //滑动的监听事件
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //滚动完成时，执行的方法
            @Override
            public void onPageSelected(int position) {
                //当选中图片和i相等，则显示选中圆点
                for (int i = 0; i <mImageViewArray.length ; i++) {
                    mImageViewArray[position].setBackgroundResource(R.mipmap.btn_radio_on_holo_dark);
                    if(position!=i){
                        mImageViewArray[i].setBackgroundResource(R.mipmap.btn_radio_on_disabled_holo_dark);
                    }
                }
                //判断是不是最后一页
                if(position == mImageViewArray.length-1){
                    mButton.setVisibility(View.VISIBLE);
                }else{
                    mButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
