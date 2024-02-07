package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.saucedemo.base.BaseTest.getDriver;

public class CartPage extends BasePage {
    @FindBy(xpath = "//div[@class = 'inventory_item_name']")
    private WebElement cartItemName;
    @FindBy(xpath = "//button[@id = 'checkout']")
    private WebElement checkoutButton;
    @FindBy(xpath = "//input[@id = 'first-name']")
    private WebElement checkoutInputFirstName;
    @FindBy(xpath = "//input[@id = 'last-name']")
    private WebElement checkoutInputLastName;
    @FindBy(xpath = "//input[@id = 'postal-code']")
    private WebElement checkoutInputPostalCode;
    @FindBy(xpath = "//input[@id = 'continue']")
    private WebElement checkoutContinueButton;
    @FindBy(xpath = "//button[@id = 'finish']")
    private WebElement checkoutFinishButton;
    @FindBy(xpath = "//h2[@class = 'complete-header']")
    private WebElement checkoutCompleteMessage;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static CartPage action(){
        return new CartPage(getDriver());
    }

    public CartPage load(){
        load("/cart.html");
        return this;
    }

    public CartPage writeCheckoutFirstNameField(String text) {
        checkoutInputFirstName.sendKeys(text);
        return this;
    }

    public CartPage writeCheckoutLastNameField(String text) {
        checkoutInputLastName.sendKeys(text);
        return this;
    }

    public CartPage writeCheckoutPostalCodeField(String text) {
        checkoutInputPostalCode.sendKeys(text);
        return this;
    }

    public CartPage clickCheckoutButton(){
        checkoutButton.click();
        return this;
    }

    public CartPage clickCheckoutContinue(){
        checkoutContinueButton.click();
        return this;
    }

    public CartPage clickCheckoutFinish(){
        checkoutFinishButton.click();
        return this;
    }

    public String getCartItemName(){
        return cartItemName.getText();
    }

    public void assertIfCartItemNameIsEqual(String expected) {
        Assert.assertEquals(cartItemName.getText(),expected);
    }

    public void assertIfCheckoutMessageIsEqual(String expected) {
        Assert.assertEquals(checkoutCompleteMessage.getText(),expected);
    }
}
