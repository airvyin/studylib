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
     * ������ҳ�ļ�
     * 
     * @param url ͼƬ��url
     * @param savePath ����ͼƬ��·��
     */
    public void getPage(String urlString) {
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
            File file = new File("");
            if (!file.exists())
                file.mkdirs();
            // �����
            OutputStream out = new FileOutputStream("tempPage.html");
            
            // ��ʼ��ȡ
            System.out.println("���ڻ�ȡ��ǰҳ��:" + url);
            while ((length = in.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
            System.out.println("ҳ���ȡ����");
            // ��ϣ��ر���������
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
     * ��ȡ��ҳhtml����
     * 
     * @param urlString ��ҳ����
     * @return html�����ַ���
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
