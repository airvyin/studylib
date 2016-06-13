package com.download.model.impl;

import java.util.List;

import com.download.entity.Book;
import com.download.entity.Impl.BookFromHanhan;
import com.download.model.BookMaker;

public class BookMaker4Hanhan implements BookMaker {

    /**
     * ½âÎöurlÉú³Ébook
     */
    public Book getBook(List<String> urlList) {
        if (urlList == null || urlList.isEmpty()) {
            return null;
        }
        Book book = new BookFromHanhan();
        String[] singlePageInfo = urlList.get(0).split("/");
        book.setName(singlePageInfo[7]);
        
        for (String url : urlList) {
            singlePageInfo = url.split("/");
            book.addPage(singlePageInfo);
        }
        
        return book;
    }

    public static void main(String[] args) {
        String[] tmp = "http://216.18.193.163:9393/dm06//ok-comic06/T/TianERongZhiWen/vol_001/99770_0001_13630.JPG".split("/");
        for (String str : tmp) {
            System.out.println(str);
        }
    }
}
