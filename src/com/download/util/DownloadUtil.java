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
     * ����ͼƬ
     * 
     * @param url ͼƬ��url
     * @param savePath ����ͼƬ��·��
     */
    public void downloadImg(String urlString, String savePath, String fileName) {
        try {
            // ����URL
            URL url = new URL(urlString);
            // ������
            URLConnection urlConn = url.openConnection();
            // ��������ʱʱ��
            urlConn.setConnectTimeout(10 * 1000);
            // ������
            InputStream in = urlConn.getInputStream();
            // 1k���ݻ���
            byte[] bytes = new byte[1024];
            // ��ȡ�����ݳ���
            int length = 0;
            // ����ļ�
            File file = new File(savePath);
            if (!file.exists())
                file.mkdirs();
            if (checkFileExists(file.getPath() + File.separator + fileName)) {
                System.out.println(file.getPath() + File.separator + fileName);
                System.out.println("�ļ��Ѵ���");
                return;
            }
            // �����
            OutputStream out = new FileOutputStream(file.getPath() + File.separator + fileName);
            
            // ��ʼ��ȡ
            System.out.println("����ִ���������񣺵�ǰ��������ͼƬ:" + url);
            while ((length = in.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
            System.out.println("��ǰͼƬ����");
            // ��ϣ��ر���������
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
