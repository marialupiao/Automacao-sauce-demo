package testes.funcionalidade;

import br.sefaz.com.base.FuncionalidadesBaseWeb;
import testes.page.OverviewPage;

import static br.sefaz.com.core.DriverFactory.getDriver;

public class OverviewFunc extends FuncionalidadesBaseWeb {

    public static void verOverview() throws Exception {
        new OverviewPage(getDriver())
                .validarTituloPaginaOverview()
                .validarValorSauceLabsBackpack()
                .validarShippingInformation()
                .validarPriceTotal()
                .clicarBotaoFinish();
    }
}
