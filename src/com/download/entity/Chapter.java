package com.download.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Chapter {

    /**
     * id
     */
    private Long chapterId = null;
    
    /**
     * bookId
     */
    private Long bookId = null;
    
    /**
     * createUser
     */
    private String createUser = null;
    
    /**
     * updateUser
     */
    private String updateUser = null;
    
    /**
     * createDate
     */
    private Date createDate = null;
    
    /**
     * updateDate
     */
    private Date updateDate = null;
    
    /**
     * orderValue
     */
    private Integer orderValue = null;

    
    /**
     * 章节名
     */
    private String name = null;
    
    /**
     * 页集合
     */
    private List<Page> pages = new ArrayList<Page>();
    
    /**
     * 构造函数
     * 
     * @param chapterName 章节名
     */
    public Chapter(String chapterName) {
        this.name = chapterName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
    
    public int getPageCount() {
        return this.pages.size();
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Integer orderValue) {
        this.orderValue = orderValue;
    }
}
