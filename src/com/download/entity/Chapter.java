package com.download.entity;

import java.util.ArrayList;
import java.util.List;

public class Chapter {

    private String name = null;
    
    private List<Page> pages = new ArrayList<Page>();
    
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
}
