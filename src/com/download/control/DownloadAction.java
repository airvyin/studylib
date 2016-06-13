package com.download.control;

import java.util.List;

import com.download.entity.Book;
import com.download.model.BookMaker;
import com.download.model.Downloader;
import com.download.model.UrlMaker;
import com.download.model.impl.BookMaker4Hanhan;
import com.download.model.impl.Downloader4Hanhan;
import com.download.model.impl.UrlMaker4Hanhan;

public class DownloadAction {
    
    private UrlMaker urlMaker = null;
    
    private BookMaker bookMaker = null;
    
    private Downloader downloader = null;
    
    public void doDownload(String enUrl) {
        // 取得urlList
        List<String> urlList = urlMaker.getUrlList(enUrl);
        
        // 编辑保存路径和文件名
        Book book = bookMaker.getBook(urlList);
        
        // 下载
        downloader.downloadBook(book);
    }

    public UrlMaker getUrlMaker() {
        return urlMaker;
    }

    public void setUrlMaker(UrlMaker urlMaker) {
        this.urlMaker = urlMaker;
    }

    public BookMaker getBookMaker() {
        return bookMaker;
    }

    public void setBookMaker(BookMaker bookMaker) {
        this.bookMaker = bookMaker;
    }

    public Downloader getDownloader() {
        return downloader;
    }

    public void setDownloader(Downloader downloader) {
        this.downloader = downloader;
    }
    
    
    public static void main(String[] args) {
        DownloadAction testAction = new DownloadAction();
        testAction.setUrlMaker(new UrlMaker4Hanhan());
        testAction.setBookMaker(new BookMaker4Hanhan());
        testAction.setDownloader(new Downloader4Hanhan());
        
        testAction.doDownload(args[0]);
    }
}
