package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {}
    private static WebDriver driver;

    public static WebDriver getDriver(){
          if (driver == null) {

            String browserType = ConfigurationReader.getProperty("browser");
            
            String localPath = System.getProperty("user.dir") + File.separator + "downloadFiles";
    		Map<String, Object> preferences = new Hashtable<String, Object>();
    		preferences.put("download.default_directory", localPath);

    		ChromeOptions options = new ChromeOptions();
    		options.setExperimentalOption("prefs", preferences);
    		
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
