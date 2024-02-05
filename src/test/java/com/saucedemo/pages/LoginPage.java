package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.saucedemo.base.BaseTest.getDriver;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@id = 'user-name']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@id = 'password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@id = 'login-button']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@class = 'error-message-container error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static LoginPage action(){
        return new LoginPage(getDriver());
    }

    public LoginPage load(){
        load("/");
        return this;
    }

    public LoginPage writeUsernameField(String text) {
        usernameField.sendKeys(text);
        return this;
    }

    public LoginPage writePasswordField(String text) {
        passwordField.sendKeys(text);
        return this;
    }

    public LoginPage clickLoginButton(){
        loginButton.click();
        return this;
    }

    public LoginPage loginValido(){
        writeUsernameField("standard_user");
        writePasswordField("secret_sauce");
        clickLoginButton();
        return this;
    }

    public void assertIfErrorMessageIsEqual(String expected) {
        System.out.println(expected);
        Assert.assertEquals(errorMessage.getText(),expected);
    }
}
