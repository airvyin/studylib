package com.download.entity;

import java.util.ArrayList;
import java.util.List;

public class Chapter {

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
}
