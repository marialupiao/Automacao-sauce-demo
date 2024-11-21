#language: pt
Funcionalidade: Login na pagina Sauce
  Eu, como usuario, quero Logar na pagina Sauce

  Contexto: acessar a pagina Sauce
    Dado que eu acesse o site

  @Executa
    Cenario: Logar com sucesso
    Quando Logo no sistema com sucesso
    E testo todos componentes
    E testo todos componentes da pagina cart
    E testo os componentes da pagina de checkout
    E testo os componentes da Pagina Overview
    E testo os componentes da pagina Complete
    Entao Finaliza o sistema

