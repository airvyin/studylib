package com.download.model.impl;

import java.util.List;

import com.download.entity.Book;
import com.download.entity.Impl.BookFromHanhan;
import com.download.model.BookMaker;
import com.download.util.Contents;

public class BookMaker4Hanhan implements BookMaker {

    /**
     * 根据url生成book
     */
    public Book getBook(List<String> urlList) {
        if (urlList == null || urlList.isEmpty()) {
            return null;
        }
        Book book = new BookFromHanhan();
        String[] singlePageInfo = urlList.get(0).split(Contents.URL_SEPARATOR);
        book.setName(singlePageInfo[7]);
        
        for (String url : urlList) {
            singlePageInfo = url.split(Contents.URL_SEPARATOR);
            book.addPage(singlePageInfo);
        }
        
        return book;
    }

}
