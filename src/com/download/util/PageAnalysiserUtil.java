package com.download.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

public class PageAnalysiserUtil {
    
    /**
     * 下载网页文件
     * 
     * @param url 图片的url
     * @param savePath 保存图片的路径
     */
    public void getPage(String urlString) {
        try {
            // 构造URL
            URL url = new URL(urlString);
            // 打开链接
            URLConnection urlConn = url.openConnection();
            // 设置请求超时时间
            urlConn.setConnectTimeout(10 * 1000);
            // 输入流
            InputStream in = urlConn.getInputStream();
            // 1k数据缓冲
            byte[] bytes = new byte[1024];
            // 读取的数据长度
            int length = 0;
            // 输出文件
            File file = new File("");
            if (!file.exists())
                file.mkdirs();
            // 输出流
            OutputStream out = new FileOutputStream("tempPage.html");
            
            // 开始读取
            System.out.println("正在获取当前页面:" + url);
            while ((length = in.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
            System.out.println("页面获取结束");
            // 完毕，关闭所有链接
            in.close();
            out.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main (String[] args) {
        new PageAnalysiserUtil().getPage("http://www.hhxiee.cc/comic/188371/");
    }

    /**
     * 获取网页html内容
     * 
     * @param urlString 网页链接
     * @return html内容字符串
     */
    public String getHtmlString(String urlString) {
        
        try {
            URL url = new URL(urlString);
            URLConnection ucon = url.openConnection();
            InputStream instr = ucon.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(instr);
            ByteArrayBuffer baf = new ByteArrayBuffer(500);
            int current = 0;
            while ((current = bis.read()) != -1) {
                baf.append((byte) current);
            }
            return EncodingUtils.getString(baf.toByteArray(), "gbk");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
