#language: pt
#encoding: utf-8

@Test
@TestHome
Funcionalidade: Cenarios de teste da página home

  Cenario: Adicionando produto ao carrinho com sucesso
    Dado que eu faço um login com uma conta valida
    Quando eu clicar no botão add to cart no item "Sauce Labs Backpack"
    E eu clicar no botão para acessar o carrinho
    Entao o item "Sauce Labs Backpack" estará presente no carrinho

  Cenario: Adicionando multiplos produtos ao carrinho com sucesso
    Dado que eu faço um login com uma conta valida
    Quando eu clicar no botão add to cart no item "Sauce Labs Backpack"
    E eu clicar no botão add to cart no item "Sauce Labs Bike Light"
    E eu clicar no botão para acessar o carrinho
    Entao terá 2 items no carrinho