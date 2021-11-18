package com.amzn.qa.base;

import com.amzn.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/home/yokesh/IdeaProjects/Selenium-bootcamp-ex/src/main/java/com/amzn/qa/config/config.properties");
            prop.load(ip);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",
                    "/home/yokesh/IdeaProjects/Selenium-bootcamp-ex/Driver/chromedriver");
            driver = new ChromeDriver();
        }
        else
        {
            System.setProperty("webdriver.gecko.driver",
                    ".\\Drivers\\geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

        driver.get(prop.getProperty("url"));
    }
}
