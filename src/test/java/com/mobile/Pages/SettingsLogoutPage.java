package com.mobile.Pages;

import com.mobile.drivers.PlatformDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class SettingsLogoutPage {

    private static final Logger logger = LoggerFactory.getLogger(SettingsLogoutPage.class);

    private PlatformDriver platform;

    /*@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings &amp; Support']")
    @iOSXCUITFindBy(accessibility = "settings_and_support_option")
    private WebElement settings_and_support_option;*/

    /*@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings and privacy']")
    @iOSXCUITFindBy(accessibility = "setting_and_privacy_option")
    private WebElement setting_and_privacy_option;*/

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your account']")
    @iOSXCUITFindBy(accessibility = "your_account_option")
    private WebElement your_account_option;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Account information']")
    @iOSXCUITFindBy(accessibility = "account_information_option")
    private WebElement account_information_option;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log out']")
    @iOSXCUITFindBy(accessibility = "logout_option")
    private WebElement logout_option;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Log out']")
    @iOSXCUITFindBy(accessibility = "logout_button")
    private WebElement logout_button;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Close sheet']")
    @iOSXCUITFindBy(accessibility = "google_password_manager_option")
    private WebElement google_password_manager_option;

    public SettingsLogoutPage(PlatformDriver platform, AppiumDriver driver) {
        this.platform = platform;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void logout(AppiumDriver driver) {
        logger.debug("Identificado boton para ingresar a soporte de configuracion");
        platform.onClickButtonLink(driver, 263, 1940, 3);

        logger.debug("Identificado boton para ingresar a la configuracion de privacidad");
        platform.onClickButtonLink(driver, 504, 1986, 3);

        logger.debug("Identificado boton para ingresar a opcion \'your account\'");
        platform.onClickButton(your_account_option, 3);

        logger.debug("Identificado boton para ingresar a opcion \'account information\'");
        platform.onClickButton(account_information_option, 3);

        logger.debug("Identificado boton para ingresar a opcion \'log out\'");
        platform.onClickButton(logout_option, 3);

        logger.debug("Identificado boton para dar clic en boton \'log out\'");
        platform.onClickButton(logout_button, 3);

        logger.debug("Identificando opción para alamcenar contrasenia");
        platform.onClickButtonLink(driver, 0, 0, 15);
    }
}
