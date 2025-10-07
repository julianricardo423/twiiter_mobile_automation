package com.mobile.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class DriverFactory {

    //Capabilities del driver para android o ios, configuración realizada en el archivo config.rpoperties
    private static String platform;
    private static String deviceName;
    private static String automationName;
    private static String appPackage;
    private static String appActivity;

    //Driver para poder navegar en el app móvil
    private static AppiumDriver driver;

    public static AppiumDriver getDriver(){
        Properties propiedades = new Properties();
        String appiumServerUrl = "http://127.0.0.1:4723";
        Path configPath = Paths.get("config", "config.properties");
        if(driver == null){
            try(FileInputStream fis = new FileInputStream("D:\\Entrevista RappiPay\\LoginMobile\\src\\config\\config.properties")){
                propiedades.load(fis);
                platform = propiedades.getProperty("platformName");
                deviceName = propiedades.getProperty("deviceName");
                automationName = propiedades.getProperty("automationName");
                appPackage = propiedades.getProperty("appPackage");
                appActivity = propiedades.getProperty("appActivity");

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", platform);
                capabilities.setCapability("appium:deviceName", deviceName);
                capabilities.setCapability("appium:automationName", automationName);
                capabilities.setCapability("appium:appPackage", appPackage);
                capabilities.setCapability("appium:appActivity", appActivity);
                capabilities.setCapability("appium:noReset", true);

                if(platform.equalsIgnoreCase("android")){
                    driver = new AndroidDriver(new URL(appiumServerUrl), capabilities);
                }
                else{
                    driver = new IOSDriver(new URL(appiumServerUrl), capabilities);
                }
            }catch(Exception e){
                //Cambiar por log
                e.printStackTrace();
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
