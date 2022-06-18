package com.mercurytour.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

    /**
     * ************************************************************************************************
     * @author sakhter
     * Class Name: Utility
     * Description: This class will capture the screenshot after the test execution
     * Date: 1/6/2022
     * ************************************************************************************************
     **/

    public class UtilityClass extends BrowserFactory {
        public static void captureScreenshot(WebDriver driver, String screenshotName) {
            try {
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFile, new File("./Screenshots/" + screenshotName + getCurrentDateTime() + ".png"));
                System.out.println("Validate that the screenshot is taken");
            } catch (Exception e) {
                System.out.println("Unable to capture screenshot " + e.getMessage());
            }
        }

        public static String getCurrentDateTime() {
            DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
            Date currentDate = new Date();
            return customFormat.format(currentDate);
        }
/**
 *********************************************************************************************************
 >>>>>>>>>>>>>> End of the File <<<<<<<<<<<<<<<<<
 *********************************************************************************************************
 **/
    }
