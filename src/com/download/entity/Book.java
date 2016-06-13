package com.download.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Book {

    private String name = null;

    private List<Chapter> chapters = new ArrayList<Chapter>();

    public Book() {

    }
    
    abstract public void addPage(String[] pageInfo);

    public Book(String name) {
        this.name = name;
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

}
