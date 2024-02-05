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

    public String getCartItemName(){
        return cartItemName.getText();
    }

    public void assertIfCartItemNameIsEqual(String expected) {
        Assert.assertEquals(cartItemName.getText(),expected);
    }
}
