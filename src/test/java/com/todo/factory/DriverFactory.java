package com.qacart.todo.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
  private static ThreadLocal<WebDriver>  driver = new ThreadLocal<>();

    public  static WebDriver initDriver(){
       //driver = new EdgeDriver();
        WebDriver driver;
        String browser = System.getProperty("browser","edge");
        switch (browser.toLowerCase()){
            case "edge":
                driver = new EdgeDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
             case "firefox":
                 driver = new FirefoxDriver();
                    break;
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            DriverFactory.driver.set(driver);
        return driver;
    }
    public static WebDriver getDriver(){
        return driver.get();
    }
}
