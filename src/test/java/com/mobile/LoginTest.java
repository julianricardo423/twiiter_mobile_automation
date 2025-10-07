package com.mobile;

import com.mobile.Pages.HomePage;
import com.mobile.Pages.LoginPage;
import com.mobile.Pages.SettingsLogoutPage;
import com.mobile.drivers.DriverFactory;
import com.mobile.drivers.PlatformDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {
    private AppiumDriver driver;
    private PlatformDriver platform;
    private LoginPage loginPage;
    private HomePage homePage;
    private SettingsLogoutPage settingsPage;

    @BeforeTest
    public void setUp() {
        driver = DriverFactory.getDriver();//Inicializamos el driver
        platform = new PlatformDriver(driver);//Configuramos el platform
        loginPage = new LoginPage(platform, driver);//Inicializamos el page
        homePage = new HomePage(platform, driver);//Inicializamos setting para el log out
        settingsPage = new SettingsLogoutPage(platform, driver);
    }

    @Test
    public void testLogin() throws InterruptedException {
        /**************************Proceso de login page****************************/
        loginPage.login("julianricardo4232@gmail.com", "ContraseñaDePrueba123_456_789");

        /**************************Proceso de home page****************************/
        Assert.assertEquals(homePage.messageHomePage(), "For you");
        homePage.clickOnButtonConfig(driver);

        /**************************Proceso de LogOut****************************/
        settingsPage.logout(driver);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
