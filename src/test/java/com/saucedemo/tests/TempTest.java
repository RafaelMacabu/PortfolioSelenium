package com.saucedemo.tests;

import com.saucedemo.base.BasePage;
import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TempTest extends BaseTest {

    @Test
    public void openPageTest() throws InterruptedException {
        LoginPage.action().
                load().
                writeUsernameField("standard_user").
                writePasswordField("secret_sauce").
                clickLoginButton();


        CartPage cartPage = HomePage.action().
                clickAddToCartButton("sauce-labs-backpack").
                clickGoToCartButton();
        Thread.sleep(5000);

        Assert.assertEquals(cartPage.getCartItemName(),"Sauce Labs Backpack");
    }
}
