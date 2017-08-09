package com.recordlife.www.recordlife.model;

import com.recordlife.www.recordlife.Utils.DbUtil;
import com.recordlife.www.recordlife.bean.RecordModelBean;

import org.xutils.ex.DbException;

import java.util.List;

/**
 * Created by SS on 17-1-13.
 */
public class RecordModelDao {
    public void addRecordModelBean(RecordModelBean recordModelBean) throws DbException {
        DbUtil.getDbManager().save(recordModelBean);
    }
    public List< RecordModelBean> selectRecordModelBean(String username) throws DbException {
        List< RecordModelBean> recordModelBeans =
                DbUtil.getDbManager().selector(RecordModelBean.class).where("username", "=", username).orderBy("id",true).findAll();
        if(recordModelBeans!=null){
            return recordModelBeans;
        }
            return null;

    }
}
