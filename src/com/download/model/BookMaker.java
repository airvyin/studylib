package com.download.model;

import java.util.List;

import com.download.entity.Book;

public interface BookMaker {

    public Book getBook(List<String> urlList);
}
