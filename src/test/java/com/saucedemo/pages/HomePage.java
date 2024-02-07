package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.saucedemo.base.BaseTest.getDriver;

public class HomePage extends BasePage {
    @FindBy(xpath = "//span[@class = 'title']")
    private WebElement titleHomePage;
    @FindBy(xpath = "//a[@class = 'shopping_cart_link']")
    private WebElement goToCartButton;
    @FindBy(xpath = "//button[@id = 'react-burger-menu-btn']")
    private WebElement menuButton;
    @FindBy(xpath = "//a[@id = 'reset_sidebar_link']")
    private WebElement resetAppStateButton;
    private By addToCartButton = By.xpath("//button[@id = 'add-to-cart-']");
    private By removeFromCartButton = By.xpath("//button[@id = 'remove-']");
    private By cartItemLabel = By.xpath("//div[@class = 'cart_item']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static HomePage action() {
        return new HomePage(getDriver());
    }

    public HomePage load() {
        load("/inventory.html");
        return this;
    }

    public CartPage clickGoToCartButton() {
        goToCartButton.click();
        return new CartPage(driver);
    }

    private By getAddToCartBtnElement(String productTag) {
        return By.xpath("//button[@id = 'add-to-cart-" + productTag + "']");
    }

    private By getRemoveFromCartBtnElement(String productTag) {
        return By.xpath("//button[@id = 'remove-" + productTag + "']");
    }

    public HomePage clickAddToCartButton(String productName) {
        By addToCartButton = getAddToCartBtnElement(productNameToTag(productName));
        driver.findElement(addToCartButton).click();
        return this;
    }

    public HomePage clickRemoveFromCartButton(String productName) {
        By removeFromCartButton = getRemoveFromCartBtnElement(productNameToTag(productName));
        driver.findElement(removeFromCartButton).click();
        return this;
    }

    public void assertIfTitleIsEqual(String expected) {
        System.out.println(expected);
        Assert.assertEquals(titleHomePage.getText(),expected);
    }

    public String productNameToTag(String productName){
        return productName.toLowerCase().replaceAll("[\\s]","-");
    }

    public void resetAppState() throws InterruptedException {
        menuButton.click();
        Thread.sleep(1000);
        resetAppStateButton.click();
    }

    public void assertIfCartItemQtIsEqual(int quantity) {
        /*System.out.println(driver.findElements(By.xpath("//div[@class = 'cart_item']")).size());
        Assert.assertEquals(driver.findElements(By.xpath("//div[@class = 'cart_item']")).size(),quantity);*/
        System.out.println(driver.findElements(cartItemLabel).size());
        Assert.assertEquals(driver.findElements(cartItemLabel).size(),quantity);
    }
}
