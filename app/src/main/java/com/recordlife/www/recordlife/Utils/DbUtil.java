package com.recordlife.www.recordlife.Utils;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by SS on 17-1-9.
 */
public class DbUtil {
    public  synchronized static DbManager getDbManager(){
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                .setDbName("SongSong_user")//定义数据库库名
                .setDbVersion(1);//数据库版本
        DbManager dbManager = x.getDb(daoConfig);
        return dbManager;

    }
}
