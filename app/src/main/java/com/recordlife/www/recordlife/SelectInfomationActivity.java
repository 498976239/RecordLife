package com.recordlife.www.recordlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.recordlife.www.recordlife.MyAdapter.MyRecyclerViewAdapter;
import com.recordlife.www.recordlife.Utils.DbUtil;
import com.recordlife.www.recordlife.Utils.SharedPreferencesUtil;
import com.recordlife.www.recordlife.bean.RecordModelBean;
import com.recordlife.www.recordlife.model.Const;
import com.recordlife.www.recordlife.model.UserLocalDate;

import java.util.ArrayList;
import java.util.List;

public class SelectInfomationActivity extends AppCompatActivity {
  /*  private EditText seletusername;
    private TextView mResult;
    private Button result_btn;
    private List<RecordModelBean> list;*/
    private RecyclerView mTable;
    private List<RecordModelBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
       // initView();
        //initDate();
        list = new ArrayList<>();
        String s = SharedPreferencesUtil.getInstance(this).readString(Const.LOGINUSERNAME,null);
        list = UserLocalDate.getInstance().selectRecordModelBean(s);
        mTable = (RecyclerView) findViewById(R.id.recycler_view);
        mTable.setAdapter(new MyRecyclerViewAdapter(list,this));
        mTable.setLayoutManager(new LinearLayoutManager(this));
    }

   /* private void initDate() {
        result_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectDate();
            }
        });
    }

    private void selectDate() {
        String result_name = seletusername.getText().toString().trim();
         list = new ArrayList<>();
        if(result_name!=null){
            list = UserLocalDate.getInstance().selectRecordModelBean(result_name);
            if(list!=null){
                for(RecordModelBean recordModelBean : list){
                    if(result_name.equals(recordModelBean.getUsername())){
                        String time = recordModelBean.getmDate();
                        String result_title = recordModelBean.getmTitle();
                        String result_content = recordModelBean.getmContent();
                        mResult.setText(time+"\n"+result_title+"\n"+result_content);
                    }
                }

            }else{
                Toast.makeText(this,"没有相关人员记录",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"关键词为空",Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        seletusername = (EditText) findViewById(R.id.select_name);
        mResult = (TextView) findViewById(R.id.result_tv);
        result_btn = (Button) findViewById(R.id.result_btn);
    }*/
}
