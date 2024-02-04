package com.saucedemo.base;

import com.saucedemo.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);

    }
}
