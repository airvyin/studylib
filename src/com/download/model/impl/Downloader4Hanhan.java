package com.download.model.impl;

import java.io.File;
import java.sql.Date;

import com.download.entity.Book;
import com.download.entity.Chapter;
import com.download.entity.Page;
import com.download.model.Downloader;
import com.download.util.DownloadUtil;
import com.download.util.PropertyUtil;

public class Downloader4Hanhan implements Downloader {
    
    private DownloadUtil downloadUtil = new DownloadUtil();

    public void downloadBook(Book book) {
        Date startTime = new Date(System.currentTimeMillis());
        int downloadedPageCount = 0;
        for (Chapter chapter : book.getChapters()) {
            String savePath = PropertyUtil.getProperties("savePath").concat(File.separator).concat(book.getName())
                    .concat(File.separator).concat(chapter.getName());
            for (Page page : chapter.getPages()) {
                downloadUtil.downloadImg(page.getUrl(), savePath, page.getPageName());
                System.out.println("预计剩余时间：" + getLeftTime(book, downloadedPageCount, startTime) + "分");
                downloadedPageCount++;
            }
        }
        System.out.println("全部结束");
    }

    private long getLeftTime(Book book, int downloadedPageCount, Date startTime) {
        long usedTimelong = getUsedTime(startTime);
        long timePerPage = 0;
        if (downloadedPageCount != 0) {
            timePerPage = usedTimelong / downloadedPageCount;
        }
        return timePerPage * (book.getTotalPageCount() - downloadedPageCount) / 60000;
    }

    private long getUsedTime(Date startTime) {
        long userTimeLong = System.currentTimeMillis() - startTime.getTime();
        return userTimeLong;
    }

}
