package com.download.util;

import java.io.InputStream;

public class ClassLoaderUtils {

    private ClassLoaderUtils() {
        
    }
    
    public static InputStream getResourcesAsStream(String name) {
        if (name.startsWith("/"))
            name = name.substring(1);
        ClassLoader ccl = Thread.currentThread().getContextClassLoader();
        return ccl.getResourceAsStream(name);
    }
}
