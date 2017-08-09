package com.recordlife.www.recordlife.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by SS on 17-1-13.
 */
@Table(name = "RecordModelBean")
public class RecordModelBean {
    @Column(name = "id",isId = true,autoGen = true)
    private int id;
    @Column(name = "mTitle")
    private String mTitle;
    @Column(name = "mContent")
    private String mContent;
    @Column(name = "mDate")
    private String mDate;
    @Column(name = "username")
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
