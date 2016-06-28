package com.download.model.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.download.model.UrlMaker;

public class UrlMaker4Hanhan implements UrlMaker {
    
    /**
     * 解密用key
     */
    private String key = "tahfcioewrm";
    
    private String[] serverList = new String[16];

    public UrlMaker4Hanhan() {
        this.init();
    }
    
    /**
     * 取得图片链接List
     * @param url 网页链接
     * @return 图片链接List
     */
    public List<String> getUrlList(String url) {
        List<String> firstUrlList = this.getFirstUrl(url);
        return this.getUrlList(firstUrlList);
    }
    
    /**
     * 汗汗漫画javascript解密方法
     * 
     * @param enUrl 加密串
     * @param key 解密用key
     * @param serverUrl 服务器地址
     * @return
     */
    private List<String> unsuan(String enUrl, String key, String serverUrl) {
        ArrayList<String> urlList = new ArrayList<String>();
        StringBuilder deUrl = new StringBuilder();
        String k1 = key.substring(0, key.length() - 1);
        String splitChar = key.substring(key.length() - 1);
        for (int i = 0; i < k1.length(); i++) {
            enUrl = enUrl.replaceAll(k1.substring(i, i + 1), String.valueOf(i));
        }
        String[] charCodes = enUrl.split(splitChar);
        for (String charCode : charCodes) {
            deUrl.append(Character.toChars(Integer.parseInt(charCode)));
        }
        String[] urls = deUrl.toString().split("\\|");
        for (String url : urls) {
            urlList.add(serverUrl + url);
        }
        return urlList;
    }
    
    private List<String> getFirstUrl(String url) {
        List<String> firstUrlList = new ArrayList<String>();
        String[] firstUrlStrs = url.split("/");
        try {
            Document doc = Jsoup.parse(new URL(url), 5000);
            Elements elements = doc.getElementsByAttributeValue("target", "_blank");
            if (elements == null || elements.isEmpty()) {
                firstUrlList.add(url);
            } else {
                for (Element element : elements) {
                    firstUrlList.add("http://".concat(firstUrlStrs[2]).concat(element.attr("href")));
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstUrlList;
    }
    
    private List<String> getUrlList(List<String> firstUrlList) {
        List<String> urlList = new ArrayList<String>();
        for (String firstUrl : firstUrlList) {
            try {
                Document doc = Jsoup.parse(new URL(firstUrl), 5000);
                Elements elements = doc.getElementsByAttributeValue("language", "javascript");
                String[] enUrls = elements.get(0).data().split("\"");
                urlList.addAll(this.unsuan(enUrls[enUrls.length - 2], key, serverList[Integer.parseInt(firstUrl.substring(firstUrl.indexOf("=") + 1)) - 1]));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return urlList;
    }

    // 汗汗漫画服务器列表
    private void init() {
        serverList[0] = "http://216.18.193.163:9393/dm01/";
        serverList[1] = "http://216.18.193.163:9393/dm02/";
        serverList[2] = "http://216.18.193.163:9393/dm03/";
        serverList[3] = "http://216.18.193.163:9393/dm04/";
        serverList[4] = "http://216.18.193.163:9393/dm05/";
        serverList[5] = "http://216.18.193.163:9393/dm06/";
        serverList[6] = "http://216.18.193.163:9393/dm07/";
        serverList[7] = "http://216.18.193.163:9393/dm08/";
        serverList[8] = "http://216.18.193.163:9393/dm09/";
        serverList[9] = "http://216.18.193.163:9393/dm10/";
        serverList[10] = "http://216.18.193.163:9393/dm11/";
        serverList[11] = "http://216.18.193.163:9393/dm12/";
        serverList[12] = "http://216.18.193.163:9393/dm13/";
        serverList[13] = "http://8.8.8.8:99/dm14/";
        serverList[14] = "http://216.18.193.163:9393/dm15/";
        serverList[15] = "http://216.18.193.163:9393/dm16/";
    }
}
