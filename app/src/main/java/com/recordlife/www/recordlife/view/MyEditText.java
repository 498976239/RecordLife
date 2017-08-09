package com.recordlife.www.recordlife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;

import com.recordlife.www.recordlife.R;

/**
 * Created by SS on 17-1-9.
 */
public class MyEditText extends EditText {
    private Drawable mDrawable;
    private Context mContext;
    //画笔
    private Paint mPaint;
    private int color;
    private boolean hasFocus = false;//焦点



/*需要至少重写两个构造方法。第一个构造方法是代码里用的，第二个是布局文件里用的
* 这两个构造方是同步的，所以都要写 mContext = context;initView();*/
    public MyEditText(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView() {
        mDrawable = getResources().getDrawable(R.mipmap.btn_check_to_on_mtrl_008);
        //开始画图，new一个画笔
        mPaint  = new Paint();
        mPaint.setStrokeWidth(3.0f);//指定线条的宽度
        color = Color.parseColor("#bfbfbf");//定义了蓝色
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(color);//给画笔指定颜色
        //取到一个坐标
        int x = this.getScrollX();
        int w = this.getMeasuredWidth();//得到画线的宽度
        //开始画线
        /*drawLine()里的五个参数
        float startX起始横坐标0,
        float startY起始纵坐标,
        float stopX结束横坐标,
        float stopY结束纵坐标,
         Paint paint给一个画笔的实例*/
        canvas.drawLine(0,this.getHeight() - 1,w+x,this.getHeight() - 1,mPaint);
    }
//焦点的改变
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        this.hasFocus = focused;
        if(focused){
            setColor(Color.parseColor("#00C17C"));//当被选中就会变颜色
        }else{
            setColor(Color.parseColor("#bfbfbf"));//没有被选中就保持原色
        }
    }

    private void setColor(int i) {
        this.color = i;
        this.setTextColor(color);//选中的线变了，文字也要跟着变
        invalidate();//刷新一下
    }
    public void setImageVisible(boolean isVisible){
        if(isVisible){
            setCompoundDrawablesWithIntrinsicBounds(null,null,mDrawable,null);//这个方法很少用，让旁边的那个绿色小勾是否显示
        }else{
            setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        }
    }
//销毁的时候，重写一下它
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
