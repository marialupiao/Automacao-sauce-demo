package testes.funcionalidade;

import br.sefaz.com.base.FuncionalidadesBaseWeb;
import testes.page.CompletePage;

import static br.sefaz.com.core.DriverFactory.getDriver;

public class CompleteFunc extends FuncionalidadesBaseWeb {

    public static void verComplete() throws Exception {
        new CompletePage(getDriver())
                .validarTituloPaginaComplete()
                .validarMensagemThankYou()
                .validarMensagemDescricao()
                .clicarBotaoBackHome()
                .clicarBotaoMenu()
                .clicarLogout();
    }
}
