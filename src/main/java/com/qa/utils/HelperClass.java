

package com.qa.utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 
public class HelperClass {
 
    private static HelperClass helperClass;
 
    private static WebDriver driver;
    public final static int TIMEOUT = 5;
 
    private HelperClass() {
 
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    }
 
    public static void openPage(String url) {
        driver.get(url);
    }
 
    public static WebDriver getDriver() {
        return driver;
    }
 
    public static void setUpDriver() {
 
        if (helperClass==null) {
            helperClass = new HelperClass();
        }
    }
 
    public static void tearDown() {
 
        if(driver!=null) {
            driver.quit();
        }
 
        helperClass = null;
    }
 
}