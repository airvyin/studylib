package com.download.entity;

import java.util.Date;

public class Page {

    /**
     * pageId
     */
    private Long pageId = null;

    /**
     * chapterId
     */
    private Long chapterId = null;

    /**
     * filePath
     */
    private String filePath = null;
    
    /**
     * createDate
     */
    private Date createDate = null;
    
    /**
     * updateDate
     */
    private Date updateDate = null;
    
    /**
     * createUser
     */
    private String createUser = null;
    
    /**
     * updateUser
     */
    private String updateUser = null;
    
    /**
     * orderValue
     */
    private Integer orderValue = null;

    /**
     * url
     */
    private String url = null;

    /**
     * 页名
     */
    private String pageName = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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

    public Integer getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Integer orderValue) {
        this.orderValue = orderValue;
    }

}
