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
    
    public static String FILE_EXIST = "文件已存在";
    
    /**
     * 下载图片
     * 
     * @param url 图片的url
     * @param savePath 保存图片的路径
     */
    public void downloadImg(String urlString, String savePath, String fileName) {
        File pageFile = new File(savePath + File.separator + fileName);
        if (pageFile.exists()) {
            System.out.println(FILE_EXIST + pageFile.getPath());
            return;
        }
        InputStream in = null;
        OutputStream out = null;
        try {
            // 构造URL
            URL url = new URL(urlString);
            // 打开链接
            URLConnection urlConn = url.openConnection();
            // 设置请求超时时间
            urlConn.setConnectTimeout(10 * 1000);
            // 输入流
            in = urlConn.getInputStream();
            // 1k数据缓冲
            byte[] bytes = new byte[1024];
            // 读取的数据长度
            int length = 0;
            // 文件夹
            File fileDir = new File(savePath);
            if (!fileDir.exists())
                fileDir.mkdirs();
            // 输出流
            out = new FileOutputStream(pageFile);
            
            // 开始读取
            System.out.println("正在执行下载任务：当前正在下载图片:" + url);
            while ((length = in.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
            System.out.println("当前图片结束");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                in = null;
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                out = null;
            }
        }
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
            System.out.println("����ִ���������񣺵�ǰ��������ͼƬ:" + url);
            byte[] data = new byte[1024];
            int length = 0;
            while((length=in.read(data)) != -1) {
                out.write(data, 0, length);
            }
            System.out.println("����");
            in.close();
            out.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
