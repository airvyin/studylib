package com.download.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadUtil {
    
    /**
     * 下载图片
     * 
     * @param url 图片的url
     * @param savePath 保存图片的路径
     */
    public void downloadImg(String urlString, String savePath, String fileName) {
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
            File file = new File(savePath);
            if (!file.exists())
                file.mkdirs();
            if (checkFileExists(file.getPath() + File.separator + fileName)) {
                System.out.println(file.getPath() + File.separator + fileName);
                System.out.println("文件已存在");
                return;
            }
            // 输出流
            OutputStream out = new FileOutputStream(file.getPath() + File.separator + fileName);
            
            // 开始读取
            System.out.println("正在执行下载任务：当前正在下载图片:" + url);
            while ((length = in.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
            System.out.println("当前图片结束");
            // 完毕，关闭所有链接
            in.close();
            out.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
    
    public static void main (String[] args) {
        new DownloadUtil().downloadImg("http://216.18.193.164:9393/dm06//ok-comic06/T/TianERongZhiWen/vol_001/99770_0002_16079.JPG", "aaa","aaaa.jpg");
//        new DownloadUtil().downloadImg("http://216.18.193.164:9393/dm06//ok-comic06/T/TianERongZhiWen/vol_001/99770_0002_16079.JPG","aaaa.jpg");
    }

    
    public void downloadImg(String url, String path) {
        try {
            BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
            
            File file = new File(path);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            System.out.println("正在执行下载任务：当前正在下载图片:" + url);
            byte[] data = new byte[1024];
            int length = 0;
            while((length=in.read(data)) != -1) {
                out.write(data, 0, length);
            }
            System.out.println("结束");
            in.close();
            out.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
