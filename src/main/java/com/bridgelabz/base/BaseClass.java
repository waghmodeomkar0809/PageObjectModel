package com.bridgelabz.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver = null;
    Properties properties;

    public BaseClass() {
        properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/application.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void launchBrowser() {

        String browser = properties.getProperty("browser");

        if (browser.equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--disable-notifications");
            driver = new ChromeDriver(chromeOptions);

        } else if (browser.equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();

        } else {
            WebDriverManager.edgedriver().setup();

            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
    }
}
