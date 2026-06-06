package com.qacart.todo.utils;

import java.io.IOException;
import java.util.Properties;

public class EnvUtil {
    public static EnvUtil envUtil;
    private Properties prop;

    private EnvUtil() throws IOException {
       String env= System.getProperty("env", "production");
       switch (env.toLowerCase()){
           case "production":
               prop = configUtil.readConfig("src/test/resources/properties/production.properties");
                break;
           case "staging":
                prop = configUtil.readConfig("src/test/resources/properties/staging.properties");
                break;
           case "local":
                prop = configUtil.readConfig("src/test/resources/properties/local.properties");
                break;
           default:
               throw new RuntimeException("Environment not supported: " + env);
       }
    }

    public static EnvUtil getInstance() throws IOException {
        if (envUtil == null) {
            envUtil = new EnvUtil();
        }
        return envUtil;
    }
    public String getBaseUrl(){
        return prop.get("URL").toString();
    }
    public String getUserEmail(){
        return prop.get("EMAIL").toString();
    }
    public String getUserPassword(){
        return prop.get("PASSWORD").toString();
    }
}

