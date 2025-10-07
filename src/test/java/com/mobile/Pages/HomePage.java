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

public class HomePage {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    private PlatformDriver platform;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']")//Don’t allow
    @iOSXCUITFindBy(accessibility = "btn_dont_allow")
    private WebElement btn_dont_allow;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='For you']")
    @iOSXCUITFindBy(accessibility = "for_you_layout_text")
    private WebElement for_you_layout_text;

    @AndroidFindBy(accessibility = "Show navigation drawer")
    @iOSXCUITFindBy(accessibility = "btn_config")
    private WebElement btn_config;

    public HomePage(PlatformDriver platform, AppiumDriver driver) {
        this.platform = platform;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String messageHomePage(){
        logger.debug("Identificado boton para rechazar las notificaciones");
        platform.onClickButton(btn_dont_allow, 20);

        logger.debug("Identificado el compenente de seccion para validar que actualmente el page es home");
        String text = platform.homePageMessage(for_you_layout_text);
        return text;
    }

    public void clickOnButtonConfig(AppiumDriver driver){
        logger.debug("Identificado boton de configuracion");
        platform.onClickButton(btn_config, 3);
    }



}
