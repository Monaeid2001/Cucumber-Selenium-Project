package com.qacart.todo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configUtil {
    public static Properties readConfig(String path) throws IOException {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInputStream);
        fileInputStream.close();
        return prop;
    }
}
