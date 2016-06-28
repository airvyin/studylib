package com.download.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Book {

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
    private String status = null;
    
    /**
     * 封面
     */
    private String cover = null;
    
    /**
     * 类型
     */
    private String type = null;
    
    /**
     * 简介
     */
    private String introduction = null;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
