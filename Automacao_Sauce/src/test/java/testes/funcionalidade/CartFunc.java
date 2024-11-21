package testes.funcionalidade;

import br.sefaz.com.base.FuncionalidadesBaseWeb;
import testes.page.CartPage;

import static br.sefaz.com.core.DriverFactory.getDriver;

public class CartFunc extends FuncionalidadesBaseWeb {

    public static void verCarrinho() throws Exception {
        new CartPage(getDriver())
                .clicarNoCarrinho()
                .validarItemNoCarrinho()
                .validarTituloPaginaCarrinho()
                .validarIconeCarrinho()
                .clicarNoBtnCheckout();

    }

}
