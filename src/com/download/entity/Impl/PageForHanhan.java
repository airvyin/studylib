package com.download.entity.Impl;

import com.download.entity.Page;

public class PageForHanhan extends Page {
    
    private String[] pageInfo = null;

    public PageForHanhan(String[] pageInfo) {
        super();
        this.pageInfo = pageInfo;
        setPageName(pageInfo[pageInfo.length - 1]);
        createUrl(pageInfo);
    }
    
    private void createUrl(String[] pageInfo) {
        if (pageInfo == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : pageInfo) {
            sb.append(str);
            sb.append("/");
        }
        setUrl(sb.substring(0, sb.length() - 1));
    }

    public String[] getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(String[] pageInfo) {
        this.pageInfo = pageInfo;
    }
}
