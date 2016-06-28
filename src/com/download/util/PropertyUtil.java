package com.download.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    static Properties properties = null;
    
    static {
        if (properties == null) {
            properties = new Properties();
            String name = "global.properties";
            try {
                InputStream in = null;
                if (name.startsWith("/"))
                    name = name.substring(1);
                ClassLoader ccl = Thread.currentThread().getContextClassLoader();
                in = ccl.getResourceAsStream(name);
                properties.load(in);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static String getProperties(String key) {
        return properties.getProperty(key);
    }
    
    public static String getProperties(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
    public static void main(String[] args) {
        System.out.println(properties.getProperty("filepath"));
    }
}
