package com.saucedemo.stepdef;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.HomePage;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CartStepDef {
    @E("eu clicar no botão de checkout e inserir dados validos")
    public void euClicarNoBotãoDeCheckoutEInserirDadosValidos() {
        CartPage.action().clickCheckoutButton().
                writeCheckoutFirstNameField("Rafael").
                writeCheckoutLastNameField("Macabu").
                writeCheckoutPostalCodeField("9999").
                clickCheckoutContinue();
    }

    @E("eu clicar no botão de finalizar compra")
    public void euClicarNoBotãoDeFinalizarCompra() {
        CartPage.action().clickCheckoutFinish();
    }

    @Entao("a compra será finalizada com sucesso")
    public void aCompraSeráFinalizadaComSucesso() {
        CartPage.action().assertIfCheckoutMessageIsEqual("Thank you for your order!");
    }
}
