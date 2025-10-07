package com.mobile.Pages;

import com.mobile.drivers.PlatformDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

    private static final Logger logger = LoggerFactory.getLogger(PlatformDriver.class);

    private PlatformDriver platform;
    private AppiumDriver driver;

    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    @iOSXCUITFindBy(accessibility = "btn_google_option")
    private WebElement btn_google_option;

    //Identificación por medio del pageFactory dependiendo del contexto del driver, busca el elemento ya sea por Android o IOS
    //contains(@resource-id,'com.twitter.android:id/sign_in_text') or
    /*@AndroidFindBy(xpath = "//*[@text='Have an account already? Log in']")
    @iOSXCUITFindBy(accessibility = "btn_login")
    private WebElement btn_login;*/

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Phone, email, or username']")
    @iOSXCUITFindBy(accessibility = "txt_username")
    private WebElement txt_username;

    //
    //@AndroidFindBy(id = "com.twitter.android:id/sign_in_text")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Next']")
    @iOSXCUITFindBy(accessibility = "btn_next")
    private WebElement btn_next;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone or username']")
    @iOSXCUITFindBy(accessibility = "btn_next")
    private WebElement txt_username_or_phone;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Password']")
    @iOSXCUITFindBy(accessibility = "txt_password")
    private WebElement txt_password;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log in']")
    @iOSXCUITFindBy(accessibility = "btn_login_page")
    private WebElement btn_login_page;

    public LoginPage(PlatformDriver platform, AppiumDriver driver) {
        this.platform = platform;
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void login(String username, String password) {

        //Cierra la ventana emergente de iniciar sesión con google
        logger.debug("Identificando ventana emergente de inicio de sesión con google");
        platform.onClickButton(btn_google_option, 10);

        //Dar clic en botón de login para acceder a ingresar el usuario y la contraseña
        logger.debug("Identificando coordenadas de ventana emergente de inicio de sesión con google");
        platform.onClickButtonLink(driver, 650, 2250, 3);

        //Ingresar usuario, dar clic en botón next, depués ingresar password y dar clic en login
        logger.debug("Identificado objeto para ingresar el usuario o correo");
        platform.writeText(txt_username,username);

        logger.debug("Identificado botón \'next\'");
        platform.onClickButton(btn_next, 3);

        logger.debug("Identificado objeto para ingresar el usuario o correo");
        platform.writeText(txt_username_or_phone, "Login123Pr88282");

        logger.debug("Identificado botón \'next\'");
        platform.onClickButton(btn_next, 3);

        logger.debug("Identificado objeto para ingresar contrasenia");
        platform.writeText(txt_password, password);

        logger.debug("Identificado botón para finalizar el login");
        platform.onClickButton(btn_login_page, 3);
    }
}
