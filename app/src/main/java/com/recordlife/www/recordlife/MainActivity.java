package com.recordlife.www.recordlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final int ADDINFO = 0;
    private static final int SELECTINFO = 1;
    private GridView mGridView;
    private int[] images;
    private String[] content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGridView = (GridView) findViewById(R.id.grid_view);
        initDate();
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case ADDINFO:
                            startActivity(new Intent(MainActivity.this,AddInfomationActivity.class));
                    break;
                    case SELECTINFO:
                            startActivity(new Intent(MainActivity.this,SelectInfomationActivity.class));
                    break;
                    default:
                    break;
                }
            }
        });
    }

    /**
     *
     */
    private void initDate() {
        images = new int[]{R.mipmap.select,R.mipmap.calling,R.mipmap.rest,R.mipmap.setting,R.mipmap.updating};
        content = new String[]{"选择","聊天","休闲","设置","更新"};
        //准备需要的资源，根据SimpleAdapter提供的参数要求
        List<Map<String,Object>> maplist = new ArrayList<>();
        for (int i = 0; i <content.length ; i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("image_item",images[i]);//添加图片资源（但是不知道这里key为什么可以重复）
            map.put("content_item",content[i]);//添加文本资源
            maplist.add(map);
        }
        //实例一个simpleAdapter,第一个参数为上下文，第二个参数为加载的资源，第三个参数是布局资源，第四个参数是资源
        //对应的字段，第五个参数是资源字段在布局文件中的id
        SimpleAdapter adapter = new SimpleAdapter(this,
                maplist,R.layout.item_gridview,
                new String[]{"image_item","content_item"},new int[]{R.id.grid_view,R.id.grid_text});
               mGridView.setAdapter(adapter);
    }
//按两次退出程序
    private long firstTime;
    @Override
    public void onBackPressed() {
        if(firstTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            System.exit(0);
        }else {
            Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();
        }
        firstTime = System.currentTimeMillis();
    }
}
