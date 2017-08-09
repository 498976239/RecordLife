package com.recordlife.www.recordlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.recordlife.www.recordlife.Utils.DbUtil;
import com.recordlife.www.recordlife.Utils.SharedPreferencesUtil;
import com.recordlife.www.recordlife.bean.RecordModelBean;
import com.recordlife.www.recordlife.model.Const;
import com.recordlife.www.recordlife.model.RecordModelDao;
import com.recordlife.www.recordlife.model.UserLocalDate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddInfomationActivity extends AppCompatActivity {
    private EditText title;
    private EditText content;
    private Button mButton;
    private  boolean isTitle;
    private boolean isContent;
    private RecordModelBean mRecordModelBean;
    private TextWatcher watcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(title.getText().toString().trim()!=null){
                isTitle = true;
            }else{
                isTitle = false;
            }
            if(content.getText().toString().trim()!=null){
                isContent = true;
            }else {
                isContent = false;
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_infomation);
        initView();
        initDate();
    }

    private void initDate() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordSubmit();
            }
        });
    }

    private void recordSubmit() {
        String title_record = title.getText().toString().trim();
        String content_record = content.getText().toString().trim();
        if(isContent&&isTitle){
            String name_tag = SharedPreferencesUtil.getInstance(this).readString(Const.LOGINUSERNAME,"");
            mRecordModelBean = new RecordModelBean();
            mRecordModelBean.setUsername(name_tag);
            mRecordModelBean.setmTitle(title_record);
            mRecordModelBean.setmContent(content_record);
            Date date = new Date();
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
            String t = s.format( date);
            mRecordModelBean.setmDate(t);
            UserLocalDate.getInstance().addRecordModelBean(mRecordModelBean);
            title.setText("");
            content.setText("");
            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
            Log.d("Add_Information",name_tag);
        }else {
            Toast.makeText(this,"名字和内容不能为空",Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        title = (EditText) findViewById(R.id.title_et);
        title.addTextChangedListener(watcher);
        content = (EditText) findViewById(R.id.content);
        content.addTextChangedListener(watcher);
        mButton = (Button) findViewById(R.id.record_btn);
    }
}
