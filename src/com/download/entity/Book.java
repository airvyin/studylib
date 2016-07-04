package com.download.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Book {
    
    /**
     * id
     */
    private Long bookId = null;

    /**
     * 书名
     */
    private String name = null;
    
    /**
     * 作者名
     */
    private String authorName = null;
    
    /**
     * 连载状态：连载/完结
     */
    private Integer status = null;
    
    /**
     * 封面
     */
    private String cover = null;
    
    /**
     * 类型
     */
    private Integer type = null;
    
    /**
     * 简介
     */
    private String introduction = null;
    
    /**
     * path
     */
    private String path = null;
    
    /**
     * createDate
     */
    private Date createDate = null;
    
    /**
     * createUser
     */
    private String createUser = null;
    
    
    /**
     * updateDate
     */
    private Date updateDate = null;
    
    
    /**
     * updateUser
     */
    private String updateUser = null;

    /**
     * 章节List
     */
    private List<Chapter> chapters = new ArrayList<Chapter>();

    /**
     * 构造方法
     */
    public Book() {

    }
    
    /**
     * 构造方法
     */
    public Book(String name) {
        this.name = name;
    }
    
    /**
     * 添加页
     * 
     * @param pageInfo 页信息
     */
    abstract public void addPage(String[] pageInfo);
    
    /**
     * 取得总页数
     * 
     * @return 总页数
     */
    public int getTotalPageCount() {
        int totalPageCount = 0;
        for (Chapter chapter : this.chapters) {
            totalPageCount += chapter.getPageCount();
        }
        return totalPageCount;
    }
    
    /**
     * 根据章节名取得章节
     * 
     * @param chapterName 章节名
     * @return 章节
     */
    public Chapter getChapter(String chapterName) {
        for (Chapter chapter : getChapters()) {
            if (chapterName.equals(chapter.getName())) {
                return chapter;
            }
        }
        Chapter chapter = new Chapter(chapterName);
        this.getChapters().add(chapter);
        return chapter;
    }

    public String getName() {
        return name;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChapterCount() {
        return this.chapters.size();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
}
