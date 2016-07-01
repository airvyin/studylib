package com.download.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtil {

    public static List<String> readFile(String filePath) {
        List<String> urlList = new ArrayList<String>();
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            InputStreamReader reader = null;
            try {
                reader = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(reader);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    System.out.println(lineTxt);
                    if (lineTxt.startsWith("http")) {
                        urlList.add(lineTxt);
                    }
                }
            } catch (UnsupportedEncodingException | FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    reader = null;
                }
            }
            
        }
        return urlList;
    }
}
