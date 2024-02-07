#language: pt
#encoding: utf-8

@Test
@TestCart
Funcionalidade: Cenarios de teste da página de carrinho

  Cenario: Finalizando a compra de um produto com sucesso
    Dado que eu faço um login com uma conta valida
    Quando eu clicar no botão add to cart no item "Sauce Labs Backpack"
    E eu clicar no botão para acessar o carrinho
    E eu clicar no botão de checkout e inserir dados validos
    E eu clicar no botão de finalizar compra
    Entao a compra será finalizada com sucesso