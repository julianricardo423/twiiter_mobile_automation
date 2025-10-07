package com.mobile.drivers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;

public class PlatformDriver {

    private static final Logger logger = LoggerFactory.getLogger(PlatformDriver.class);

    private AppiumDriver driver;
    private Wait<AppiumDriver> fluentWait;

    public PlatformDriver(AppiumDriver driver) {
        this.driver = driver;
        fluentWait = new FluentWait<AppiumDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
    }


    /**
     * Función para poder escribir en una caja de texto en específico, (no realiza tab, solo escribe)
     *
     * @param elementTxt WebElement para realizar la acción
     * @param text Texto en el que se requere escribir
     */
    public void writeText(WebElement elementTxt, String text) {
        try{
            Thread.sleep(Duration.ofSeconds(3));
            fluentWait.until(ExpectedConditions.visibilityOf(elementTxt));
            elementTxt.sendKeys(text);
            logger.info("Se ha ingresado el texto correspondiente");
        }catch(Exception e){
            logger.warn("El elemento no ha sido encontrado ya que actualmente no se visible en la página");
        }
    }

    /**
     * Función para poder dar clic en un botón en específico
     * @param elementBtn WebElement para realizar la acción
     * @param secondsToWait Segundos los cuales debe esperar para identificar el objeto
     */
    public void onClickButton(WebElement elementBtn, int secondsToWait) {
        try{
            Thread.sleep(Duration.ofSeconds(secondsToWait));
            fluentWait.until(ExpectedConditions.elementToBeClickable(elementBtn));
            elementBtn.click();
            logger.info("Se ha dado clic en el botón correspondiente");
        }catch(Exception e){
            logger.warn("El elemento no ha sido encontrado ya que actualmente no se visible en la página");
        }
    }

    /**
     * Función para dar clic a un botón por medio de coordenandas
     * @param driver appiumDriver inicializado anteriormente
     * @param x coordenadas de x
     * @param y coordenadas de y
     * @param secondsToWait Segundos los cuales se debe esperar para identificar el objeto
     */
    public void onClickButtonLink(AppiumDriver driver, int x, int y, int secondsToWait) {
        try{
            Thread.sleep(Duration.ofSeconds(secondsToWait));

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence tap = new Sequence(finger, 1);

            tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(tap));
            logger.info("Se dado clic en el link correspondiente de acuerdo a las coordenadas ingresadas");

        }catch(Exception e){
            logger.warn("El elemento no ha sido encontrado ya que actualmente no se visible en la página");
        }
    }

    /**
     *
     * Función para devolver un texto en especifico de acuerdo al page
     * @param sectionText WebElement para realizar la acción
     * @return string
     */
    public String homePageMessage(WebElement sectionText){
        String textoEncontrado = "";
        try{
            Thread.sleep(Duration.ofSeconds(3));
            fluentWait.until(ExpectedConditions.visibilityOf(sectionText));
            textoEncontrado = sectionText.getText();
            logger.info("Se ha obtenido el texto " + textoEncontrado + " en el home page");
        }catch(Exception e){
            logger.warn("El elemento no ha sido encontrado ya que actualmente no se visible en la página");
        }

        return textoEncontrado;
    }
}
