package com.download.model.impl;

import com.download.entity.Book;
import com.download.entity.Chapter;
import com.download.entity.Page;
import com.download.model.Downloader;
import com.download.util.DownloadUtil;

public class Downloader4Hanhan implements Downloader {
    
    private DownloadUtil downloadUtil = new DownloadUtil();

    public void downloadBook(Book book) {
        for (Chapter chapter : book.getChapters()) {
            String savePath = book.getName().concat("/").concat(chapter.getName());
            for (Page page : chapter.getPages()) {
                downloadUtil.downloadImg(page.getUrl(), savePath, page.getPageName());
            }
        }
        System.out.println("È«²¿½áÊø");
    }

}
