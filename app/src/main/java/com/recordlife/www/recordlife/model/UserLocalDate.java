package com.recordlife.www.recordlife.model;

import com.recordlife.www.recordlife.bean.RecordModelBean;
import com.recordlife.www.recordlife.bean.UserModelBean;

import org.xutils.ex.DbException;

import java.util.List;

/**
 * Created by SS on 17-1-9.
 */
//用来操作本地化数据
public class UserLocalDate implements UserLacalDateInterface{
    private static UserLocalDate mUserLocalDate;
    private UserModelDao mUserModelDao;
    private RecordModelDao mRecordModelDao;
    private UserLocalDate(){
        mUserModelDao = new UserModelDao();
        mRecordModelDao = new RecordModelDao();
    }
    public static UserLocalDate getInstance(){
        if(mUserLocalDate==null){
            synchronized(UserLocalDate.class){
                if(mUserLocalDate==null){
                    mUserLocalDate = new UserLocalDate();
                }
            }
        }
        return mUserLocalDate;
    }
    @Override
    public void addUserModelBean(UserModelBean mUserModelBean) {
        try {
            mUserModelDao.addUserModelBean(mUserModelBean);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserModelBean selectUserModelBean(String username) {
           UserModelBean userModelBean = null;
        try {
              userModelBean = mUserModelDao.selectUserModelBean(username);

        } catch (DbException e) {
            e.printStackTrace();
        }
        return userModelBean;
    }

    @Override
    public void addRecordModelBean(RecordModelBean recordModelBean) {
        try {
            mRecordModelDao.addRecordModelBean(recordModelBean);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RecordModelBean> selectRecordModelBean(String username) {
        List<RecordModelBean>  recordModelBeans = null;
        try {
             recordModelBeans = mRecordModelDao.selectRecordModelBean(username);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return recordModelBeans;
    }
}
