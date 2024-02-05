package com.saucedemo.stepdef;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class HomeStepDef {
    @Dado("que eu faço um login com uma conta valida")
    public void queEuFaçoUmLoginComUmaContaValida() {
        LoginPage.action().load().loginValido();
    }

    @Quando("eu clicar no botão add to cart no item {string}")
    public void euClicarNoBotãoAddToCartNoItem(String productName) {
        HomePage.action().clickAddToCartButton(productName);
    }

    @Quando("eu clicar no botão para acessar o carrinho")
    public void euClicarNoBotãoParaAcessarOCarrinho() {
        HomePage.action().clickGoToCartButton();
    }

    @Entao("o item {string} estará presente no carrinho")
    public void oItemEstaráPresenteNoCarrinho(String productName) {
        CartPage.action().assertIfCartItemNameIsEqual(productName);
    }
}
