package com.recordlife.www.recordlife.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by SS on 17-1-9.
 */
/*通过注解来查询数据库。建表，将名字和类名写成一致，稍后给个类名就可以直接查询，因为反射原理
* 注解是要依赖反射的技巧
* 这里的bean类就是为了方便建表*/
@Table(name ="UserModelBean" )
public class UserModelBean {
    /*注解成,字段 autoGen是自增的意思,设置了之后id自增而且唯一*/
    @Column(name = "id",autoGen = true)
    private int id;
    /*这个项目查询依赖的是用户名做验证,这里的isId设置成true意思是没有重复的，此后username就是id*/
    @Column(name = "username",isId = true,autoGen = false)
    private String username;
    @Column(name = "password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
