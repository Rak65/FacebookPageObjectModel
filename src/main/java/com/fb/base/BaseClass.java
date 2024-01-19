package com.fb.base;

import com.fb.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
  public static WebDriver webDriver;
  public static Properties properties;
    public BaseClass(){
        try {
            properties=new Properties();
           FileInputStream fileInputStream=new FileInputStream("H:\\CFP251\\FacebookPageObjectModel\\src\\main\\java\\com\\fb\\configurations\\configuration.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void initialization() {
        String browserName = properties.getProperty("browser");
        if (browserName.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            webDriver = new ChromeDriver(chromeOptions);
        } else if (browserName.equals("firefox")) {
            webDriver = new FirefoxDriver();
        }
        webDriver.get(properties.getProperty("url"));
        webDriver.manage().window().maximize();

        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);

    }
}
