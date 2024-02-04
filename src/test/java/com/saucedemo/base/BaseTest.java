package com.saucedemo.base;

import com.saucedemo.constants.BrowserType;
import com.saucedemo.factory.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static WebDriverWait wait;

    private static void setDriver(WebDriver driver){
        BaseTest.driver.set(driver);
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public static void startDriver(@Optional String browser){
        browser = browser == null ? "FIREFOX" : System.getProperty("browser",browser);
        setDriver(DriverManagerFactory.getManager(BrowserType.valueOf(browser)).createDriver());
        System.out.println("CURRENT THREAD:" + Thread.currentThread().getId());
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    }

    @AfterMethod
    public static void quitDriver() throws IOException {
        System.out.println("CURRENT THREAD:" + Thread.currentThread().getId());
        getDriver().quit();

    }
}
