#language: pt
#encoding: utf-8

@Test
@TestLogin
Funcionalidade: Cenarios de teste da página de login

  Cenario: Login realizado com sucesso
    Dado que eu preencho o campo username com "standard_user"
    E que eu preencho o campo password com "secret_sauce"
    Quando eu clicar no botão login
    Entao estarei na home page

  Cenario: Login com usuário banido
    Dado que eu preencho o campo username com "locked_out_user"
    E que eu preencho o campo password com "secret_sauce"
    Quando eu clicar no botão login
    Entao aparecerá um erro dizendo que o usuário está banido