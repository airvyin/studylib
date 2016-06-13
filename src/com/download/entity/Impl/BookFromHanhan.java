package com.download.entity.Impl;

import com.download.entity.Book;
import com.download.entity.Chapter;
import com.download.entity.Page;

public class BookFromHanhan extends Book {

    @Override
    public void addPage(String[] pageInfo) {
        Chapter chapter = getChapter(pageInfo[8]);
        Page page = new PageForHanhan(pageInfo);
        chapter.getPages().add(page);

    }

    public Chapter getChapter(String chapterName) {
        for (Chapter chapter : getChapters()) {
            if (chapterName.equals(chapter.getName())) {
                return chapter;
            }
        }
        Chapter chapter = new Chapter(chapterName);
        this.getChapters().add(chapter);
        return chapter;
    }
}
