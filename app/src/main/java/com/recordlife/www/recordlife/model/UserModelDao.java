package com.recordlife.www.recordlife.model;

import com.recordlife.www.recordlife.bean.UserModelBean;
import com.recordlife.www.recordlife.Utils.DbUtil;

import org.xutils.ex.DbException;

/**
 * Created by SS on 17-1-9.
 */
/*操作数据库,可以查询UserModelDao表里的数据*/
public class UserModelDao {
    //保存UserModelBean
    public void addUserModelBean(UserModelBean mUserModelBean) throws DbException {
        DbUtil.getDbManager().save(mUserModelBean);
    }
    public UserModelBean selectUserModelBean(String username) throws DbException {
        UserModelBean userModelBean = DbUtil.getDbManager().findById(UserModelBean.class, username);
        if(userModelBean!=null){
            return userModelBean;
        }
        return null;
    }

}
