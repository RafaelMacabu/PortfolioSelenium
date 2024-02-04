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
    private By addToCartButton = By.xpath("//button[@id = 'add-to-cart-']");
    private By removeFromCartButton = By.xpath("//button[@id = 'remove-']");

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

    public String getTitleHomePage() {
        return titleHomePage.getText();
    }

    public HomePage clickAddToCartButton(String productTag) {
        By addToCartButton = getAddToCartBtnElement(productTag);
        driver.findElement(addToCartButton).click();
        return this;
    }

    public HomePage clickRemoveFromCartButton(String productTag) {
        By removeFromCartButton = getRemoveFromCartBtnElement(productTag);
        driver.findElement(removeFromCartButton).click();
        return this;
    }

    public void assertIfTitleIsEqual(String expected) {
        System.out.println(expected);
        Assert.assertEquals(getTitleHomePage(),expected);
    }
}
