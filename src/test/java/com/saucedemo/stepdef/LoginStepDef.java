package com.saucedemo.stepdef;

import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginStepDef{
    @Dado("que eu preencho o campo username com {string}")
    public void queEuPreenchoOCampoUsername(String username) {
        LoginPage.action().load().writeUsernameField(username);
    }

    @E("que eu preencho o campo password com {string}")
    public void queEuPreenchoOCampoPassword(String password) {
        LoginPage.action().writePasswordField(password);
    }

    @Quando("eu clicar no botão login")
    public void euClicarNoBotãoLogin() {
        LoginPage.action().clickLoginButton();
    }

    @Entao("estarei na home page")
    public void estareiNaHomePage() {
        HomePage.action().assertIfTitleIsEqual("Products");
    }

    @Entao("aparecerá um erro dizendo que o usuário está banido")
    public void apareceráUmErroDizendoQueOUsuárioEstáBanido() {
        LoginPage.action().assertIfErrorMessageIsEqual("Epic sadface: Sorry, this user has been locked out.");
    }
}
