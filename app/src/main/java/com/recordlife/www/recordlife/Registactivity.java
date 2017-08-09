package com.recordlife.www.recordlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.recordlife.www.recordlife.Utils.SharedPreferencesUtil;
import com.recordlife.www.recordlife.base.BaseActivity;
import com.recordlife.www.recordlife.bean.UserModelBean;
import com.recordlife.www.recordlife.model.Const;
import com.recordlife.www.recordlife.model.UserLocalDate;
import com.recordlife.www.recordlife.view.MyEditText;

public class Registactivity extends BaseActivity {
    private MyEditText mRigest_username;
    private MyEditText mRigest_password;
    private Button mRigest_sure;
    private Button mRigest_back;
    private boolean isRegistName;
    private boolean isRegistPsaaword;
    @Override
    protected void initDate() {

    }
    private TextWatcher watchers = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }
//监听注册时所输入的内容
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(mRigest_username.getText().toString().trim().matches("^([\\S\\s]){2,16}")){
                mRigest_username.setImageVisible(true);
                isRegistName = true;
            }else {
                mRigest_username.setImageVisible(false);
                isRegistName = false;
            }
            if(mRigest_password.getText().toString().trim().matches("^([\\S\\s]){6,16}")){
                mRigest_password.setImageVisible(true);
                isRegistPsaaword = true;
            }else{
                mRigest_password.setImageVisible(false);
                isRegistPsaaword = false;
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    @Override
    protected void initView() {
        setContentView(R.layout.activity_register);
        mRigest_username = (MyEditText) findViewById(R.id.register_username_et);
        mRigest_password = (MyEditText) findViewById(R.id.register_password_et);
        mRigest_sure = (Button) findViewById(R.id.register_sure_btn);
        mRigest_back = (Button) findViewById(R.id.register_back_btn);
        mRigest_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerInfo();
            }
        });
        mRigest_username.addTextChangedListener(watchers);
        mRigest_password.addTextChangedListener(watchers);
        mRigest_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registactivity.this,LoginActivity.class));
            }
        });
    }

    private void registerInfo() {
        String registername = mRigest_username.getText().toString().trim();
        String registerpassword = mRigest_password.getText().toString().trim();
        if(isRegistName&&isRegistPsaaword){
            UserModelBean user = new UserModelBean();
            user.setUsername(registername);
            user.setPassword(registerpassword);
            UserLocalDate.getInstance().addUserModelBean(user);
            SharedPreferencesUtil.getInstance(this).writeString(Const.LOGINUSERNAME,registername);
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Registactivity.this,MainActivity.class));
            finish();
        }else {
            Toast.makeText(this,"注册失败",Toast.LENGTH_SHORT).show();
        }
    }


}
