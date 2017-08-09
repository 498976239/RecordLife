package com.recordlife.www.recordlife.model;

import com.recordlife.www.recordlife.bean.RecordModelBean;
import com.recordlife.www.recordlife.bean.UserModelBean;

import java.util.List;

/**
 * Created by SS on 17-1-9.
 */
public interface UserLacalDateInterface {
    void addUserModelBean(UserModelBean mUserModelBean);
    UserModelBean selectUserModelBean(String username);
    void addRecordModelBean(RecordModelBean recordModelBean);
    List<RecordModelBean> selectRecordModelBean(String username);

}
