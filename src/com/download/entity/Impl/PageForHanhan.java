package com.download.entity.Impl;

import com.download.entity.Page;

public class PageForHanhan extends Page {
    
    private String[] pageInfo = null;

    public PageForHanhan(String[] pageInfo) {
        super();
        this.pageInfo = pageInfo;
        setPageName(pageInfo[9]);
    }
    
    public String getUrl() {
        if (pageInfo == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : pageInfo) {
            sb.append(str);
            sb.append("/");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
