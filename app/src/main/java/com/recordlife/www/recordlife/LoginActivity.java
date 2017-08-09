package com.recordlife.www.recordlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.recordlife.www.recordlife.Utils.SharedPreferencesUtil;
import com.recordlife.www.recordlife.base.BaseActivity;
import com.recordlife.www.recordlife.bean.UserModelBean;
import com.recordlife.www.recordlife.model.Const;
import com.recordlife.www.recordlife.model.UserLocalDate;
import com.recordlife.www.recordlife.view.MyEditText;

public class LoginActivity extends BaseActivity implements View.OnClickListener{
    private MyEditText mUserNameEditText;
    private MyEditText mPasswordEditText;
    private Button mLoginButton;
    private TextView mRegisterTextView;
    private boolean isName;
    private boolean isPassword;
    //^([\\S\\s]){2,16}，2-16位大小写都可以
    //编写一个EditText的观察者,用来动态监听
    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //用户名限制在2到16位
            if(mUserNameEditText.getText().toString().trim().matches("^([\\S\\s]){2,16}")){
                    mUserNameEditText.setImageVisible(true);//自己定义的方法
                    isName = true;
            }else{
                mUserNameEditText.setImageVisible(false);//自己定义的方法
                isName = false;
            }
            //密码限定在6-16位
            if(mPasswordEditText.getText().toString().trim().matches("^([\\S\\s]){6,16}")){
                mPasswordEditText.setImageVisible(true);//自己定义的方法
                isPassword = true;
            }else{
                mPasswordEditText.setImageVisible(false);//自己定义的方法
                isPassword = false;
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_login);
        mUserNameEditText = (MyEditText) findViewById(R.id.username_edittext);
        mPasswordEditText = (MyEditText) findViewById(R.id.password_edittext);
        mRegisterTextView = (TextView) findViewById(R.id.register_textview);
        mLoginButton = (Button) findViewById(R.id.login_btn);
        mLoginButton.setOnClickListener(this);
        mRegisterTextView.setOnClickListener(this);
        mUserNameEditText.addTextChangedListener(watcher);//写入时监听
        mPasswordEditText.addTextChangedListener(watcher);

    }

    /**
     * 提交信息
     */
    private void submit() {
        String username = mUserNameEditText.getText().toString().trim();//trim()是去空格的方法
        String password = mPasswordEditText.getText().toString().trim();
        if(isName&&isPassword){
            UserModelBean userModelBean = UserLocalDate.getInstance().selectUserModelBean(username);
            if(userModelBean==null){
                Toast.makeText(this,"账户不存在",Toast.LENGTH_SHORT).show();
                mPasswordEditText.setText("");
                mUserNameEditText.setText("");

            }
            if(userModelBean!=null){
                if((username.equals(userModelBean.getUsername()))&&(password.equals(userModelBean.getPassword()))){
                    SharedPreferencesUtil.getInstance(this).writeString(Const.LOGINUSERNAME,username);
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    finish();
                }else {
                    Toast.makeText(this,"密码错误",Toast.LENGTH_SHORT).show();

                }
            }

        }else {
            Toast.makeText(this,"账户密码格式不对",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.login_btn:
                submit();
            break;
            case R.id.register_textview:
                startActivity(new Intent(LoginActivity.this,Registactivity.class));
                break;
            default:
            break;
        }
    }
}
