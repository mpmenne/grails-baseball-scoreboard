package com.github.grailsbaseballscoreboard;

import cuke4duke.annotation.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverFacade {
    private static Constructor<FirefoxDriver> driverConstructor = getDriverConstructor();

    @SuppressWarnings("unchecked")
    private static Constructor<FirefoxDriver> getDriverConstructor() {
//        String driverName = System.getProperty("webdriver.impl", "org.openqa.selenium.htmlunit.HtmlUnitDriver");
        String driverName = System.getProperty("webdriver.impl", "org.openqa.selenium.firefox.FirefoxDriver");
        try {
            return (Constructor<FirefoxDriver>) Thread.currentThread().getContextClassLoader().loadClass(driverName).getConstructor();
        } catch (Throwable problem) {
            problem.printStackTrace();
            throw new RuntimeException("Couldn't load " + driverName, problem);
        }
    }

    private WebDriver browser;

    public WebDriver getWebDriver() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        if (browser == null) {
            FirefoxDriver htmlUnitDriver = driverConstructor.newInstance();
            browser = htmlUnitDriver;
        }
//	Wait<WebDriver> wait = new WebDriverWait(browser, 30);
        return browser;
    }

    @After
    public void closeBrowser() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (browser != null) {
            browser.close();
            browser.quit();
        }
    }
}
