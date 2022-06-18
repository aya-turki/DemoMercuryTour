package com.mercurytour.utility;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    WebDriver driver;
    Properties prop;

    public WebDriver init_driver(Properties prop) {
        String browserName= prop.getProperty("browser").trim();
        System.out.println("Browser name is  " + browserName);

        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else
            System.out.println("Please enter a valid driver");

        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
        driver.get(prop.getProperty("URL"));

        return driver;
    }
    public String getScreenshot() {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs((OutputType.FILE));
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(srcFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

        public static String getCurrentDateTime() {
            DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
            Date currentDate = new Date();
            return customFormat.format(currentDate);
        }

    public static void closeBrowser(WebDriver driver) {
        driver.quit();

    }
    }

